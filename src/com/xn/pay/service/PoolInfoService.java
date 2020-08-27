package com.xn.pay.service;

import com.xn.common.service.BaseService;
import com.xn.pay.model.PoolInfoModel;

import java.util.List;

/**
 * @Description 池子的信息的Service层
 * @Author yoko
 * @Date 2020/8/25 17:22
 * @Version 1.0
 */
public interface PoolInfoService<T> extends BaseService<T> {

    /**
     * @Description: 分页-查询等待池的数据
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/25 20:51
     */
    public List<PoolInfoModel> queryByWaitList(PoolInfoModel model);

    /**
     * @Description: 分页-查询抢单池的数据
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/25 20:51
     */
    public List<PoolInfoModel> queryByOpenList(PoolInfoModel model);


    /**
     * @Description: 获取等待池中的用户集合ID
     * @return
     * @author yoko
     * @date 2020/8/26 19:12
     */
    public List<Long> getWaitDidList();

    /**
     * @Description: 获取抢单池中的用户集合ID
     * @return
     * @author yoko
     * @date 2020/8/26 19:12
     */
    public List<Long> getOpenDidList();


    /**
     * @Description: 获取等待池的用户数
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
    */
    public int countWaitDidNum(PoolInfoModel model);

    /**
     * @Description: 获取抢单池的用户数
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public int countOpenDidNum(PoolInfoModel model);

    /**
     * @Description: 获取等待池的群数
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public int countWaitGroupNum(PoolInfoModel model);

    /**
     * @Description: 获取抢单池的群数
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public int countOpenGroupNum(PoolInfoModel model);

    /**
     * @Description: 获取等待池的红包数
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public int countWaitRedPackNum(PoolInfoModel model);

    /**
     * @Description: 获取抢单池的红包数
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public int countOpenRedPackNum(PoolInfoModel model);

    /**
     * @Description: 获取等待池的余额
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public String countWaitBalance(PoolInfoModel model);

    /**
     * @Description: 获取抢单池的余额
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public String countOpenBalance(PoolInfoModel model);


    /**
     * @Description: 获取等待池的可用金额
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public String countWaitUseMoney(PoolInfoModel model);

    /**
     * @Description: 获取抢单池的可用金额
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 18:51
     */
    public String countOpenUseMoney(PoolInfoModel model);


    /**
     * @Description: 移出等待池
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 20:44
     */
    public int updateWaitDid(PoolInfoModel model);

    /**
     * @Description: 移出抢单池
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/26 20:44
     */
    public int updateOpenDid(PoolInfoModel model);

    /**
     * @Description: 暂停微信群
     * @param model
     * @return
     * @author yoko
     * @date 2020/8/27 10:51
     */
    public int updateDidCollectionAccountUseStatus(PoolInfoModel model);


}
