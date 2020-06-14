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

    </div>

    <table class="datatable tables">
        <thead>
        <tr>
            <th width="150">直推总人数</th>
            <th width="150">总累计充值金额</th>
            <th width="150">总余额</th>
            <th width="150">今日总订单成功金额</th>
            <th width="150">余额5K以上的人数</th>
            <th width="150">余额1K-5K的人数</th>
            <th width="150">余额500-1K的人数</th>
            <th width="150">余额100-500的人数</th>
            <th width="150">余额100以下的人数</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/team/team.js'></script>
</body>
</html>
