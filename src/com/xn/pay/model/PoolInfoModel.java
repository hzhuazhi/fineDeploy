package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.List;

/**
 * @Description 池子的信息的实体属性Bean
 * @Author yoko
 * @Date 2020/8/25 17:35
 * @Version 1.0
 */
public class PoolInfoModel extends BasePage {

    /**
     * 池子的主键ID
     */
    private long id;

    /**
     * 池子类型：1等待池子，2抢单池
     */
    private int poolType;

    /**
     * 数据类型：1等待池子，2抢单池子，3两个池子汇总
     */
    private int dataType;

    /**
     * 用户ID：对应表tb_fn_did的主键ID
     */
    private long did;

    /**
     * 用户账号的昵称
     */
    private String nickname;

    /**
     * 用户手机号
     */
    private String phoneNum;

    /**
     * 用户余额
     */
    private String balance;

    /**
     * 用户锁定金额
     */
    private String lockMoney;

    /**
     * 用户可使用的金额
     * <p>
     *     用户可用金额=用户余额+用户锁定金额
     * </p>
     */
    private String useMoney;

    /**
     * 收款账号ID
     */
    private long collectionAccountId;

    /**
     * 小微主键ID
     */
    private long wxId;

    /**
     * 小微昵称
     */
    private String wxName;

    /**
     * 原二维码
     */
    private String mmQrCode;

    /**
     * 解析后的二维码
     */
    private String ddQrCode;

    /**
     * 群名称
     */
    private String payee;

    /**
     * 收款账号的微信昵称
     */
    private String bankName;

    /**
     * 可收的红包个数
     */
    private int redPackNum;

    /**
     * 池子创建时间
     */
    private String createTime;


    /**
     *
     *等待池的用户数
     */
    private int waitDidNum;

    /**
     * 等待池的群数量
     */
    private int waitGroupNum;

    /**
     * 等待池红包数
     */
    private int waitRedPackNum;

    /**
     * 等待池余额
     */
    private String waitBalance;

    /**
     * 等待池可用金额
     */
    private String waitUseMoney;


    /**
     *
     *抢单池的用户数
     */
    private int openDidNum;

    /**
     * 抢单池的群数量
     */
    private int openGroupNum;

    /**
     * 抢单池红包数
     */
    private int openRedPackNum;

    /**
     * 抢单池余额
     */
    private String openBalance;

    /**
     * 抢单池可用金额
     */
    private String openUseMoney;

    /**
     *
     *汇总的用户数
     */
    private int totalDidNum;

    /**
     * 汇总的群数量
     */
    private int totalGroupNum;

    /**
     * 汇总红包数
     */
    private int totalRedPackNum;

    /**
     * 汇总余额
     */
    private String totalBalance;

    /**
     * 汇总可用金额
     */
    private String totalUseMoney;


    /**
     * 集合-SQL
     */
    private List<Long> idList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPoolType() {
        return poolType;
    }

    public void setPoolType(int poolType) {
        this.poolType = poolType;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getLockMoney() {
        return lockMoney;
    }

    public void setLockMoney(String lockMoney) {
        this.lockMoney = lockMoney;
    }

    public String getUseMoney() {
        return useMoney;
    }

    public void setUseMoney(String useMoney) {
        this.useMoney = useMoney;
    }

    public long getCollectionAccountId() {
        return collectionAccountId;
    }

    public void setCollectionAccountId(long collectionAccountId) {
        this.collectionAccountId = collectionAccountId;
    }

    public long getWxId() {
        return wxId;
    }

    public void setWxId(long wxId) {
        this.wxId = wxId;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getMmQrCode() {
        return mmQrCode;
    }

    public void setMmQrCode(String mmQrCode) {
        this.mmQrCode = mmQrCode;
    }

    public String getDdQrCode() {
        return ddQrCode;
    }

    public void setDdQrCode(String ddQrCode) {
        this.ddQrCode = ddQrCode;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getRedPackNum() {
        return redPackNum;
    }

    public void setRedPackNum(int redPackNum) {
        this.redPackNum = redPackNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getWaitDidNum() {
        return waitDidNum;
    }

    public void setWaitDidNum(int waitDidNum) {
        this.waitDidNum = waitDidNum;
    }

    public int getWaitGroupNum() {
        return waitGroupNum;
    }

    public void setWaitGroupNum(int waitGroupNum) {
        this.waitGroupNum = waitGroupNum;
    }

    public int getWaitRedPackNum() {
        return waitRedPackNum;
    }

    public void setWaitRedPackNum(int waitRedPackNum) {
        this.waitRedPackNum = waitRedPackNum;
    }

    public String getWaitBalance() {
        return waitBalance;
    }

    public void setWaitBalance(String waitBalance) {
        this.waitBalance = waitBalance;
    }

    public String getWaitUseMoney() {
        return waitUseMoney;
    }

    public void setWaitUseMoney(String waitUseMoney) {
        this.waitUseMoney = waitUseMoney;
    }

    public int getOpenDidNum() {
        return openDidNum;
    }

    public void setOpenDidNum(int openDidNum) {
        this.openDidNum = openDidNum;
    }

    public int getOpenGroupNum() {
        return openGroupNum;
    }

    public void setOpenGroupNum(int openGroupNum) {
        this.openGroupNum = openGroupNum;
    }

    public int getOpenRedPackNum() {
        return openRedPackNum;
    }

    public void setOpenRedPackNum(int openRedPackNum) {
        this.openRedPackNum = openRedPackNum;
    }

    public String getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(String openBalance) {
        this.openBalance = openBalance;
    }

    public String getOpenUseMoney() {
        return openUseMoney;
    }

    public void setOpenUseMoney(String openUseMoney) {
        this.openUseMoney = openUseMoney;
    }

    public int getTotalDidNum() {
        return totalDidNum;
    }

    public void setTotalDidNum(int totalDidNum) {
        this.totalDidNum = totalDidNum;
    }

    public int getTotalGroupNum() {
        return totalGroupNum;
    }

    public void setTotalGroupNum(int totalGroupNum) {
        this.totalGroupNum = totalGroupNum;
    }

    public int getTotalRedPackNum() {
        return totalRedPackNum;
    }

    public void setTotalRedPackNum(int totalRedPackNum) {
        this.totalRedPackNum = totalRedPackNum;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getTotalUseMoney() {
        return totalUseMoney;
    }

    public void setTotalUseMoney(String totalUseMoney) {
        this.totalUseMoney = totalUseMoney;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
