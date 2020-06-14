package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.MobileCardDao;

import com.xn.pay.model.MobileCard;
import com.xn.pay.service.MobileCardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Date 2020/5/21 19:27
 * @Version 1.0
 */
@Service
public class MobileCardServiceImpl  <T> extends BaseServiceImpl<T> implements MobileCardService<T> {
    private static Logger log=Logger.getLogger(MobileCardServiceImpl.class);

    @Autowired
    private MobileCardDao<T> mobileCardDao;
    @Override
    public BaseDao<T> getDao() {
        // TODO Auto-generated method stub
        return mobileCardDao;
    }
}
