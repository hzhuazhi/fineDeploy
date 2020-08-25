package com.xn.pay.service;

import com.xn.common.service.BaseService;
import com.xn.pay.model.CollectionAccount;

import java.util.List;

/**
 * @Description 用户和小微审核
 * @Date 2020/5/28 10:49
 * @Version 1.0
 */
public interface CollectionAccountService <T> extends BaseService<T> {
    void wxIdUpdateCheckStatus(Long wxId);
    List<CollectionAccount> queryByListPayee(CollectionAccount  collectionAccount);
    int  updateStart(CollectionAccount  collectionAccount);

    /**
     * @Description: 根据小薇ID修改收款账号的使用暂停状态
     * @param model - 收款账号基本信息
     * @return
     * @author long
     * @date 2020/8/18 20:30
    */
    public int updateUseStatus(CollectionAccount model);
}
