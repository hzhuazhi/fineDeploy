package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.Date;

public class ConsultAskReply  extends BasePage {
    /**
     * 自增主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 在线客服、咨询的发问表的主键ID：对应表tb_fn_consult_ask的主键ID
     *
     * @mbggenerated
     */
    private Long consultAskId;

    /**
     * 问答_文字
     *
     * @mbggenerated
     */
    private String askReply;

    /**
     * 问答_图片地址
     *
     * @mbggenerated
     */
    private String askReplyAds;

    /**
     * 数据类型：1问，2回答
     *
     * @mbggenerated
     */
    private Boolean dataType;

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
    private Boolean yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConsultAskId() {
        return consultAskId;
    }

    public void setConsultAskId(Long consultAskId) {
        this.consultAskId = consultAskId;
    }

    public String getAskReply() {
        return askReply;
    }

    public void setAskReply(String askReply) {
        this.askReply = askReply;
    }

    public String getAskReplyAds() {
        return askReplyAds;
    }

    public void setAskReplyAds(String askReplyAds) {
        this.askReplyAds = askReplyAds;
    }

    public Boolean getDataType() {
        return dataType;
    }

    public void setDataType(Boolean dataType) {
        this.dataType = dataType;
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

    public Boolean getYn() {
        return yn;
    }

    public void setYn(Boolean yn) {
        this.yn = yn;
    }
}