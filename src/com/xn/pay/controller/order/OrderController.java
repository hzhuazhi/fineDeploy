package com.xn.pay.controller.order;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.util.BeanUtils;
import com.xn.common.util.DateUtil;
import com.xn.common.util.ExportData;
import com.xn.common.util.HtmlUtil;
import com.xn.pay.controller.mobilecarddata.MobileCardDataController;
import com.xn.pay.model.MobileCardDataModel;
import com.xn.pay.model.OrderModel;
import com.xn.pay.service.MobileCardDataService;
import com.xn.pay.service.OrderService;
import com.xn.system.entity.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description 订单信息
 * @Author yoko
 * @Date 2020/8/4 11:40
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    private static Logger log = Logger.getLogger(OrderController.class);

    @Autowired
    private OrderService<OrderModel> orderService;


    /**
     * 获取页面
     */
    @RequestMapping("/list")
    public String list() {
        return "pay/order/orderIndex";
    }


    /**
     *
     * 获取表格数据列表
     */
    @RequestMapping("/dataList")
    public void dataList(HttpServletRequest request, HttpServletResponse response, OrderModel model) throws Exception {
        List<OrderModel> dataList = new ArrayList<OrderModel>();
        if (model.getCurdayStart() == 0 || model.getCurdayEnd() == 0){
            model.setCurdayStart(DateUtil.getDayNumber(new Date()));
            model.setCurdayEnd(DateUtil.getDayNumber(new Date()));
        }
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account != null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() == ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                //是管理员
                dataList = orderService.queryByList(model);
            }
        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
    }


    /**
     *
     * 获取订单汇总数据
     */
    @RequestMapping("/totalData")
    public void totalData(HttpServletRequest request, HttpServletResponse response, OrderModel model) throws Exception {
        OrderModel data = new OrderModel();
        if (model.getCurdayStart() ==0 || model.getCurdayEnd() == 0){
            model.setCurdayStart(DateUtil.getDayNumber(new Date()));
            model.setCurdayEnd(DateUtil.getDayNumber(new Date()));
        }
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() == ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                data = orderService.getTotalData(model);
            }
        }
        HtmlUtil.writerJson(response, data);
    }



    /**
     * 按照Excel报表导出数据
     */
    @RequestMapping("/exportData")
    public void exportDataNew(HttpServletRequest request, HttpServletResponse response, OrderModel model) throws Exception {
        exportData(request,response,model);
    }


    /**
     * 实际导出Excel
     * @param request
     * @param response
     * @param model
     */
    public void exportData(HttpServletRequest request, HttpServletResponse response, OrderModel model) {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){

            if (model.getCurdayStart() ==0 || model.getCurdayEnd() == 0){
                model.setCurdayStart(DateUtil.getDayNumber(new Date()));
                model.setCurdayEnd(DateUtil.getDayNumber(new Date()));
            }
            List<OrderModel> dataList = new ArrayList<OrderModel>();
            dataList = orderService.queryAllList(model);
            // 导出数据
            String[] titles = new String[10];
            String[] titleCode = new String[10];
            String filename = "派单详情";
            titles = new String[]{"订单号", "订单金额","用户昵称", "注册账号", "收款类型", "收款二维码", "微信群", "订单状态", "失效时间", "支付宝ID/微信ID", "支付宝账号/微信群ID",
                    "收益", "是否发红包", "发红包时间", "是否回复", "回复类容", "回复时间", "回复的实际金额", "金额是否与上报金额一致", "是否是补单", "备注", "创建日期", "创建时间"};
            titleCode = new String[]{"orderNo", "orderMoney", "nickname", "acNum", "collectionTypeStr", "qrCode", "wxNickname", "orderStatusStr", "invalidTime", "userId", "zfbAcNum",
            "profit", "isRedPackStr", "redPackTime", "isReplyStr", "replyData", "replyTime", "actualMoney", "moneyFitTypeStr", "replenishTypeStr", "remark", "curday", "createTime"};
            List<Map<String,Object>> paramList = new ArrayList<>();
            for(OrderModel paramO : dataList){

                if (paramO.getCollectionType() == 1){
                    paramO.setCollectionTypeStr("微信个码");
                }else if (paramO.getCollectionType() == 2){
                    paramO.setCollectionTypeStr("支付宝个码");
                }else if (paramO.getCollectionType() == 3){
                    paramO.setCollectionTypeStr("微信群");
                }

                if (paramO.getOrderStatus() == 1){
                    paramO.setOrderStatusStr("初始化");
                }else if (paramO.getOrderStatus() == 2){
                    paramO.setOrderStatusStr("超时/失败");
                }else if (paramO.getOrderStatus() == 3){
                    paramO.setOrderStatusStr("质疑");
                }else if (paramO.getOrderStatus() == 4){
                    paramO.setOrderStatusStr("成功");
                }

                if (paramO.getIsRedPack() == 1){
                    paramO.setIsRedPackStr("初始化/未发红包");
                }else if (paramO.getIsRedPack() == 2){
                    paramO.setIsRedPackStr("已发红包");
                }

                if (paramO.getIsReply() == 1){
                    paramO.setIsReplyStr("初始化/未回复");
                }else if (paramO.getIsReply() == 2){
                    paramO.setIsReplyStr("系统默认回复");
                }else if (paramO.getIsReply() == 3){
                    paramO.setIsReplyStr("回复失败");
                }else if (paramO.getIsReply() == 4){
                    paramO.setIsReplyStr("回复成功");
                }

                if (paramO.getMoneyFitType() == 1){
                    paramO.setMoneyFitTypeStr("初始化");
                }else if (paramO.getMoneyFitType() == 2){
                    paramO.setMoneyFitTypeStr("少了");
                }else if (paramO.getMoneyFitType() == 3){
                    paramO.setMoneyFitTypeStr("多了");
                }else if (paramO.getMoneyFitType() == 4){
                    paramO.setMoneyFitTypeStr("一致");
                }

                if (paramO.getReplenishType() == 1){
                    paramO.setReplenishTypeStr("初始化/不是补单");
                }else if (paramO.getReplenishType() == 2){
                    paramO.setReplenishTypeStr("是补单");
                }



                Map<String,Object> map = BeanUtils.transBeanToMap(paramO);
                paramList.add(map);
            }
            ExportData.exportExcel(paramList, titles, titleCode, filename, response);
        }
    }
}
