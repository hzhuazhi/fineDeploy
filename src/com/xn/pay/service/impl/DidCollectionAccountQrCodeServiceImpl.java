package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.DidCollectionAccountQrCodeDao;
import com.xn.pay.service.DidCollectionAccountQrCodeService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/6/18 13:26
 * @Version 1.0
 */


@Service("didCollectionAccountQrCodeService")
public class DidCollectionAccountQrCodeServiceImpl<T> extends BaseServiceImpl<T> implements DidCollectionAccountQrCodeService<T> {

    private static Logger log= Logger.getLogger(DidCollectionAccountQrCodeServiceImpl.class);

    @Autowired
    private DidCollectionAccountQrCodeDao didCollectionAccountQrCodeDao;

    @Override
    public BaseDao<T> getDao() {
        return didCollectionAccountQrCodeDao;
    }
}
