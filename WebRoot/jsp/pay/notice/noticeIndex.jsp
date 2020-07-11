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
                <div class = "condQueryLabelDiv">公告名称：</div>
                <div class="formCtrlDiv" >
                 <input type ="text" class ="inputCommonSty" id="noticeName" name ="noticeName" >
                </div>
                <div class = "condQueryLabelDiv">公告标题</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="title" name ="title">
                </div>
                <div class = "condQueryLabelDiv">开始时间</div>
                <div class="formCtrlDiv">

                    <input type ="text" class ="inputCommonSty" id="startTime" name ="startTime">
                </div>
                <div class = "condQueryLabelDiv">结束时间</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="endTime" name ="endTime">
                </div>
                <div class = "condQueryLabelDiv">使用状态：</div>
                <div class="formCtrlDiv">
                    <select id="sel_useStatus" name="sel_useStatus" class='text-input medium-input'>
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

    <table class="datatable tables"  style="width: 100%;overflow:scroll;"  >
        <thead>
            <tr>
                <th nowrap>公告名称</th>
                <th nowrap>公告标题</th>
                <th nowrap>简述</th>
                <th nowrap>公告内容</th>
                <th nowrap>公告的图标</th>
                <th nowrap>内容</th>
                <th nowrap>开始有效时间</th>
                <th nowrap>结束有效时间</th>
                <th nowrap>位置</th>
                <th nowrap>公告类型</th>
                <th nowrap>创建时间</th>
                <th nowrap>状态</th>
                <th nowrap>操作</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

</div>

<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/notice/notice.js'></script>
</body>
</html>