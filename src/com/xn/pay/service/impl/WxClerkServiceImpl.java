package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.SmallBusinessesDao;
import com.xn.pay.dao.WxClerkDao;
import com.xn.pay.service.WxClerkService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/28 14:46
 * @Version 1.0
 */
@Service
public class WxClerkServiceImpl   <T> extends BaseServiceImpl<T> implements WxClerkService<T> {

    private static Logger log= Logger.getLogger(WxClerkServiceImpl.class);

    @Autowired
    private WxClerkDao<T> wxClerkDao;

    @Override
    public BaseDao<T> getDao() {
        return wxClerkDao;
    }

    @Override
    public int deleteCollectionAccountId(long id) {
        return wxClerkDao.deleteCollectionAccountId(id);
    }

    @Override
    public int deleteAll(long wxId) {
        return wxClerkDao.deleteAll(wxId);
    }
}
