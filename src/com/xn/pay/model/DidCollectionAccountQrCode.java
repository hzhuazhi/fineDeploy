package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.Date;

public class DidCollectionAccountQrCode extends BasePage {
    /**
     * 自增主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户收款账号ID：对应表tb_fn_did_collection_account的主键ID
     *
     * @mbggenerated
     */
    private Long collectionAccountId;

    /**
     * 别名
     *
     * @mbggenerated
     */
    private String alias;

    /**
     * 收款账号/地址（原）：二维码
     *
     * @mbggenerated
     */
    private String mmQrCode;

    /**
     * 收款账号/地址（转码）：二维码
     *
     * @mbggenerated
     */
    private String ddQrCode;

    /**
     * 二维码类型：1普通二维码，2个人固码，3固定金额码，4认证商家固码
     *
     * @mbggenerated
     */
    private Integer dataType;

    /**
     * 码的金额：固码的具体金额
     *
     * @mbggenerated
     */
    private String qrCodeMoney;

    /**
     * 可使用次数：可以给出多少次
     *
     * @mbggenerated
     */
    private Integer limitNum;

    /**
     * 已经使用次数：已经给出多少次
     *
     * @mbggenerated
     */
    private Integer isLimitNum;

    /**
     * 使用状态:1初始化有效正常使用，2无效暂停使用
     *
     * @mbggenerated
     */
    private Integer useStatus;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

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

    public Long getCollectionAccountId() {
        return collectionAccountId;
    }

    public void setCollectionAccountId(Long collectionAccountId) {
        this.collectionAccountId = collectionAccountId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getQrCodeMoney() {
        return qrCodeMoney;
    }

    public void setQrCodeMoney(String qrCodeMoney) {
        this.qrCodeMoney = qrCodeMoney;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public Integer getIsLimitNum() {
        return isLimitNum;
    }

    public void setIsLimitNum(Integer isLimitNum) {
        this.isLimitNum = isLimitNum;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}