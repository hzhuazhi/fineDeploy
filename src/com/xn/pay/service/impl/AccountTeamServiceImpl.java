package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.AccountTeamDao;
import com.xn.pay.service.AccountTeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 团队长账号的Service层的实现层
 * @Author yoko
 * @Date 2020/6/14 11:32
 * @Version 1.0
 */
@Service("accountTeamService")
public class AccountTeamServiceImpl <T> extends BaseServiceImpl<T> implements AccountTeamService<T> {

    private static Logger log=Logger.getLogger(AccountTeamServiceImpl.class);

    @Autowired
    private AccountTeamDao<T> accountTeamDao;
    @Override
    public BaseDao<T> getDao() {
        // TODO Auto-generated method stub
        return accountTeamDao;
    }
}
