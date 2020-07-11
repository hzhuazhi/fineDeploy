package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.DidRechargeDao;
import com.xn.pay.service.DidRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户充值记录的Service层
 * @Author yoko
 * @Date 2020/5/21 14:15
 * @Version 1.0
 */
@Service("didRechargeService")
public class DidRechargeServiceImpl<T> extends BaseServiceImpl<T> implements DidRechargeService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private DidRechargeDao didRechargeDao;

    public BaseDao<T> getDao() {
        return didRechargeDao;
    }

}
