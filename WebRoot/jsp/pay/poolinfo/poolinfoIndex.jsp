<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>池子信息</title>
    <%@ include file="/jsp/manager/common/head-meta.jsp"%>
    <%@ include file="/jsp/manager/common/js-meta.jsp"%>
</head>
<%--<style>--%>
    <%--.divcss5 img{width:300px; height:400px}--%>
<%--</style>--%>
<body>
<div class="col_main">
    <div class = "condQueryDiv">
        <form id = "condForm">
            <div class = "condQueryCtrl" style="width: 100%;">
                <div class = "condQueryLabelDiv">池子类型：</div>
                <div class="formCtrlDiv">
                    <select id="dataType" name="dataType" class='text-input medium-input'>
                        <option value="0" selected="selected">=请选择=</option>
                        <option value="1">等待池</option>
                        <option value="2">抢单池</option>
                        <option value="3">汇总池</option>
                    </select>
                </div>
                <div class = "condQueryLabelDiv">用户昵称：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="nickname" name ="nickname">
                </div>
                <div class = "condQueryLabelDiv">用户手机：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="phoneNum" name ="phoneNum">
                </div>
                <div class = "condQueryLabelDiv">小微昵称：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="wxName" name ="wxName">
                </div>
                <div class = "condQueryLabelDiv">微信群：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="payee" name ="payee">
                </div>

                <%--</br>--%>
            </div>

            <div class = "condQueryCtrl" style="width: 100%;" align="right" >
                <div class="searchdiv">
                    <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "搜索"  />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "butReset" class = "buttonClass imginput" value = "重置" />
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
            <th width="150">池子类型</th>
            <th width="150">用户昵称</th>
            <th width="150">用户手机</th>
            <th width="100">余额</th>
            <th width="150">可用金额</th>
            <th width="100">小微昵称</th>
            <th width="150">微信昵称</th>
            <th width="100">微信群</th>
            <th width="100">红包个数</th>
            <th width="150">进池时间</th>
            <th width="200">操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/poolinfo/poolinfo.js'></script>
</body>
</html>
