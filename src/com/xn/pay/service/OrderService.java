package com.xn.pay.service;

import com.xn.common.service.BaseService;
import com.xn.pay.model.OrderModel;

/**
 * @Description 订单的Service层
 * @Author yoko
 * @Date 2020/8/4 11:43
 * @Version 1.0
 */
public interface OrderService<T> extends BaseService<T> {

    /**
     * @Description: 获取订单的total信息
     * @param model
     * @return
     * @author yoko
     * @date 2020/3/27 17:56
     */
    public OrderModel getTotalData(OrderModel model);
}
