package com.xn.pay.dao;

import com.xn.common.dao.BaseDao;

/**
 * @Description 小微旗下店员
 * @Date 2020/5/28 14:09
 * @Version 1.0
 */
public interface WxClerkDao  <T> extends BaseDao<T> {
    int  deleteCollectionAccountId(Long collectionAccountId);
    int  deleteAll(Long wxId);
}
