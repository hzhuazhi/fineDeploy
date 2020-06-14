package com.xn.pay.service;

import com.xn.common.service.BaseService;

/**
 * @Description 小微旗下店员
 * @Date 2020/5/28 14:36
 * @Version 1.0
 */
public interface WxClerkService <T> extends BaseService<T> {
    public  int deleteCollectionAccountId(long id);
    public  int deleteAll(long wxId);
}
