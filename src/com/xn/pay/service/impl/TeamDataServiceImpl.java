package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.TeamDataDao;
import com.xn.pay.service.TeamDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 团队长旗下数据详情的Service层的实现层
 * @Author yoko
 * @Date 2020/6/14 14:57
 * @Version 1.0
 */
@Service("teamDataService")
public class TeamDataServiceImpl <T> extends BaseServiceImpl<T> implements TeamDataService<T> {

    private static Logger log=Logger.getLogger(TeamDataServiceImpl.class);

    @Autowired
    private TeamDataDao<T> teamDataDao;
    @Override
    public BaseDao<T> getDao() {
        // TODO Auto-generated method stub
        return teamDataDao;
    }
}
