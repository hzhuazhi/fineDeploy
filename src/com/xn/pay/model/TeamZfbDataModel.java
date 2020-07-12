package com.xn.pay.model;

import com.xn.common.page.BasePage;

/**
 * @Description 团队长旗下支付宝数据详情的实体属性Bean
 * @Author yoko
 * @Date 2020/7/11 16:31
 * @Version 1.0
 */
public class TeamZfbDataModel extends BasePage {


    /**
     * 账号昵称
     */
    private String nickname;

    /**
     * 账号
     */
    private String acNum;

    /**
     * 邀请码
     */
    private String icode;

    /**
     * 总金额（累计充值）
     */
    private String totalMoney;

    /**
     * 余额
     */
    private String balance;

    /**
     * 归属用户ID：上级的用户ID；对应本表的主键ID
     */
    private long ownId;

    /**
     * 收款账号备注
     */
    private String zfbAcNum;

    /**
     * 总消耗成功金额
     */
    private String totalSucMoney;

    /**
     * 今日消耗成功金额
     */
    private String todaySucMoney;

    /**
     * 是否上传收款账号
     */
    private int isHave;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 日期
     */
    private int curday;

    public String getAcNum() {
        return acNum;
    }

    public void setAcNum(String acNum) {
        this.acNum = acNum;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public long getOwnId() {
        return ownId;
    }

    public void setOwnId(long ownId) {
        this.ownId = ownId;
    }

    public String getZfbAcNum() {
        return zfbAcNum;
    }

    public void setZfbAcNum(String zfbAcNum) {
        this.zfbAcNum = zfbAcNum;
    }

    public String getTotalSucMoney() {
        return totalSucMoney;
    }

    public void setTotalSucMoney(String totalSucMoney) {
        this.totalSucMoney = totalSucMoney;
    }

    public String getTodaySucMoney() {
        return todaySucMoney;
    }

    public void setTodaySucMoney(String todaySucMoney) {
        this.todaySucMoney = todaySucMoney;
    }

    public int getIsHave() {
        return isHave;
    }

    public void setIsHave(int isHave) {
        this.isHave = isHave;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCurday() {
        return curday;
    }

    public void setCurday(int curday) {
        this.curday = curday;
    }
}
