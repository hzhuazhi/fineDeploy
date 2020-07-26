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
                <div class = "condQueryLabelDiv">订单号：</div>
                <div class="formCtrlDiv" >
                 <input type ="text" class ="inputCommonSty" id="orderNo" name ="orderNo" >
                </div>
                <div class = "condQueryLabelDiv">微信群ID：</div>
                <div class="formCtrlDiv" >
                    <input type ="text" class ="inputCommonSty" id="groupWxid" name ="groupWxid" >
                </div>
                <div class = "condQueryLabelDiv">微信群名称：</div>
                <div class="formCtrlDiv" >
                    <input type ="text" class ="inputCommonSty" id="groupName" name ="groupName" >
                </div>
                <div class = "condQueryLabelDiv">数据类型</div>
                <div class="formCtrlDiv">
                    <select id="dataType" name="dataType" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">初始化</option>
                        <option value="2">其它</option>
                        <option value="3">加群</option>
                        <option value="4">发红包</option>
                        <option value="5">删小微</option>
                    </select>
                </div>
                <div class = "condQueryLabelDiv">数据处理状态</div>
                <div class="formCtrlDiv">
                    <select id="isOk" name="isOk" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">初始化</option>
                        <option value="2">处理中</option>
                        <option value="3">处理失败</option>
                        <option value="4">处理成功</option>
                    </select>
                </div>
                <div class = "condQueryLabelDiv">派单类型</div>
                <div class="formCtrlDiv">
                    <select id="endType" name="endType" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">需要处理完毕</option>
                        <option value="2">不需要处理完毕</option>
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

    <table class="datatable tables"  style="width: 100%;overflow:scroll;"  >
        <thead>
            <tr>
                <th nowrap>可爱猫ID</th>
                <th nowrap>用户ID</th>
                <th nowrap>小微管理</th>
                <th nowrap>收款账号ID</th>
                <th nowrap>微信群ID</th>
                <th nowrap>微信群名称</th>
                <th nowrap>微信原始账号ID</th>
                <th nowrap>订单号</th>
                <th nowrap>订单金额</th>
                <th nowrap>订单状态</th>
                <th nowrap>处罚类型</th>
                <th nowrap>处罚金额</th>
                <th nowrap>数据类型</th>
                <th nowrap>数据说明</th>
                <th nowrap>数据处理状态</th>
                <th nowrap>派单类型</th>
                <th nowrap>备注</th>
                <th nowrap>操作</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

</div>

<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/operate/operate.js'></script>
</body>
</html>