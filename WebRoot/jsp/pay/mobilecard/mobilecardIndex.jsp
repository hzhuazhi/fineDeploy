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
                <div class = "condQueryLabelDiv">手机卡名称：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="cardName" name ="cardName">
                </div>
                <div class = "condQueryLabelDiv">姓名：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="useName" name ="useName">
                </div>
                <div class = "condQueryLabelDiv">手机号：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="phoneNum" name ="phoneNum">
                </div>

                <div class = "condQueryLabelDiv">手机编号：</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="bindingMobile" name ="bindingMobile">
                </div>

                <div class = "condQueryLabelDiv">使用状态：</div>
                <div class="formCtrlDiv" id = "moduleTypeDiv">
                    <select id="useStatus" name="useStatus" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">启用</option>
                        <option value="2">禁用</option>
                    </select>
                </div>


                <br>     <br>
                <div class="searchdiv">
                    <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "搜索" />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "butReset" class = "buttonClass imginput" value = "重置" />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "butAdd" class = "buttonClass imginput addbtn" value = "新增手机卡" />
                </div>
            </div>
        </form>
    </div>

    <table class="datatable tables">
        <thead>
        <tr>
            <th nowrap>手机卡名称</th>
            <th nowrap>姓名</th>
            <th nowrap>身份证</th>
            <th nowrap>手机号</th>
            <th nowrap>手机编号</th>
            <th nowrap>每月话费</th>
            <th nowrap>使用状态</th>
            <th nowrap>创建时间</th>
            <th nowrap>操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/mobilecard/mobilecardIndex.js'></script>
</body>
</html>
