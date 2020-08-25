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

    int updateStart(CollectionAccount account);

    /**
     * @Description: 根据小薇ID修改收款账号的使用暂停状态
     * @param model - 收款账号基本信息
     * @return
     * @author long
     * @date 2020/8/18 20:30
     */
    public int updateUseStatus(CollectionAccount model);
}
