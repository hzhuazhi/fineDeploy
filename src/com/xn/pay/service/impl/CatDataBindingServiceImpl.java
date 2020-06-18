package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.CatDataBindingDao;
import com.xn.pay.dao.CollectionAccountDao;
import com.xn.pay.model.CatDataBinding;
import com.xn.pay.model.CollectionAccount;
import com.xn.pay.service.CatDataBindingService;
import com.xn.pay.service.CollectionAccountService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/6/16 21:13
 * @Version 1.0
 */

@Service("catDataBindingService")
public class CatDataBindingServiceImpl<T> extends BaseServiceImpl<T> implements CatDataBindingService<T> {
    private static Logger log= Logger.getLogger(CatDataBindingServiceImpl.class);

    @Autowired
    private CollectionAccountService<CollectionAccount> collectionAccountService;

    @Autowired
    private CatDataBindingDao catDataBindingDao;

    @Autowired
    private CollectionAccountDao collectionAccountDao;



    @Override
    public BaseDao<T> getDao() {
        return catDataBindingDao;
    }



    @Transactional(rollbackFor=Exception.class)
    @Override
    public int bindingSmail(CatDataBinding catDataBinding)throws Exception {
//        collectionAccountService.update(collectionAccount);
        catDataBindingDao.update(catDataBinding);
        return 1;
    }
}
