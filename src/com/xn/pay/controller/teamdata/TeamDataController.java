package com.xn.pay.controller.teamdata;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.enums.ManagerEnum;
import com.xn.common.util.HtmlUtil;
import com.xn.common.util.MD5;
import com.xn.pay.controller.accountteam.AccountTeamController;
import com.xn.pay.model.AccountTeamModel;
import com.xn.pay.model.TeamDataModel;
import com.xn.pay.service.AccountTeamService;
import com.xn.pay.service.TeamDataService;
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
 * @Description 团队长旗下数据详情的Controller层
 * @Author yoko
 * @Date 2020/6/14 15:00
 * @Version 1.0
 */
@Controller
@RequestMapping("/teamdata")
public class TeamDataController extends BaseController {

    private static Logger log = Logger.getLogger(TeamDataController.class);

    @Autowired
    private TeamDataService<TeamDataModel> teamDataService;


    /**
     * 获取页面
     */
    @RequestMapping("/list")
    public String list() {
        return "pay/teamdata/teamdataIndex";
    }


    /**
     *
     * 获取表格数据列表
     */
    @RequestMapping("/dataList")
    public void dataList(HttpServletRequest request, HttpServletResponse response, TeamDataModel model) throws Exception {
        List<TeamDataModel> dataList = new ArrayList<TeamDataModel>();
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() != ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                //不是管理员，只能查询自己的数据
                model.setOwnId(account.getDid());
            }
            dataList = teamDataService.queryByList(model);
        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
    }

}
