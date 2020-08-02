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
                <div class = "condQueryLabelDiv">手机编号：</div>
                <div class="formCtrlDiv" id="mobileCardIdDiv">
                  <input type ="text" class ="inputCommonSty" id="bindingMobile" name ="bindingMobile" >
                </div>
                <div class = "condQueryLabelDiv">微信账号</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="acName" name ="acName">
                </div>
                <div class = "condQueryLabelDiv">微信昵称</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="wxName" name ="wxName">
                </div>
                <div class = "condQueryLabelDiv">可爱猫id</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="toWxid" name ="toWxid">
                </div>

                <div class = "condQueryLabelDiv">使用状态：</div>
                <div class="formCtrlDiv">
                    <select id="useStatus" name="useStatus" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">启用</option>
                        <option value="2">禁用</option>
                    </select>
                </div>

                <div class="searchdiv">
                    <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "搜索" />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "butReset" class = "buttonClass imginput" value = "重置" />
                </div>
                <div class="searchdiv">
                    <input type = "button" id = "addbtn" class = "buttonClass imginput addbtn" value = "新增" />
                </div>
            </div>
        </form>
    </div>

    <table class="datatable tables">
        <thead>
        <tr>
            <th nowrap>手机编号</th>
            <th nowrap>微信账号</th>
            <th nowrap>微信登录密码</th>
            <th nowrap>微信昵称</th>
            <th nowrap>可爱猫id</th>
            <th nowrap>加用户总上限</th>
            <th nowrap>加用户日上限</th>
            <th nowrap>微信名片二维码地址</th>
            <th nowrap>绑定店员数</th>
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
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/smallbusinesses/smallbusinesses.js'></script>
</body>
</html>