<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>账号列表</title>
    <%@ include file="/jsp/manager/common/head-meta.jsp"%>
    <%@ include file="/jsp/manager/common/js-meta.jsp"%>
</head>
<body>
<div class="col_main">
    <div class = "condQueryDiv">
        <form id = "condForm">
            <div class = "condQueryCtrl">
                <div class = "condQueryLabelDiv">开始日期：</div>
                <div class="formCtrlDiv">
                    <input type="text" class ="inputCommonSty" name="curdayStart" id="curdayStart" size="10" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyyMMdd'})" value="${model.curdayStart}"/>
                </div>
                <div class = "condQueryLabelDiv">截止日期：</div>
                <div class="formCtrlDiv">
                    <input type="text" class ="inputCommonSty" name="curdayEnd" id="curdayEnd" size="10" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyyMMdd'})" value="${model.curdayEnd}" />
                </div>
                <div class = "condQueryLabelDiv">订单号：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="orderNo" name ="orderNo">
                </div>
                <div class = "condQueryLabelDiv">打款人名称：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="depositor" name ="depositor">
                </div>
                <div class = "condQueryLabelDiv">银行：</div>
                <div class="formCtrlDiv" id = "bankDiv">
                </div>
                <div class = "condQueryLabelDiv">银行名称：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="bankName" name ="bankName">
                </div>
                <div class = "condQueryLabelDiv">银行卡账号：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="bankCard" name ="bankCard">
                </div>
                <div class = "condQueryLabelDiv">开户名：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="accountName" name ="accountName">
                </div>
                <div class = "condQueryLabelDiv">订单状态：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="orderStatus" name="orderStatus" class='text-input medium-input'>
                        <option value="0" selected="selected">===请选择===</option>
                        <option value="-1">申诉</option>
                        <option value="1">初始化</option>
                        <option value="2">超时</option>
                        <option value="3">成功</option>
                    </select>
                </div>
                <div class = "condQueryLabelDiv">审核状态：</div>
                <div class="formCtrlDiv" id = "checkStatusId">
                    <select id="checkStatus" name="checkStatus" class='text-input medium-input'>
                        <option value="0" selected="selected">===请选择===</option>
                        <option value="1">初始化</option>
                        <option value="2">审核中</option>
                        <option value="3">审核失败</option>
                        <option value="4">审核成功</option>
                    </select>
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "搜索" />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "butReset" class = "buttonClass imginput" value = "重置" />
                </div>
            </div>
        </form>
    </div>

    <table class="datatable tables">
        <thead>
        <tr>
            <th width="150">订单号</th>
            <th width="150">银行名称</th>
            <th width="250">银行卡号</th>
            <th width="150">开户人</th>
            <th width="150">订单金额</th>
            <th width="150">超时时间</th>
            <th width="150">打款人名称</th>
            <th width="150">打款金额</th>
            <th width="150">打款尾号</th>
            <th width="200">图片</th>
            <th width="150">订单状态</th>
            <th width="150">审核状态</th>
            <th width="150">审核备注</th>
            <th width="150">操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/didrecharge/didrecharge.js'></script>
</body>
</html>
