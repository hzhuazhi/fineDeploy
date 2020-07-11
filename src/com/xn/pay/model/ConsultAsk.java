package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.Date;

public class ConsultAsk extends BasePage {
    /**
     * 自增主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 咨询类别的主键ID：对应表tb_fn_consult的主键ID
     *
     * @mbggenerated
     */
    private Long consultId;

    /**
     * 归属用户ID：对应表tb_fn_did的主键ID
     *
     * @mbggenerated
     */
    private Long did;

    /**
     * 标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 咨询描述_问_文字
     *
     * @mbggenerated
     */
    private String ask;

    /**
     * 咨询描述_问_图片地址
     *
     * @mbggenerated
     */
    private String askAds;

    /**
     * 回复的状态：1初始化，2回答完毕
     *
     * @mbggenerated
     */
    private Integer replyStatus;

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

    private String  startTime;
    private String  endTime;
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

    public Long getConsultId() {
        return consultId;
    }

    public void setConsultId(Long consultId) {
        this.consultId = consultId;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getAskAds() {
        return askAds;
    }

    public void setAskAds(String askAds) {
        this.askAds = askAds;
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


    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}