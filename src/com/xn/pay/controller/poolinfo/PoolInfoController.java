package com.xn.pay.controller.poolinfo;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.util.HtmlUtil;
import com.xn.common.util.StringUtil;
import com.xn.pay.model.PoolInfoModel;
import com.xn.pay.service.PoolInfoService;
import com.xn.system.entity.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 池子的信息的Controller层
 * @Author yoko
 * @Date 2020/8/25 17:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/poolinfo")
public class PoolInfoController extends BaseController {

    private static Logger log = Logger.getLogger(PoolInfoController.class);

    @Autowired
    private PoolInfoService<PoolInfoModel> poolInfoService;


    /**
     * 获取页面
     */
    @RequestMapping("/list")
    public String list() {
        return "pay/poolinfo/poolinfoIndex";
    }


    /**
     *
     * 获取表格数据列表
     */
    @RequestMapping("/dataList")
    public void dataList(HttpServletRequest request, HttpServletResponse response, PoolInfoModel model) throws Exception {
        List<PoolInfoModel> dataList = new ArrayList<PoolInfoModel>();
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account != null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() == ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                //是管理员
                if (model.getDataType() == 1){
                    // 查询等待池的信息
                    dataList = poolInfoService.queryByWaitList(model);
                }else if (model.getDataType() == 2){
                    // 查询抢单池的信息
                    dataList = poolInfoService.queryByOpenList(model);
                }else if (model.getDataType() == 3){
                    // 查询等待池、抢单池的信息
                    dataList = poolInfoService.queryByList(model);
                }else{
                    // 查询等待池、抢单池的信息
                    dataList = poolInfoService.queryByList(model);
                }
            }
        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
    }


    /**
     *
     * 获取订单汇总数据
     */
    @RequestMapping("/totalData")
    public void totalData(HttpServletRequest request, HttpServletResponse response, PoolInfoModel model) throws Exception {
        PoolInfoModel data = new PoolInfoModel();

        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() == ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                int waitDidNum = 0;// 等待池的用户数
                int waitGroupNum = 0;// 等待池的群数量
                int waitRedPackNum = 0;// 等待池红包数
                String waitBalance = "0.00";// 等待池余额
                String waitUseMoney = "0.00";// 等待池可用金额

                int openDidNum = 0;// 抢单池的用户数
                int openGroupNum = 0;// 抢单池的群数量
                int openRedPackNum = 0;// 抢单池红包数
                String openBalance = "0.00";// 抢单池余额
                String openUseMoney = "0.00";// 抢单池可用金额

                int totalDidNum = 0;// 汇总的用户数
                int totalGroupNum = 0;// 汇总的群数量
                int totalRedPackNum = 0;// 汇总红包数
                String totalBalance = "0.00";// 汇总余额
                String totalUseMoney = "0.00";// 汇总可用金额

                List<Long> waitDidList = new ArrayList<>();// 等待池中的用户集合
                List<Long> openDidList = new ArrayList<>();// 清单池中的用户集合

                // 获取等待池中的用户集合ID
                waitDidList = poolInfoService.getWaitDidList();

                // 获取抢单池中的用户集合ID
                openDidList = poolInfoService.getOpenDidList();

                if (waitDidList != null && waitDidList.size() > 0){
                    PoolInfoModel poolInfoQuery = new PoolInfoModel();
                    poolInfoQuery.setIdList(waitDidList);

                    // 获取等待池的用户数
                    waitDidNum = waitDidList.size();
                    // 获取等待池的群数量
                    waitGroupNum = poolInfoService.countWaitGroupNum(poolInfoQuery);
                    // 获取等待池红包数
                    waitRedPackNum = poolInfoService.countWaitRedPackNum(poolInfoQuery);
                    // 获取等待池余额
                    waitBalance = poolInfoService.countWaitBalance(poolInfoQuery);
                    // 获取等待池可用金额
                    waitUseMoney = poolInfoService.countWaitUseMoney(poolInfoQuery);
                }

                if (openDidList != null && openDidList.size() > 0){
                    PoolInfoModel poolInfoQuery = new PoolInfoModel();
                    poolInfoQuery.setIdList(openDidList);

                    // 获取抢单池的用户数
                    openDidNum = openDidList.size();
                    // 获取抢单池的群数量
                    openGroupNum = poolInfoService.countOpenGroupNum(poolInfoQuery);
                    // 获取抢单池红包数
                    openRedPackNum = poolInfoService.countOpenRedPackNum(poolInfoQuery);
                    // 获取抢单池余额
                    openBalance = poolInfoService.countOpenBalance(poolInfoQuery);
                    // 获取抢单池可用金额
                    openUseMoney = poolInfoService.countOpenUseMoney(poolInfoQuery);
                }


                totalDidNum = waitDidNum + openDidNum;
                totalGroupNum = waitGroupNum + openGroupNum;
                totalRedPackNum = waitRedPackNum + openRedPackNum;
                totalBalance = StringUtil.getBigDecimalAdd(waitBalance, openBalance);
                if (totalBalance.equals("0")){
                    totalBalance = "0.00";
                }
                totalUseMoney = StringUtil.getBigDecimalAdd(waitUseMoney, openUseMoney);
                if (totalUseMoney.equals("0")){
                    totalUseMoney = "0.00";
                }

                data.setWaitDidNum(waitDidNum);
                data.setWaitGroupNum(waitGroupNum);
                data.setWaitRedPackNum(waitRedPackNum);
                data.setWaitBalance(waitBalance);
                data.setWaitUseMoney(waitUseMoney);
                data.setOpenDidNum(openDidNum);
                data.setOpenGroupNum(openGroupNum);
                data.setOpenRedPackNum(openRedPackNum);
                data.setOpenBalance(openBalance);
                data.setOpenUseMoney(openUseMoney);
                data.setTotalDidNum(totalDidNum);
                data.setTotalGroupNum(totalGroupNum);
                data.setTotalRedPackNum(totalRedPackNum);
                data.setTotalBalance(totalBalance);
                data.setTotalUseMoney(totalUseMoney);
            }
        }
        HtmlUtil.writerJson(response, data);
    }



    /**
     * 删除数据
     */
    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, PoolInfoModel model) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            model.setYn(1);
            if (model.getPoolType() == 1){
                poolInfoService.updateWaitDid(model);
            }else if (model.getPoolType() == 2){
                poolInfoService.updateOpenDid(model);
            }
            sendSuccessMessage(response, "删除成功");
        }else{
            sendFailureMessage(response, "登录超时,请重新登录在操作!");
        }

    }

    /**
     * 启用/禁用
     */
    @RequestMapping("/manyOperation")
    public void manyOperation(HttpServletRequest request, HttpServletResponse response, PoolInfoModel model) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            model.setUseStatus(1);
            poolInfoService.updateDidCollectionAccountUseStatus(model);
            sendSuccessMessage(response, "状态更新成功");
        }else{
            sendFailureMessage(response, "登录超时,请重新登录在操作!");
        }
    }


}
