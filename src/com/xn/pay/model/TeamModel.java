package com.xn.pay.model;

import com.xn.common.page.BasePage;

import java.math.BigDecimal;

/**
 * @Description 团队长旗下数据的实体属性Bean
 * @Author yoko
 * @Date 2020/6/14 12:48
 * @Version 1.0
 */
public class TeamModel extends BasePage {

    /**
     * 美好账户的主键ID
     */
    public long did;

    /**
     * 上级ID
     */
    private long ownId;

    /**
     * 直推人数
     */
    public int directNum;

    /**
     * 总累计充值金额
     */
    public String totalMoney;

    /**
     * 总余额
     */
    public String totalBalance;

    /**
     * 总订单成功金额
     */
    public String totalOrderMoney;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 金额 -  开始
     */
    private BigDecimal startMoney;

    /**
     * 金额 - 结束
     */
    private BigDecimal endMoney;

    /**
     * 金额 -  最小
     */
    private BigDecimal minMoney;

    /**
     * 金额档次人数
     */
    private int moneyNum;

    /**
     * 金额档次人数-一档次
     */
    private int oneMoneyNum;

    /**
     * 金额档次人数-二档次
     */
    private int twoMoneyNum;

    /**
     * 金额档次人数-三档次
     */
    private int threeMoneyNum;

    /**
     * 金额档次人数-四档次
     */
    private int fourMoneyNum;

    /**
     * 金额档次人数-五档次
     */
    private int fiveMoneyNum;


    private int curday;

    private int curdayStart;
    private int curdayEnd;




    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public int getDirectNum() {
        return directNum;
    }

    public void setDirectNum(int directNum) {
        this.directNum = directNum;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getTotalOrderMoney() {
        return totalOrderMoney;
    }

    public void setTotalOrderMoney(String totalOrderMoney) {
        this.totalOrderMoney = totalOrderMoney;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(BigDecimal startMoney) {
        this.startMoney = startMoney;
    }

    public BigDecimal getEndMoney() {
        return endMoney;
    }

    public void setEndMoney(BigDecimal endMoney) {
        this.endMoney = endMoney;
    }

    public int getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(int moneyNum) {
        this.moneyNum = moneyNum;
    }

    public int getCurday() {
        return curday;
    }

    public void setCurday(int curday) {
        this.curday = curday;
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

    public long getOwnId() {
        return ownId;
    }

    public void setOwnId(long ownId) {
        this.ownId = ownId;
    }

    public int getOneMoneyNum() {
        return oneMoneyNum;
    }

    public void setOneMoneyNum(int oneMoneyNum) {
        this.oneMoneyNum = oneMoneyNum;
    }

    public int getTwoMoneyNum() {
        return twoMoneyNum;
    }

    public void setTwoMoneyNum(int twoMoneyNum) {
        this.twoMoneyNum = twoMoneyNum;
    }

    public int getThreeMoneyNum() {
        return threeMoneyNum;
    }

    public void setThreeMoneyNum(int threeMoneyNum) {
        this.threeMoneyNum = threeMoneyNum;
    }

    public int getFourMoneyNum() {
        return fourMoneyNum;
    }

    public void setFourMoneyNum(int fourMoneyNum) {
        this.fourMoneyNum = fourMoneyNum;
    }

    public int getFiveMoneyNum() {
        return fiveMoneyNum;
    }

    public void setFiveMoneyNum(int fiveMoneyNum) {
        this.fiveMoneyNum = fiveMoneyNum;
    }

    public BigDecimal getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }
}
