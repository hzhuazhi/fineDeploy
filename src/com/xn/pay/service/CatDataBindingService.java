package com.xn.pay.service;

import com.xn.common.service.BaseService;
import com.xn.pay.model.CatDataBinding;
import com.xn.pay.model.CollectionAccount;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/6/16 21:12
 * @Version 1.0
 */
public interface CatDataBindingService<T> extends BaseService<T> {
    public int  bindingSmail(CatDataBinding  catDataBinding)throws Exception;
}
