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
                <div class = "condQueryLabelDiv">归属手机卡信息：</div>
                <div class="formCtrlDiv" id="mobileCardIdDiv">
                 <!-- <input type ="text" class ="inputCommonSty" id="mobileCardId" name ="mobileCardId" -->
                </div>
                <div class = "condQueryLabelDiv">银行名称</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="bankName" name ="bankName">
                </div>
                <div class = "condQueryLabelDiv">银行卡号</div>
                <div class="formCtrlDiv">
                    <input type ="text" class ="inputCommonSty" id="bankCard" name ="bankCard">
                </div>
                <div class = "condQueryLabelDiv">放量类型：</div>
                <div class="formCtrlDiv">
                    <select id="sel_openType" name="sel_openType" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">白天</option>
                        <option value="2">晚上</option>
                        <option value="3">全天</option>
                    </select>
                </div>
                <br> <br>
                <div class = "condQueryLabelDiv">优先级：</div>
                <div class="formCtrlDiv">
                    <select id="sel_specialType" name="sel_specialType" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">满 额</option>
                        <option value="2">随 机</option>
                    </select>
                </div>

                <div class = "condQueryLabelDiv">日开关状态：</div>
                <div class="formCtrlDiv">
                    <select id="sel_daySwitch" name="sel_daySwitch" class='text-input medium-input'>
                        <option value="0" selected>===请选择===</option>
                        <option value="1">启用</option>
                        <option value="2">禁用</option>
                    </select>
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

    <%--<div style="width: 100%;overflow:scroll;">--%>
        <table class="datatable tables"  style="width: 100%;overflow:scroll;"  >
            <thead>
            <tr>
                <th nowrap>归属手机信息</th>
                <th nowrap>银行名称</th>
                <th nowrap>银行卡类型</th>
                <th nowrap>银行卡账号</th>
                <th nowrap>开户名</th>
                <th nowrap>日收款金额</th>
                <th nowrap>日转账金额</th>
                <th nowrap>月收款金额</th>
                <th nowrap>月转账金额</th>
                <th nowrap>总收款金额</th>
                <th nowrap>总转账金额</th>
                <th nowrap>凭证短信号</th>
                <th nowrap>凭证银行卡尾号</th>
                <th nowrap>照凭证内容</th>
                <th nowrap>截取开始字段</th>
                <th nowrap>截取结束字段</th>
                <th nowrap>优先级</th>
                <th nowrap>放量类型</th>
                <th nowrap>日开关状态</th>
                <th nowrap>使用状态</th>
                <th nowrap>创建时间</th>
                <th nowrap>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    <%--</div>--%>

</div>

<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/bankcard/bankcard.js'></script>
</body>
</html>