package com.xn.pay.service.impl;

import com.xn.common.dao.BaseDao;
import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.MobileCardDataDao;
import com.xn.pay.service.MobileCardDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 手机卡所有短信内容数据的Service层的实现层
 * @Author yoko
 * @Date 2020/7/12 21:24
 * @Version 1.0
 */
@Service("mobileCardDataService")
public class MobileCardDataServiceImpl<T> extends BaseServiceImpl<T> implements MobileCardDataService<T> {

    private static Logger log=Logger.getLogger(MobileCardDataServiceImpl.class);

    @Autowired
    private MobileCardDataDao<T> mobileCardDataDao;
    @Override
    public BaseDao<T> getDao() {
        // TODO Auto-generated method stub
        return mobileCardDataDao;
    }
}
