<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>短信列表</title>
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
                <div class = "condQueryLabelDiv">手机号：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="phoneNum" name ="phoneNum">
                </div>
                <div class = "condQueryLabelDiv">短信号段：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="smsNum" name ="smsNum">
                </div>
                <div class = "condQueryLabelDiv">短信类型：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="dataType" name="dataType" class='text-input medium-input'>
                        <option value="0" selected="selected">===请选择===</option>
                        <option value="1">广告短信</option>
                        <option value="2">挂失短信</option>
                        <option value="3">欠费短信</option>
                        <option value="4">普通短信</option>
                        <option value="5">手机卡变更</option>
                        <option value="6">其它短信</option>
                    </select>
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "搜索" />
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
        <tr>
            <th width="150">手机号</th>
            <th width="150">短信号段</th>
            <th width="500">短信内容</th>
            <th width="150">短信类型</th>
            <th width="200">创建时间</th>
            <th width="200">手机卡名称</th>
            <th width="150">手机卡归属人</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/mobilecarddata/mobilecarddata.js'></script>
</body>
</html>
