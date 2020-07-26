package com.xn.pay.dao;

import com.xn.common.dao.BaseDao;
import com.xn.pay.model.CollectionAccount;

import java.util.List;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/28 10:45
 * @Version 1.0
 */
public interface CollectionAccountDao <T> extends BaseDao<T> {
    //小微删除更新状态
    void   wxIdUpdateCheckStatus(Long wxId);
    List<CollectionAccount> queryByListPayee(CollectionAccount account);
}
