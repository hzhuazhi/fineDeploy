package com.xn.pay.controller.team;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.enums.ManagerEnum;
import com.xn.common.util.DateUtil;
import com.xn.common.util.HtmlUtil;
import com.xn.pay.model.TeamModel;
import com.xn.pay.service.TeamService;
import com.xn.system.entity.Account;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description 团队长旗下数据的
 * @Author yoko
 * @Date 2020/6/14 12:54
 * @Version 1.0
 */
@Controller
@RequestMapping("/team")
public class TeamController extends BaseController {

    private static Logger log = Logger.getLogger(TeamController.class);

    @Autowired
    private TeamService<TeamModel> teamService;


    /**
     * 获取页面
     */
    @RequestMapping("/list")
    public String list() {
        return "pay/team/teamIndex";
    }


    /**
     *
     * 获取表格数据列表
     */
    @RequestMapping("/dataList")
    public void dataList(HttpServletRequest request, HttpServletResponse response, TeamModel model) throws Exception {
        List<TeamModel> dataList = new ArrayList<TeamModel>();
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account != null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() == ManagerEnum.RoleTypeEnum.TEAM.getRoleType()){

                TeamModel dataModel = new TeamModel();

                // 获取团队长旗下的汇总数据
                TeamModel teamDataQuery = new TeamModel();
                teamDataQuery.setOwnId(account.getDid());
                dataModel = teamService.getTeamData(teamDataQuery);

                // 获取团队长旗下当日消耗成功订单金额的汇总
                TeamModel totalOrderMoneyQuery = new TeamModel();
                totalOrderMoneyQuery.setOwnId(account.getDid());
                totalOrderMoneyQuery.setCurday(DateUtil.getDayNumber(new Date()));
                String totalOrderMoney = teamService.getTotalOrderMoney(totalOrderMoneyQuery);
                if (!StringUtils.isBlank(totalOrderMoney)){
                    dataModel.setTotalOrderMoney(totalOrderMoney);
                }else {
                    dataModel.setTotalOrderMoney("0.00");
                }

                // 获取档次1的余额人数
                TeamModel oneQuery = new TeamModel();
                oneQuery.setOwnId(account.getDid());
                BigDecimal one = new BigDecimal(5000);
                oneQuery.setMoney(one);
                int oneMoneyNum = teamService.getMoneyNum(oneQuery);
                dataModel.setOneMoneyNum(oneMoneyNum);

                // 获取档次2的余额人数
                TeamModel twoQuery = new TeamModel();
                twoQuery.setOwnId(account.getDid());
                BigDecimal two_start = new BigDecimal(1000);
                BigDecimal two_end = new BigDecimal(4999.99);
                twoQuery.setStartMoney(two_start);
                twoQuery.setEndMoney(two_end);
                int twoMoneyNum = teamService.getMoneyNum(twoQuery);
                dataModel.setTwoMoneyNum(twoMoneyNum);

                // 获取档次3的余额人数
                TeamModel threeQuery = new TeamModel();
                threeQuery.setOwnId(account.getDid());
                BigDecimal three_start = new BigDecimal(500);
                BigDecimal three_end = new BigDecimal(999.99);
                threeQuery.setStartMoney(three_start);
                threeQuery.setEndMoney(three_end);
                int threeMoneyNum = teamService.getMoneyNum(threeQuery);
                dataModel.setThreeMoneyNum(threeMoneyNum);


                // 获取档次4的余额人数
                TeamModel fourQuery = new TeamModel();
                fourQuery.setOwnId(account.getDid());
                BigDecimal four_start = new BigDecimal(100);
                BigDecimal four_end = new BigDecimal(499.99);
                fourQuery.setStartMoney(four_start);
                fourQuery.setEndMoney(four_end);
                int fourMoneyNum = teamService.getMoneyNum(fourQuery);
                dataModel.setFourMoneyNum(fourMoneyNum);


                // 获取档次5的余额人数
                TeamModel fiveQuery = new TeamModel();
                fiveQuery.setOwnId(account.getDid());
                BigDecimal five = new BigDecimal(99.99);
                fiveQuery.setMinMoney(five);
                int fiveMoneyNum = teamService.getMoneyNum(fiveQuery);
                dataModel.setFiveMoneyNum(fiveMoneyNum);

                dataList.add(dataModel);
//                return;
            }

        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
    }
}
