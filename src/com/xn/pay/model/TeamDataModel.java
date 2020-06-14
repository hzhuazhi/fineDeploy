package com.xn.pay.model;

import com.xn.common.page.BasePage;

/**
 * @Description 团队长旗下数据详情的实体属性Bean
 * @Author yoko
 * @Date 2020/6/14 14:54
 * @Version 1.0
 */
public class TeamDataModel extends BasePage {


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
    private String acName;


    /**
     * 微信昵称
     */
    private String payee;

    /**
     * 收款账号审核：1初始化，2审核失败，3审核成功，4无
     */
    private int checkStatus;

    /**
     * 审核失败原因
     */
    private String checkInfo;

    /**
     * 是否上传收款账号
     */
    private int isHave;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
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

    public int getIsHave() {
        return isHave;
    }

    public void setIsHave(int isHave) {
        this.isHave = isHave;
    }



}
