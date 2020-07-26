package com.xn.pay.service.impl;

import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.OperateDao;
import com.xn.pay.service.OperateService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2020/7/23 18:59
 * @Version 1.0
 */
@Service
public class OperateServiceImpl<T> extends BaseServiceImpl<T> implements OperateService<T> {
    private static Logger log= Logger.getLogger(OperateServiceImpl.class);

    @Autowired
    private OperateDao<T> operateDao;

    @Override
    public OperateDao<T> getDao() {
        // TODO Auto-generated method stub
        return operateDao;
    }
}
