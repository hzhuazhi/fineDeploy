package com.xn.pay.service;

import com.xn.common.service.BaseService;
import com.xn.pay.model.TeamModel;

/**
 * @Description 团队长旗下数据的Service层
 * @Author yoko
 * @Date 2020/6/14 12:46
 * @Version 1.0
 */
public interface TeamService <T> extends BaseService<T> {

    /**
     * @Description: 获取团队长旗下的汇总数据
     * @param model
     * @return 
     * @author yoko
     * @date 2020/6/14 13:27 
    */
    public TeamModel getTeamData(TeamModel model);

    /**
     * @Description: 获取团队长旗下当日消耗成功订单金额的汇总
     * @param model
     * @return
     * @author yoko
     * @date 2020/6/14 13:30
    */
    public String getTotalOrderMoney(TeamModel model);

    /**
     * @Description: 获取团队长旗下金额档次人数
     * @param model
     * @return
     * @author yoko
     * @date 2020/6/14 13:50
    */
    public int getMoneyNum(TeamModel model);
}
