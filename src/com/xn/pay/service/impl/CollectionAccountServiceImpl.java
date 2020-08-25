package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.CollectionAccountDao;
import com.xn.pay.dao.MobileCardDao;
import com.xn.pay.model.CollectionAccount;
import com.xn.pay.service.CollectionAccountService;
import com.xn.pay.service.SmallBusinessesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/28 10:58
 * @Version 1.0
 */
@Service
public class CollectionAccountServiceImpl <T> extends BaseServiceImpl<T> implements CollectionAccountService<T> {
    private static Logger log=Logger.getLogger(CollectionAccountServiceImpl.class);

    @Autowired
    private CollectionAccountDao<T> collectionAccountDao;


    @Override
    public BaseDao<T> getDao() {
        return collectionAccountDao;
    }

    @Override
    public void wxIdUpdateCheckStatus(Long wxId) {
        collectionAccountDao.wxIdUpdateCheckStatus(wxId);
    }

    @Override
    public List<CollectionAccount> queryByListPayee(CollectionAccount collectionAccount) {
        return collectionAccountDao.queryByListPayee(collectionAccount);
    }

    @Override
    public int updateStart(CollectionAccount collectionAccount) {
        return collectionAccountDao.updateStart(collectionAccount);
    }

    @Override
    public int updateUseStatus(CollectionAccount model) {
        return collectionAccountDao.updateUseStatus(model);
    }
}
