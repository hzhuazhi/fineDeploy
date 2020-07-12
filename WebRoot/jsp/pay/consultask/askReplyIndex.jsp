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
            <c:set var="dl" value="${ask}"/>
            <input type="hidden" id="id" name="id" value="${dl.id}">
            <div class="searchdiv">

                <input type = "button" id = "btnQuery" class = "buttonClass imginput" value = "回复" onclick="showDialog('show','添加回复信息',null)"/>
                <input type="button" onClick="javascript :history.back(-1);" class="buttonClass imginput" value=" 返 回 " />
            </div>
        </form>
    </div>

    <table class="datatable tables"  style="width: 100%;overflow:scroll;"  >
        <thead>
            <tr>
                <th nowrap>问题类型</th>
                <th nowrap>问题描述</th>
                <th nowrap>问题图片</th>
                <th nowrap>回复内容</th>
                <th nowrap>回复图片</th>
                <th nowrap>回复时间</th>
                <th nowrap>状态</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

</div>

<div id="show" style="display:none;width:400px;">
    <div class="formHeadDiv">
        <h2>
            添加模块
        </h2>
    </div>
    <div class="formContentDiv" style="padding-right:0px">
        <form id="newFirstStoreForm">
            <c:set var="dl" value="${ask}"/>
            <input type="hidden" id="consultAskId" name="consultAskId" value="${dl.id}" />
            <dl>
                <dd style="border-top: none;">
                    <div class="formTextDiv" style="width: 100px;">
                        <span class="require">*</span>回复内容
                    </div>

                </dd>
                <div align="center" style="width: 100%;margin-left: 10px;" >
                    <div class="formCtrlDiv" style="width: 80%;margin-left: 10px;" align="center">
                        <textarea id="askReply" name="askReply" rows="20" cols="40"></textarea>
                        <%--<input type="textarea" id="" style="width: 200px;box-sizing: border-box" class="formInput"--%>
                        <%--id="moduleName" name="moduleName" />--%>
                    </div>
                </div >

                <dd style="border-top: none;">
                    <div class="formTextDiv"></div>
                    <%--<div class="formCtrlDiv">
                        -------------------------------------------------------------------------------
                    </div>--%>
                </dd>
                <dd style=" height: 60px; line-height: 58px;">
                    <div class="formCtrlDiv">
							<span style="margin-left: 100px;">
								<input type="button" style="background-color: #767DC3" class="formBtn" value="保　存"  onclick="sava()" />
								<input type="reset"  style="background-color: #42425E" class="formBtn" value="重　置" />
								<%--<input type="reset" onClick="javascript :closeDialog('show')" class="formBtn" value=" 返 回 " /> --%>
							</span>
                    </div>
                </dd>
            </dl>
        </form>
    </div>
</div>

<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/pay/consultask/askreply.js'></script>
</body>
</html>