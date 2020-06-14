package com.xn.pay.service;

import com.xn.common.service.BaseService;

/**
 * @Description 用户和小微审核
 * @Date 2020/5/28 10:49
 * @Version 1.0
 */
public interface CollectionAccountService <T> extends BaseService<T> {
    void wxIdUpdateCheckStatus(Long wxId);
}
