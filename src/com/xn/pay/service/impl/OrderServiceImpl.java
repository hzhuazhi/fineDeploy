package com.xn.pay.service.impl;

import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.OrderDao;
import com.xn.pay.model.OrderModel;
import com.xn.pay.service.OrderService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 订单的Service层的实现层
 * @Author yoko
 * @Date 2020/8/4 11:44
 * @Version 1.0
 */
@Service
public class OrderServiceImpl<T> extends BaseServiceImpl<T> implements OrderService<T> {
    private static Logger log= Logger.getLogger(BankServiceImpl.class);

    @Autowired
    private OrderDao<T> orderDao;
    @Override
    public OrderDao<T> getDao() {
        // TODO Auto-generated method stub
        return orderDao;
    }

    @Override
    public OrderModel getTotalData(OrderModel model) {
        return orderDao.getTotalData(model);
    }
}
