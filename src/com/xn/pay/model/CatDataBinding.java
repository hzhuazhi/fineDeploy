package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.Date;

public class CatDataBinding extends BasePage {
    /**
     * 自增主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 原始数据的ID：对应表tb_fn_cat_all_data的主键ID
     *
     * @mbggenerated
     */
    private Long allId;

    /**
     * 归属小微管理的主键ID：对应表tb_fn_wx的主键ID
     *
     * @mbggenerated
     */
    private Long wxId;

    /**
     * 可爱猫的to_wxid
     *
     * @mbggenerated
     */
    private String toWxid;

    /**
     * 微信名称
     *
     * @mbggenerated
     */
    private String wxName;

    /**
     * 用户收款账号ID：对应表tb_fn_did_collection_account的主键ID；也就是具体上下线的账号
     *
     * @mbggenerated
     */
    private Long collectionAccountId;

    /**
     * 创建日期：存的日期格式20160530
     *
     * @mbggenerated
     */
    private Integer curday;

    /**
     * 创建所属小时：24小时制
     *
     * @mbggenerated
     */
    private Integer curhour;

    /**
     * 创建所属分钟：60分钟制
     *
     * @mbggenerated
     */
    private Integer curminute;

    /**
     * 数据类型：1初始化，2补充失败，3补充数据成功
     *
     * @mbggenerated
     */
    private Integer workType;

    /**
     * 数据匹配的类型：1根据小微ID跟微信昵称不能匹配到收款账号，2根据小微ID跟微信昵称能匹配到收款账号
     *
     * @mbggenerated
     */
    private Integer matchingType;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 运行计算次数
     *
     * @mbggenerated
     */
    private Integer runNum;

    /**
     * 运行计算状态：：0初始化，1锁定，2计算失败，3计算成功
     *
     * @mbggenerated
     */
    private Integer runStatus;

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

    public Long getAllId() {
        return allId;
    }

    public void setAllId(Long allId) {
        this.allId = allId;
    }

    public Long getWxId() {
        return wxId;
    }

    public void setWxId(Long wxId) {
        this.wxId = wxId;
    }

    public String getToWxid() {
        return toWxid;
    }

    public void setToWxid(String toWxid) {
        this.toWxid = toWxid;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public Long getCollectionAccountId() {
        return collectionAccountId;
    }

    public void setCollectionAccountId(Long collectionAccountId) {
        this.collectionAccountId = collectionAccountId;
    }

    public Integer getCurday() {
        return curday;
    }

    public void setCurday(Integer curday) {
        this.curday = curday;
    }

    public Integer getCurhour() {
        return curhour;
    }

    public void setCurhour(Integer curhour) {
        this.curhour = curhour;
    }

    public Integer getCurminute() {
        return curminute;
    }

    public void setCurminute(Integer curminute) {
        this.curminute = curminute;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getMatchingType() {
        return matchingType;
    }

    public void setMatchingType(Integer matchingType) {
        this.matchingType = matchingType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRunNum() {
        return runNum;
    }

    public void setRunNum(Integer runNum) {
        this.runNum = runNum;
    }

    public Integer getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
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