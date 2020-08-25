package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.SmallBusinessesDao;
import com.xn.pay.model.CollectionAccount;
import com.xn.pay.model.WxClerk;
import com.xn.pay.service.CollectionAccountService;
import com.xn.pay.service.SmallBusinessesService;
import com.xn.pay.service.WxClerkService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/27 19:39
 * @Version 1.0
 */
@Service
public class SmallBusinessesServiceImpl <T> extends BaseServiceImpl<T> implements SmallBusinessesService<T> {
    private static Logger log= Logger.getLogger(SmallBusinessesServiceImpl.class);


    @Autowired
    private CollectionAccountService<CollectionAccount> collectionAccountService;

    @Autowired
    private WxClerkService<WxClerk> wxClerkService;


    @Autowired
    private SmallBusinessesDao<T> smallBusinessesDao;

    @Override
    public BaseDao<T> getDao() {
        return smallBusinessesDao;
    }


    @Override
    public void updateRemarks(long wxId) {
        wxClerkService.deleteAll(wxId);
        CollectionAccount   collectionAccount = new CollectionAccount();
        collectionAccount.setWxId(wxId);
        collectionAccount.setCheckInfo("检测小微二维码失效");
        collectionAccount.setCheckStatus(1);
        collectionAccountService.updateStart(collectionAccount);

    }
}
