package com.xn.pay.model;

import com.xn.common.page.BasePage;

/**
 * @Description 团队长账号的实体属性Bean
 * @Author yoko
 * @Date 2020/6/14 11:22
 * @Version 1.0
 */
public class AccountTeamModel extends BasePage {
    /**
     * 自增主键ID
     */
    private long id;

    /**
     * 账号
     */
    private String accountNum;

    /**
     * 密码
     */
    private String passWd;

    private long roleId; //所属角色ID

    /**
     * 团队长名称
     */
    private String teamName;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系人电话
     */
    private String phoneNum;

    /**
     * 结算/支付方式：1对公，2对私
     */
    private int payType;

    /**
     * 总账
     */
    private String totalMoney;

    /**
     * 余额
     */
    private String balance;

    /**
     * 对应美好的用户主键ID
     */
    private long did;

    /**
     * 是否启用：0初始化属于暂停状态，1表示暂停使用，2正常状态
     */
    private int isEnable;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 是否有效：0有效，1无效/删除
     */
    private int yn;
    private String roleName; //所属的角色名称




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
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

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }
}
