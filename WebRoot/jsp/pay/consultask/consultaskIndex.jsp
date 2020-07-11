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
            <%--<c:set var="dl" value="${account}"/>--%>
            <%--<input type="hidden" id="id" name="id" value="${dl.id}">--%>
            <div class = "condQueryCtrl">
                <div class = "condQueryLabelDiv">开始时间</div>
                <div class="formCtrlDiv">

                    <input type ="text" class ="inputCommonSty" id="startTime" name ="startTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
                </div>
                <div class = "condQueryLabelDiv">结束时间</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="endTime" name ="endTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
                </div>

                <div class = "condQueryLabelDiv">用户ID</div>
                <div class="formCtrlDiv" >
                    <input type ="text" class ="inputCommonSty" id="did" name ="did" >
                </div>
                <div class = "condQueryLabelDiv">标题</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="title" name ="title">
                </div>

                <div class = "condQueryLabelDiv">使用状态：</div>
                <div class="formCtrlDiv">
                    <select id="replyStatus" name="replyStatus" class='text-input medium-input'>
                        <option value="0">===请选择===</option>
                        <option value="1" selected>待处理</option>
                        <option value="2">回复完成</option>
                    </select>
                </div>

                <div class="searchdiv">
                    <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "搜索" />
                </div>


            </div>
        </form>
    </div>

    <table class="datatable tables"  style="width: 100%;overflow:scroll;"  >
        <thead>
        <tr>
            <th nowrap>归属用户ID</th>
            <th nowrap>标题</th>
            <th nowrap>咨询描述</th>
            <th nowrap>咨询图片地址</th>
            <th nowrap>回复状态</th>
            <th nowrap>创建时间</th>
            <th nowrap>更新时间</th>
            <th nowrap>操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

</div>

<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/consultask/consultask.js'></script>
</body>
</html>