package com.xn.pay.model;

import com.xn.common.page.BasePage;

/**
 * @Description 订单的实体属性Bean
 * @Author yoko
 * @Date 2020/8/4 14:01
 * @Version 1.0
 */
public class OrderModel extends BasePage {

    /**
     * 主键ID
     */
    private long id;

    /**
     * 奖励归属用户ID：对应表tb_fn_did的主键ID；奖励给哪个用户
     */
    private long did;

    /**
     * 用户账户昵称
     */
    private String nickname;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单金额
     */
    private String orderMoney;

    /**
     * 用户收款账号ID：对应表tb_fn_did_collection_account的主键ID
     */
    private long collectionAccountId;

    /**
     * 收款账号类型：1微信，2支付宝，3银行卡
     */
    private int collectionType;

    /**
     * 收款二维码的主键ID：对应表tb_fn_did_collection_account_qr_code的主键ID
     */
    private long qrCodeId;

    /**
     * 收款的二维码地址：转码之后的二维码
     */
    private String qrCode;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     *小微管理员主键ID
     */
    private long wxId;

    /**
     * 商家订单号
     */
    private String outTradeNo;

    /**
     * 同步的接口地址:我方的同步地址
     */
    private String notifyUrl;

    /**
     * 订单状态：1初始化，2超时/失败，3有质疑，4成功
     */
    private int orderStatus;

    /**
     * 失效时间
     */
    private String invalidTime;

    /**
     * 支付宝的用户ID
     */
    private String userId;

    /**
     * 支付宝的账号
     */
    private String zfbAcNum;

    /**
     * 订单成功程序上报时间
     */
    private String programTime;

    /**
     * 订单状态_用户操作的状态：1初始化，2失败，3超时后默认成功，4用户点击成功
     */
    private int didStatus;

    /**
     * 订单成功用户上报时间
     */
    private String didTime;

    /**
     * 收款账户名称：用户备注使用
     */
    private String acName;

    /**
     * 收款的具体账号：类型为微信则微信账号，支付宝为支付宝账号；怕后期有其它冲突
     */
    private String acNum;

    /**
     * 收益
     */
    private String profit;

    /**
     * 是否发了红包：1初始化未发红包，2发了红包
     */
    private int isRedPack;

    /**
     * 发红包的时间
     */
    private String redPackTime;

    /**
     * 是否回复：1初始化未回复，2系统默认回复，3已回复失败，4已回复成功
     */
    private int isReply;

    /**
     * 回复类容
     */
    private String replyData;

    /**
     * 回复时间
     */
    private String replyTime;

    /**
     * 回复的实际金额
     */
    private String actualMoney;

    /**
     * 金额是否与上报金额一致：1初始化，2少了，3多了，4一致
     */
    private int moneyFitType;

    /**
     * 是否是补单：1初始化不是补单，2是补单
     */
    private int replenishType;

    /**
     * 备注
     */
    private String remark;


    /**
     * 创建日期：存的日期格式20160530
     */
    private int curday;

    /**
     * 创建所属小时：24小时制
     */
    private int curhour;

    /**
     * 创建所属分钟：60分钟制
     */
    private int curminute;

    /**
     *运行计算次数
     */
    private int runNum;

    /**
     * 运行计算状态：：0初始化，1锁定，2计算失败，3计算成功
     */
    private int runStatus;

    /**
     * 创建时间
     */
    private String createTime;

    private String tsTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 是否有效：0有效，1无效/删除
     */
    private int yn;

    private int curdayStart;
    private int curdayEnd;


    /**
     * 收款类型-str
     */
    private String collectionTypeStr;

    /**
     * 订单状态-str
     */
    private String orderStatusStr;

    /**
     * 是否发了红包-str
     */
    private String isRedPackStr;

    /**
     * 是否回复-str
     */
    private String isReplyStr;

    /**
     * 金额是否与上报金额一致-str
     */
    private String moneyFitTypeStr;

    /**
     * 是否是补单-str
     */
    private String replenishTypeStr;

    private String totalOrderMoney;// 总订单金额
    private String totalProfit;// 总收益
    private String totalActualMoney;// 总实际金额

    private int totalOrderNum;// 总订单数
    private int totalSuccessOrderNum;// 总成功订单数
    private int totalQuestionOrderNum;// 总质疑订单数
    private String totalSuccessMoney;// 总成功金额
    private String totalQuestionMoney;// 总质疑金额
    private int totalComeInGroupNum;// 总进群次数


    private int dataType;

    /**
     * 小微昵称
     */
    private String wxName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public long getCollectionAccountId() {
        return collectionAccountId;
    }

    public void setCollectionAccountId(long collectionAccountId) {
        this.collectionAccountId = collectionAccountId;
    }

    public int getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(int collectionType) {
        this.collectionType = collectionType;
    }

    public long getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(long qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }

    public long getWxId() {
        return wxId;
    }

    public void setWxId(long wxId) {
        this.wxId = wxId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getZfbAcNum() {
        return zfbAcNum;
    }

    public void setZfbAcNum(String zfbAcNum) {
        this.zfbAcNum = zfbAcNum;
    }

    public String getProgramTime() {
        return programTime;
    }

    public void setProgramTime(String programTime) {
        this.programTime = programTime;
    }

    public int getDidStatus() {
        return didStatus;
    }

    public void setDidStatus(int didStatus) {
        this.didStatus = didStatus;
    }

    public String getDidTime() {
        return didTime;
    }

    public void setDidTime(String didTime) {
        this.didTime = didTime;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getAcNum() {
        return acNum;
    }

    public void setAcNum(String acNum) {
        this.acNum = acNum;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public int getIsRedPack() {
        return isRedPack;
    }

    public void setIsRedPack(int isRedPack) {
        this.isRedPack = isRedPack;
    }

    public String getRedPackTime() {
        return redPackTime;
    }

    public void setRedPackTime(String redPackTime) {
        this.redPackTime = redPackTime;
    }

    public int getIsReply() {
        return isReply;
    }

    public void setIsReply(int isReply) {
        this.isReply = isReply;
    }

    public String getReplyData() {
        return replyData;
    }

    public void setReplyData(String replyData) {
        this.replyData = replyData;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(String actualMoney) {
        this.actualMoney = actualMoney;
    }

    public int getMoneyFitType() {
        return moneyFitType;
    }

    public void setMoneyFitType(int moneyFitType) {
        this.moneyFitType = moneyFitType;
    }

    public int getReplenishType() {
        return replenishType;
    }

    public void setReplenishType(int replenishType) {
        this.replenishType = replenishType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCurday() {
        return curday;
    }

    public void setCurday(int curday) {
        this.curday = curday;
    }

    public int getCurhour() {
        return curhour;
    }

    public void setCurhour(int curhour) {
        this.curhour = curhour;
    }

    public int getCurminute() {
        return curminute;
    }

    public void setCurminute(int curminute) {
        this.curminute = curminute;
    }

    public int getRunNum() {
        return runNum;
    }

    public void setRunNum(int runNum) {
        this.runNum = runNum;
    }

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
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

    public String getCollectionTypeStr() {
        return collectionTypeStr;
    }

    public void setCollectionTypeStr(String collectionTypeStr) {
        this.collectionTypeStr = collectionTypeStr;
    }

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getIsRedPackStr() {
        return isRedPackStr;
    }

    public void setIsRedPackStr(String isRedPackStr) {
        this.isRedPackStr = isRedPackStr;
    }

    public String getIsReplyStr() {
        return isReplyStr;
    }

    public void setIsReplyStr(String isReplyStr) {
        this.isReplyStr = isReplyStr;
    }

    public String getMoneyFitTypeStr() {
        return moneyFitTypeStr;
    }

    public void setMoneyFitTypeStr(String moneyFitTypeStr) {
        this.moneyFitTypeStr = moneyFitTypeStr;
    }

    public String getReplenishTypeStr() {
        return replenishTypeStr;
    }

    public void setReplenishTypeStr(String replenishTypeStr) {
        this.replenishTypeStr = replenishTypeStr;
    }

    public String getTotalOrderMoney() {
        return totalOrderMoney;
    }

    public void setTotalOrderMoney(String totalOrderMoney) {
        this.totalOrderMoney = totalOrderMoney;
    }

    public String getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(String totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getTotalActualMoney() {
        return totalActualMoney;
    }

    public void setTotalActualMoney(String totalActualMoney) {
        this.totalActualMoney = totalActualMoney;
    }

    public String getTsTime() {
        return tsTime;
    }

    public void setTsTime(String tsTime) {
        this.tsTime = tsTime;
    }

    public int getTotalOrderNum() {
        return totalOrderNum;
    }

    public void setTotalOrderNum(int totalOrderNum) {
        this.totalOrderNum = totalOrderNum;
    }

    public int getTotalSuccessOrderNum() {
        return totalSuccessOrderNum;
    }

    public void setTotalSuccessOrderNum(int totalSuccessOrderNum) {
        this.totalSuccessOrderNum = totalSuccessOrderNum;
    }

    public int getTotalQuestionOrderNum() {
        return totalQuestionOrderNum;
    }

    public void setTotalQuestionOrderNum(int totalQuestionOrderNum) {
        this.totalQuestionOrderNum = totalQuestionOrderNum;
    }

    public String getTotalSuccessMoney() {
        return totalSuccessMoney;
    }

    public void setTotalSuccessMoney(String totalSuccessMoney) {
        this.totalSuccessMoney = totalSuccessMoney;
    }

    public String getTotalQuestionMoney() {
        return totalQuestionMoney;
    }

    public void setTotalQuestionMoney(String totalQuestionMoney) {
        this.totalQuestionMoney = totalQuestionMoney;
    }

    public int getTotalComeInGroupNum() {
        return totalComeInGroupNum;
    }

    public void setTotalComeInGroupNum(int totalComeInGroupNum) {
        this.totalComeInGroupNum = totalComeInGroupNum;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }
}
