package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.util.Date;

public class Notice extends BasePage {
    /**
     * 自增主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 公告名称
     *
     * @mbggenerated
     */
    private String noticeName;

    /**
     * 公告标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 简述：简单描述
     *
     * @mbggenerated
     */
    private String sketch;

    /**
     * 公告内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 公告的图标/图片
     *
     * @mbggenerated
     */
    private String iconAds;
    private String iconAds1;

    /**
     * 内容的页面地址
     *
     * @mbggenerated
     */
    private String pageAds;
    private String pageAds1;

    /**
     * 公告的开始有效时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 公告的结束有效时间
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 位置（顺序）
     *
     * @mbggenerated
     */
    private Integer seat;

    /**
     * 公告类型：1系统公告，2首页提醒公告
     *
     * @mbggenerated
     */
    private Integer noticeType;

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

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSketch() {
        return sketch;
    }

    public void setSketch(String sketch) {
        this.sketch = sketch;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIconAds() {
        return iconAds;
    }

    public void setIconAds(String iconAds) {
        this.iconAds = iconAds;
    }

    public String getPageAds() {
        return pageAds;
    }

    public void setPageAds(String pageAds) {
        this.pageAds = pageAds;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public String getIconAds1() {
        return iconAds1;
    }

    public void setIconAds1(String iconAds1) {
        this.iconAds1 = iconAds1;
    }

    public String getPageAds1() {
        return pageAds1;
    }

    public void setPageAds1(String pageAds1) {
        this.pageAds1 = pageAds1;
    }
}