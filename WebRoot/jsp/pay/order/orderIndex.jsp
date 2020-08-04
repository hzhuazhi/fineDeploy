<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>订单列表</title>
    <%@ include file="/jsp/manager/common/head-meta.jsp"%>
    <%@ include file="/jsp/manager/common/js-meta.jsp"%>
</head>
<body>
<div class="col_main">
    <div class = "condQueryDiv">
        <form id = "condForm">
            <div class = "condQueryCtrl">
                <%--<div class = "condQueryLabelDiv">平台订单：</div>--%>
                <%--<div class="formCtrlDiv">--%>
                <%--<input type ="text" class ="inputCommonSty" id="myTradeNo" name ="myTradeNo">--%>
                <%--</div>--%>
                <div class = "condQueryLabelDiv">订单号：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="orderNo" name ="orderNo">
                </div>

                <div class = "condQueryLabelDiv">用户昵称：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="nickname" name ="nickname">
                </div>

                <div class = "condQueryLabelDiv">微信群：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="wxNickname" name ="wxNickname">
                </div>

                <div class = "condQueryLabelDiv">订单状态：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="orderStatus" name="orderStatus" class='text-input medium-input'>
                        <option value="0" selected="selected">=请选择=</option>
                        <option value="1">初始化</option>
                        <option value="2">超时/失败</option>
                        <option value="3">质疑</option>
                        <option value="4">成功</option>
                    </select>
                </div>

                <div class = "condQueryLabelDiv">是否发了红包：</div>
                <div class="formCtrlDiv" id = "runStatusDiv">
                    <select id="isRedPack" name="isRedPack" class='text-input medium-input'>
                        <option value="0" selected="selected">=请选择=</option>
                        <option value="1">未发红包</option>
                        <option value="2">已发红包</option>
                    </select>
                </div>

                <div class = "condQueryLabelDiv">是否回复：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="isReply" name="isReply" class='text-input medium-input'>
                        <option value="0" selected="selected">=请选择=</option>
                        <option value="1">初始化/未回复</option>
                        <option value="2">系统回复</option>
                        <option value="3">回复失败</option>
                        <option value="4">回复成功</option>
                    </select>
                </div>

                <div class = "condQueryLabelDiv">金额是否一致：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="moneyFitType" name="moneyFitType" class='text-input medium-input'>
                        <option value="0" selected="selected">=请选择=</option>
                        <option value="1">初始化</option>
                        <option value="2">少了</option>
                        <option value="3">多了</option>
                        <option value="4">一致</option>
                    </select>
                </div>

                <div class = "condQueryLabelDiv">是否补单：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="replenishType" name="replenishType" class='text-input medium-input'>
                        <option value="0" selected="selected">=请选择=</option>
                        <option value="1">不是补单</option>
                        <option value="2">是补单</option>
                    </select>
                </div>

                    <div class = "condQueryLabelDiv">开始日期：</div>
                <div class="formCtrlDiv">
                    <input type="text" class ="inputCommonSty" name="curdayStart" id="curdayStart" size="10" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyyMMdd'})" value="${model.curdayStart}"/>
                </div>
                <div class = "condQueryLabelDiv">截止日期：</div>
                <div class="formCtrlDiv">
                    <input type="text" class ="inputCommonSty" name="curdayEnd" id="curdayEnd" size="10" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyyMMdd'})" value="${model.curdayEnd}" />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "搜索"  />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "butReset" class = "buttonClass imginput" value = "重置" />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "butExcelExport" class = "buttonClass imginput" value = "Excel导出" />
                </div>
            </div>
        </form>
    </div>

    <table class="datatable tables">

        <thead>
        <div class="formCtrlDiv" id = "totalDiv">

        </div>
        <%--<c:set var="total" value="${total}"/>--%>
        <%--汇总：${total.totalMoney}---${total.totalServiceCharge}---${total.totalActualMoney}--%>
        <tr>
            <th width="150">订单号</th>
            <th width="100">订单金额</th>
            <th width="100">用户昵称</th>
            <th width="100">支付类型</th>
            <th width="100">微信群</th>
            <th width="100">订单状态</th>
            <th width="150">超时时间</th>
            <th width="50">收益</th>
            <th width="150">是否发红包</th>
            <th width="150">发红包时间</th>
            <th width="100">是否回复</th>
            <th width="100">回复类容</th>
            <th width="150">回复时间</th>
            <th width="100">实际金额</th>
            <th width="150">金额是否一致</th>
            <th width="100">是否补单</th>
            <th width="150">创建时间</th>

        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/order/order.js'></script>
</body>
</html>
