package com.xn.pay.model;


import com.xn.common.page.BasePage;

import java.io.Serializable;

/**
 * @Description 用户充值记录的实体属性Bean
 * @Author yoko
 * @Date 2020/5/21 11:33
 * @Version 1.0
 */
public class DidRechargeModel extends BasePage implements Serializable {
    private static final long   serialVersionUID = 1203223201109L;

    /**
     * 主键ID
     */
    private long id;

    /**
     * 归属用户ID：对应表tb_fn_did的主键ID
     */
    private long did;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单归属的策略金额ID：在策略里面所归属的ID
     */
    private long moneyId;

    /**
     * 订单金额
     */
    private String orderMoney;

    /**
     * 派分给用户的订单金额：假如用户要充值5000，我们可以给他派分成4999.91
     */
    private String distributionMoney;

    /**
     * 归属银行卡ID：对应表tb_fn_bank的主键ID
     */
    private long bankId;

    /**
     * 充值记录银行卡转账图片凭证
     */
    private String pictureAds;

    /**
     * 失效时间
     */
    private String invalidTime;

    /**
     * 订单状态：1初始化，2超时/失败，3成功
     */
    private int orderStatus;

    /**
     *存款人
     */
    private String depositor;

    /**
     * 存款金额
     */
    private String depositMoney;

    /**
     * 存款时间
     */
    private String depositTime;

    /**
     * 存款账号尾号
     */
    private String lastNum;

    /**
     * 存款数据录入状态（存款人，存款人时间，尾号）：1初始化，2录入完毕
     */
    private int workType;

    /**
     * 申诉状态：1初始化，2申诉中，3申诉失败，4申诉成功
     */
    private int appealStatus;

    /**
     * 申诉失败原因：描述申诉结果的原因
     */
    private String appealOrigin;

    /**
     * 充值接口的类型：1微信规则充值，2新规则充值
     */
    private int dataType;

    /**
     * 审核状态：1初始化，2审核中，3审核失败，4审核通过/成功
     */
    private int checkStatus;

    /**
     * 审核缘由/审核备注
     */
    private String checkInfo;

    /**
     * 创建日期：存的日期格式20160530
     */
    private int curday;

    /**
     * 创建所属小时：24小时制
     */
    private int curhour;

    /**
     * 创建所属分钟：60分钟制
     */
    private int curminute;

    /**
     *运行计算次数
     */
    private int runNum;

    /**
     * 运行计算状态：：0初始化，1锁定，2计算失败，3计算成功
     */
    private int runStatus;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 是否有效：0有效，1无效/删除
     */
    private int yn;

    private int curdayStart;
    private int curdayEnd;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行卡卡号
     */
    private String bankCard;

    /**
     * 开户名
     */
    private String accountName;


    public DidRechargeModel(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public long getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(long moneyId) {
        this.moneyId = moneyId;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getDistributionMoney() {
        return distributionMoney;
    }

    public void setDistributionMoney(String distributionMoney) {
        this.distributionMoney = distributionMoney;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public String getPictureAds() {
        return pictureAds;
    }

    public void setPictureAds(String pictureAds) {
        this.pictureAds = pictureAds;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(String depositMoney) {
        this.depositMoney = depositMoney;
    }

    public String getDepositTime() {
        return depositTime;
    }

    public void setDepositTime(String depositTime) {
        this.depositTime = depositTime;
    }

    public String getLastNum() {
        return lastNum;
    }

    public void setLastNum(String lastNum) {
        this.lastNum = lastNum;
    }

    public int getWorkType() {
        return workType;
    }

    public void setWorkType(int workType) {
        this.workType = workType;
    }

    public int getAppealStatus() {
        return appealStatus;
    }

    public void setAppealStatus(int appealStatus) {
        this.appealStatus = appealStatus;
    }

    public String getAppealOrigin() {
        return appealOrigin;
    }

    public void setAppealOrigin(String appealOrigin) {
        this.appealOrigin = appealOrigin;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(String checkInfo) {
        this.checkInfo = checkInfo;
    }

    public int getCurday() {
        return curday;
    }

    public void setCurday(int curday) {
        this.curday = curday;
    }

    public int getCurhour() {
        return curhour;
    }

    public void setCurhour(int curhour) {
        this.curhour = curhour;
    }

    public int getCurminute() {
        return curminute;
    }

    public void setCurminute(int curminute) {
        this.curminute = curminute;
    }

    public int getRunNum() {
        return runNum;
    }

    public void setRunNum(int runNum) {
        this.runNum = runNum;
    }

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public int getCurdayStart() {
        return curdayStart;
    }

    public void setCurdayStart(int curdayStart) {
        this.curdayStart = curdayStart;
    }

    public int getCurdayEnd() {
        return curdayEnd;
    }

    public void setCurdayEnd(int curdayEnd) {
        this.curdayEnd = curdayEnd;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
