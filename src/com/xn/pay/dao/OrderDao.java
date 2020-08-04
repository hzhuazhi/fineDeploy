package com.xn.pay.dao;

import com.xn.common.dao.BaseDao;
import com.xn.pay.model.OrderModel;

/**
 * @Description 订单的Dao层
 * @Author yoko
 * @Date 2020/8/4 11:42
 * @Version 1.0
 */
public interface OrderDao<T> extends BaseDao<T> {

    /**
     * @Description: 获取订单的total信息
     * @param model
     * @return
     * @author yoko
     * @date 2020/3/27 17:56
     */
    public OrderModel getTotalData(OrderModel model);
}
