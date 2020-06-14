package com.xn.pay.dao;

import com.xn.common.dao.BaseDao;
import com.xn.pay.model.TeamModel;

/**
 * @Description 团队长旗下数据的Dao层
 * @Author yoko
 * @Date 2020/6/14 12:44
 * @Version 1.0
 */
public interface TeamDao<T> extends BaseDao<T> {

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
