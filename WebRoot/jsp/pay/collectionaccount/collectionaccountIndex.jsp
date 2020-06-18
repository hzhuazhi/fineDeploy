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
                <div class = "condQueryLabelDiv">用户id：</div>
                <div class="formCtrlDiv" id="mobileCardIdDiv">
                  <input type ="text" class ="inputCommonSty" id="did" name ="did" >
                </div>
                <div class = "condQueryLabelDiv">可爱猫绑定微信</div>
                <div class="formCtrlDiv" id="divWxid">
                    <select id="wxId" name="wxId" class='text-input medium-input'>
                        <option value="" disabled>===请选择===</option>
                    </select>
                </div>

                <div class = "condQueryLabelDiv">审核状态：</div>
                <div class="formCtrlDiv">
                    <select id="checkStatus" name="checkStatus" class='text-input medium-input'>
                        <option value="" selected>===请选择===</option>
                        <option value="1">待审核</option>
                        <option value="2">审核失败</option>
                        <option value="3">审核成功</option>
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
            <th nowrap>用户id</th>
            <th nowrap>可爱猫微信</th>
            <th nowrap>收款账户名称</th>
            <th nowrap>收款账户类型</th>
            <%--<th nowrap>收款的具体账号</th>--%>
            <%--<th nowrap>收款账号/地址</th>--%>
            <th nowrap>转换后字符串</th>
            <th nowrap>收款人（昵称）</th>
            <th nowrap>经营范围类型</th>
            <th nowrap>小微商户二维码图片地址</th>
            <th nowrap>状态审核</th>
            <th nowrap>审核状态备注</th>
            <th nowrap>服务器提示备注</th>
            <th nowrap>创建时间</th>
            <th nowrap>操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>

<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/collectionaccount/collectionaccount.js'></script>
</body>
</html>