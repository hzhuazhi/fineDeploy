package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.TeamDao;
import com.xn.pay.model.TeamModel;
import com.xn.pay.service.TeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 团队长旗下数据的Service层的实现层
 * @Author yoko
 * @Date 2020/6/14 12:47
 * @Version 1.0
 */
@Service("teamService")
public class TeamServiceImpl <T> extends BaseServiceImpl<T> implements TeamService<T> {

    private static Logger log=Logger.getLogger(TeamServiceImpl.class);

    @Autowired
    private TeamDao<T> teamDao;
    @Override
    public BaseDao<T> getDao() {
        // TODO Auto-generated method stub
        return teamDao;
    }

    @Override
    public TeamModel getTeamData(TeamModel model) {
        return teamDao.getTeamData(model);
    }

    @Override
    public String getTotalOrderMoney(TeamModel model) {
        return teamDao.getTotalOrderMoney(model);
    }

    @Override
    public int getMoneyNum(TeamModel model) {
        return teamDao.getMoneyNum(model);
    }
}
