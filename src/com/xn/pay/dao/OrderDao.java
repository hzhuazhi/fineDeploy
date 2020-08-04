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

    /**
     * @Description: 查询订单数量
     * <p>
     *     所有订单数、支付订单数、质疑订单数
     * </p>
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/4 17:32
    */
    public int countOrder(OrderModel model);

    /**
     * @Description: 计算成功订单金额
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/4 17:44
    */
    public String sumOrderMoney(OrderModel model);

    /**
     * @Description: 查询用户进群的数量
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/4 17:34
    */
    public int countComeInGroup(OrderModel model);


}
