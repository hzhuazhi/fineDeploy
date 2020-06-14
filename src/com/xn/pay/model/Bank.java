package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.Date;

public class Bank extends BasePage {
    /**
     * 自增主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 手机卡名称
     *
     * @mbggenerated
     */
    private String cardName;

    /**
     * 归属手机号ID：对应表tb_fn_mobile_card的主键ID
     *
     * @mbggenerated
     */
    private Long mobileCardId;

    /**
     * 银行名称/归属开户行
     *
     * @mbggenerated
     */
    private String bankName;

    /**
     * 银行卡账号/银行卡号
     *
     * @mbggenerated
     */
    private String bankCard;

    /**
     * 银行支行/支行名称
     *
     * @mbggenerated
     */
    private String subbranchName;

    /**
     * 开户名
     *
     * @mbggenerated
     */
    private String accountName;

    /**
     * 开户地省份/所在省份
     *
     * @mbggenerated
     */
    private String province;

    /**
     * 开户地城市/所在城市
     *
     * @mbggenerated
     */
    private String city;

    /**
     * 银行卡类型：归属策略里面的银行卡类型的ID
     *
     * @mbggenerated
     */
    private Long bankType;

    /**
     * 回调对照凭证短信来源:例如招商银行的是95555
     *
     * @mbggenerated
     */
    private String smsNum;

    /**
     * 回调对照凭证银行卡尾号：收到短信后，短信内容尾号xxxx收款
     *
     * @mbggenerated
     */
    private String lastNum;

    /**
     * 回调对照凭证内容：这里内容是多个内容，以英文逗号进行隔开。
            例如：【南京银行】您尾号5298的账号与10月10日15时11份收到由无锡公司汇入的300.00元。
            这里的凭证内容：这里内容是多个内容，以英文逗号进行隔开。例如：【南京银行】您尾号5298的账号与10月10日15时11份收到由无锡公司汇入的300.00元。这里的凭证内容：南京银行,5298,汇入
     *
     * @mbggenerated
     */
    private String smsContent;

    /**
     * 回调对照金额截取截取开始字段
     *
     * @mbggenerated
     */
    private String startKey;

    /**
     * 回调对照金额截取截取结束字段
     *
     * @mbggenerated
     */
    private String endKey;

    /**
     * 是否有特殊属性优先级高需要快速消耗：1无特殊属性，2有特殊属性
     *
     * @mbggenerated
     */
    private Integer specialType;

    /**
     * 开启类型：1白天，2晚上，3两者都支持；银行卡是白天跑还是晚上跑数据
     *
     * @mbggenerated
     */
    private Integer openType;

    /**
     * 日开关是否启用（等于1正常使用，其它是暂停）:：1正常使用，2暂停使用
     *
     * @mbggenerated
     */
    private Integer daySwitch;

    /**
     * 月开关是否启用：1正常使用，2暂停使用
     *
     * @mbggenerated
     */
    private Integer monthSwitch;

    /**
     * 总开关是否启用：1正常使用，2暂停使用
     *
     * @mbggenerated
     */
    private Integer totalSwitch;

    /**
     * 使用状态:1初始化有效正常使用，2无效暂停使用
     *
     * @mbggenerated
     */
    private Integer useStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * TS时间
     *
     * @mbggenerated
     */
    private Date tsTime;
    /**
     * 日收款金额
     *
     * @mbggenerated
     */
    private String inDayMoney;
    /**
     * 总转账金额
     *
     * @mbggenerated
     */
    private String outTotalMoney;
    /**
     * 日转账金额
     *
     * @mbggenerated
     */
    private String outDayMoney;
    /**
     * 月收款金额
     *
     * @mbggenerated
     */
    private String inMonthMoney;
    /**
     * 月转账金额
     *
     * @mbggenerated
     */
    private String outMonthMoney;
    /**
     * 总收款金额
     *
     * @mbggenerated
     */
    private String inTotalMoney;

    /**
     * 是否有效：0有效，1无效/删除
     *
     * @mbggenerated
     */
    private Integer yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMobileCardId() {
        return mobileCardId;
    }

    public void setMobileCardId(Long mobileCardId) {
        this.mobileCardId = mobileCardId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getSubbranchName() {
        return subbranchName;
    }

    public void setSubbranchName(String subbranchName) {
        this.subbranchName = subbranchName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getBankType() {
        return bankType;
    }

    public void setBankType(Long bankType) {
        this.bankType = bankType;
    }

    public String getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(String smsNum) {
        this.smsNum = smsNum;
    }

    public String getLastNum() {
        return lastNum;
    }

    public void setLastNum(String lastNum) {
        this.lastNum = lastNum;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getStartKey() {
        return startKey;
    }

    public void setStartKey(String startKey) {
        this.startKey = startKey;
    }

    public String getEndKey() {
        return endKey;
    }

    public void setEndKey(String endKey) {
        this.endKey = endKey;
    }

    public Integer getSpecialType() {
        return specialType;
    }

    public void setSpecialType(Integer specialType) {
        this.specialType = specialType;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public Integer getDaySwitch() {
        return daySwitch;
    }

    public void setDaySwitch(Integer daySwitch) {
        this.daySwitch = daySwitch;
    }

    public Integer getMonthSwitch() {
        return monthSwitch;
    }

    public void setMonthSwitch(Integer monthSwitch) {
        this.monthSwitch = monthSwitch;
    }

    public Integer getTotalSwitch() {
        return totalSwitch;
    }

    public void setTotalSwitch(Integer totalSwitch) {
        this.totalSwitch = totalSwitch;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getTsTime() {
        return tsTime;
    }

    public void setTsTime(Date tsTime) {
        this.tsTime = tsTime;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getInDayMoney() {
        return inDayMoney;
    }

    public void setInDayMoney(String inDayMoney) {
        this.inDayMoney = inDayMoney;
    }

    public String getOutTotalMoney() {
        return outTotalMoney;
    }

    public void setOutTotalMoney(String outTotalMoney) {
        this.outTotalMoney = outTotalMoney;
    }

    public String getOutDayMoney() {
        return outDayMoney;
    }

    public void setOutDayMoney(String outDayMoney) {
        this.outDayMoney = outDayMoney;
    }

    public String getInMonthMoney() {
        return inMonthMoney;
    }

    public void setInMonthMoney(String inMonthMoney) {
        this.inMonthMoney = inMonthMoney;
    }

    public String getOutMonthMoney() {
        return outMonthMoney;
    }

    public void setOutMonthMoney(String outMonthMoney) {
        this.outMonthMoney = outMonthMoney;
    }

    public String getInTotalMoney() {
        return inTotalMoney;
    }

    public void setInTotalMoney(String inTotalMoney) {
        this.inTotalMoney = inTotalMoney;
    }
}