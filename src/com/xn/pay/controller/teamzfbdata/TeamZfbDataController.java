package com.xn.pay.controller.teamzfbdata;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.util.DateUtil;
import com.xn.common.util.HtmlUtil;
import com.xn.pay.controller.teamdata.TeamDataController;
import com.xn.pay.model.TeamDataModel;
import com.xn.pay.model.TeamZfbDataModel;
import com.xn.pay.service.TeamDataService;
import com.xn.pay.service.TeamZfbDataService;
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
 * @Description 团队长旗下支付宝账号数据详情的Controller层
 * @Author yoko
 * @Date 2020/7/12 15:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/teamzfbdata")
public class TeamZfbDataController extends BaseController {

    private static Logger log = Logger.getLogger(TeamZfbDataController.class);

    @Autowired
    private TeamZfbDataService<TeamZfbDataModel> teamZfbDataService;


    /**
     * 获取页面
     */
    @RequestMapping("/list")
    public String list() {
        return "pay/teamzfbdata/teamzfbdataIndex";
    }


    /**
     *
     * 获取表格数据列表
     */
    @RequestMapping("/dataList")
    public void dataList(HttpServletRequest request, HttpServletResponse response, TeamZfbDataModel model) throws Exception {
        List<TeamZfbDataModel> dataList = new ArrayList<TeamZfbDataModel>();
        model.setCurday(DateUtil.getDateInt());
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() != ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                //不是管理员，只能查询自己的数据
                model.setOwnId(account.getDid());
            }
            dataList = teamZfbDataService.queryByList(model);
        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
    }
}
