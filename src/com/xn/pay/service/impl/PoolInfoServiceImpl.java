package com.xn.pay.service.impl;

import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.PoolInfoDao;
import com.xn.pay.model.PoolInfoModel;
import com.xn.pay.service.PoolInfoService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 池子的信息的Service层的实现层
 * @Author yoko
 * @Date 2020/8/25 17:23
 * @Version 1.0
 */
@Service
public class PoolInfoServiceImpl<T> extends BaseServiceImpl<T> implements PoolInfoService<T> {
    private static Logger log= Logger.getLogger(PoolInfoServiceImpl.class);

    @Autowired
    private PoolInfoDao<T> poolInfoDao;
    @Override
    public PoolInfoDao<T> getDao() {
        // TODO Auto-generated method stub
        return poolInfoDao;
    }

    @Override
    public List<PoolInfoModel> queryByWaitList(PoolInfoModel model) {
        Integer rowCount = poolInfoDao.queryByWaitCount(model);
        model.setRowCount(rowCount);
        return poolInfoDao.queryByWaitList(model);
    }

    @Override
    public List<PoolInfoModel> queryByOpenList(PoolInfoModel model) {
        Integer rowCount = poolInfoDao.queryByOpenCount(model);
        model.setRowCount(rowCount);
        return poolInfoDao.queryByOpenList(model);
    }

    @Override
    public List<Long> getWaitDidList() {
        return poolInfoDao.getWaitDidList();
    }

    @Override
    public List<Long> getOpenDidList() {
        return poolInfoDao.getOpenDidList();
    }

    @Override
    public int countWaitDidNum(PoolInfoModel model) {
        return poolInfoDao.countWaitDidNum(model);
    }

    @Override
    public int countOpenDidNum(PoolInfoModel model) {
        return poolInfoDao.countOpenDidNum(model);
    }

    @Override
    public int countWaitGroupNum(PoolInfoModel model) {
        return poolInfoDao.countWaitGroupNum(model);
    }

    @Override
    public int countOpenGroupNum(PoolInfoModel model) {
        return poolInfoDao.countOpenGroupNum(model);
    }

    @Override
    public int countWaitRedPackNum(PoolInfoModel model) {
        return poolInfoDao.countWaitRedPackNum(model);
    }

    @Override
    public int countOpenRedPackNum(PoolInfoModel model) {
        return poolInfoDao.countOpenRedPackNum(model);
    }

    @Override
    public String countWaitBalance(PoolInfoModel model) {
        return poolInfoDao.countWaitBalance(model);
    }

    @Override
    public String countOpenBalance(PoolInfoModel model) {
        return poolInfoDao.countOpenBalance(model);
    }

    @Override
    public String countWaitUseMoney(PoolInfoModel model) {
        return poolInfoDao.countWaitUseMoney(model);
    }

    @Override
    public String countOpenUseMoney(PoolInfoModel model) {
        return poolInfoDao.countOpenUseMoney(model);
    }

    @Override
    public int updateWaitDid(PoolInfoModel model) {
        return poolInfoDao.updateWaitDid(model);
    }

    @Override
    public int updateOpenDid(PoolInfoModel model) {
        return poolInfoDao.updateOpenDid(model);
    }

    @Override
    public int updateDidCollectionAccountUseStatus(PoolInfoModel model) {
        return poolInfoDao.updateDidCollectionAccountUseStatus(model);
    }
}
