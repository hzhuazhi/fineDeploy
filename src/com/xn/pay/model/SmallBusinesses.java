package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.Date;

public class SmallBusinesses extends BasePage {
    /**
     * 自增主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 微信账号
     *
     * @mbggenerated
     */
    private String acName;

    /**
     * 微信登录密码
     *
     * @mbggenerated
     */
    private String wxPassWd;

    /**
     * 微信昵称
     *
     * @mbggenerated
     */
    private String wxName;

    /**
     * 可爱猫的to_wxid
     *
     * @mbggenerated
     */
    private String toWxid;

    /**
     * 旗下绑定多少个店员
     *
     * @mbggenerated
     */
    private Integer totalLink;

    /**
     * 手机号具体与手机型号绑定
     *
     * @mbggenerated
     */
    private String bindingMobile;

    /**
     * 使用状态:1初始化有效正常使用，2无效暂停使用
     *
     * @mbggenerated
     */
    private Integer useStatus;
    /**
     * 总共可以加多少个用户
     *
     * @mbggenerated
     */
    private Integer dataNum;
    /**
     * 每日可加用户的数量
     *
     * @mbggenerated
     */
    private Integer dayNum;
    /**
     * 微信名片二维码地址
     *
     * @mbggenerated
     */
    private String wxQrCode;

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

    /**
     * 总共可以加多少个群
     */
    private Integer groupNum;

    /**
     * 已经下了多少个群
     */
    private Integer isGroupNum;

    /**
     * 加群是否以及完成了限制目标：1未完成，2完成
     */
    private Integer isOkGroup;

    /**
     * 每天可加多少个群
     */
    private Integer dayGroupNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getWxPassWd() {
        return wxPassWd;
    }

    public void setWxPassWd(String wxPassWd) {
        this.wxPassWd = wxPassWd;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getToWxid() {
        return toWxid;
    }

    public void setToWxid(String toWxid) {
        this.toWxid = toWxid;
    }

    public Integer getTotalLink() {
        return totalLink;
    }

    public void setTotalLink(Integer totalLink) {
        this.totalLink = totalLink;
    }

    public String getBindingMobile() {
        return bindingMobile;
    }

    public void setBindingMobile(String bindingMobile) {
        this.bindingMobile = bindingMobile;
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

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Integer getDataNum() {
        return dataNum;
    }

    public void setDataNum(Integer dataNum) {
        this.dataNum = dataNum;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public String getWxQrCode() {
        return wxQrCode;
    }

    public void setWxQrCode(String wxQrCode) {
        this.wxQrCode = wxQrCode;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getIsGroupNum() {
        return isGroupNum;
    }

    public void setIsGroupNum(Integer isGroupNum) {
        this.isGroupNum = isGroupNum;
    }

    public Integer getIsOkGroup() {
        return isOkGroup;
    }

    public void setIsOkGroup(Integer isOkGroup) {
        this.isOkGroup = isOkGroup;
    }

    public Integer getDayGroupNum() {
        return dayGroupNum;
    }

    public void setDayGroupNum(Integer dayGroupNum) {
        this.dayGroupNum = dayGroupNum;
    }
}