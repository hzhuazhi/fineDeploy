<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>通道列表</title>
    <%@ include file="/jsp/manager/common/head-meta.jsp"%>
    <%@ include file="/jsp/manager/common/js-meta.jsp"%>
</head>
<body>
<div class="col_main">
    <div class = "condQueryDiv">
        <form id = "condForm">
            <div class = "condQueryCtrl">
                <div class = "condQueryLabelDiv">账号：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="acNum" name ="acNum">
                </div>
                <div class = "condQueryLabelDiv">微信昵称：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="payee" name ="payee">
                </div>
                <div class = "condQueryLabelDiv">是否绑定微信：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="isHave" name="isHave" class='text-input medium-input'>
                        <option value="0" selected="selected">===请选择===</option>
                        <option value="1">未绑定</option>
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
            <th width="150">账号昵称</th>
            <th width="200">注册账号</th>
            <th width="200">总金额（累计充值）</th>
            <th width="150">余额</th>
            <th width="150">微信昵称</th>
            <th width="180">是否绑定微信</th>
            <th width="150">审核状态</th>
            <th width="200">失败原因</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/teamdata/teamdata.js'></script>
</body>
</html>
