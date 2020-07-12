package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.TeamZfbDataDao;
import com.xn.pay.service.TeamZfbDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 团队长旗下支付宝数据详情的Service层的实现层
 * @Author yoko
 * @Date 2020/7/11 17:48
 * @Version 1.0
 */
@Service("teamZfbDataService")
public class TeamZfbDataServiceImpl<T> extends BaseServiceImpl<T> implements TeamZfbDataService<T> {

    private static Logger log=Logger.getLogger(TeamZfbDataServiceImpl.class);

    @Autowired
    private TeamZfbDataDao<T> teamZfbDataDao;
    @Override
    public BaseDao<T> getDao() {
        // TODO Auto-generated method stub
        return teamZfbDataDao;
    }
}
