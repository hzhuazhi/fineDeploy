<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>后台管理系统</title>
    <%@ include file="/jsp/manager/common/head-meta.jsp"%>
    <%@ include file="/jsp/manager/common/js-meta.jsp"%>
    <script type='text/javascript' src='${ctxData}js/plugins/ajaxfileupload.js'></script>
    <link rel="stylesheet" type="text/css" href="${ctxData}css/role.css?v=${version}">
    <style type="text/css">
        .manage-wrap{background-color: #E2E0DB;display: inline-block;vertical-align: top; font-size: 12px;padding: 0;width: 140px;height: 30px;line-height: 30px;margin: 0 20px 10px 0;}
        .manage-wrap > input[type='checkbox']{margin: 0 10px;vertical-align: middle;-webkit-appearance: none;appearance: none;width: 13px;height: 13px;cursor: pointer;background: #fff;border: 1px solid B9BBBE;-webkit-border-radius: 1px;-moz-border-radius: 1px;border-radius: 1px;-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;position: relative;}
        .manage-wrap > input[type=checkbox]:active{border-color: #c6c6c6;background: #ebebeb;}
        .manage-wrap > input[type=checkbox]:checked::after {content: url(${ctxData}images/checkmark.png);display: block;position: absolute;top: -5px;right: 0px;left: -5px}
        .manage-wrap > input[type=checkbox]:focus {outline: none;border-color:#4d90fe;}
        .borderBottom{border-bottom: 1px dashed #e0e0e0;margin-bottom: 10px;padding-bottom: 10px;}
    </style>
</head>
<body>
<div class="col_main">
        <div class="formHeadDiv">
            <h2>编辑异常处理</h2>
        </div>
    <div class="formContentDiv">
        <form id="addSupplierForm">
            <ul>
                <c:set var="dl" value="${account}"/>
                <input type="hidden" id="id" name="id" value="${dl.id}">
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require" ><font color="red">*</font>可爱猫ID</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="analysisId" name="analysisId"	maxlength="240" value="${dl.analysisId}"/>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require" ><font color="red">*</font>用户ID</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="did" name="did" value="${dl.did}"	maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require" ><font color="red">*</font>小微管理</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="wxId" name="wxId" value="${dl.wxId}"	maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>收款账号ID</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="collectionAccountId" name="collectionAccountId" value="${dl.collectionAccountId}"	maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>微信群ID</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text"  class="formInput" id="groupWxid" name="groupWxid"  value="${dl.groupWxid}"	maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>微信群名称</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text"  class="formInput" id="groupName" name="groupName"	maxlength="240" value="${dl.groupName}"	/>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>微信原始账号ID	</span>
                    </div>
                    <div class="formCtrlDiv">

                        <input type="text" class ="inputCommonSty" name="userId" id="userId"    value="${dl.userId}"/>
                        <%--<input type="text" class="formInput" id="startTime" name="startTime"	value="${dl.startTime}"	 maxlength="240" />--%>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>订单号</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class ="inputCommonSty" name="orderNo" id="orderNo"   value="${dl.orderNo}"/>
                        <%--<input type="text" class="formInput" id="endTime" name="endTime" value="${dl.endTime}"		maxlength="240" />--%>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>订单金额</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="orderMoney" name="orderMoney" value="${dl.orderMoney}"		maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>订单状态</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="orderStatus" name="orderStatus" class='text-input medium-input'>
                            <c:if test="${dl.orderStatus == 1}">
                                <option value="1" selected>初始化</option>
                                <option value="2">超时/失败</option>
                                <option value="3">有质疑</option>
                                <option value="4">成功</option>
                            </c:if>
                            <c:if test="${dl.orderStatus == 2}">
                                <option value="1" >初始化</option>
                                <option value="2" selected>超时/失败</option>
                                <option value="3">有质疑</option>
                                <option value="4">成功</option>
                            </c:if>
                            <c:if test="${dl.orderStatus == 3}">
                                <option value="1" >初始化</option>
                                <option value="2">超时/失败</option>
                                <option value="3" selected> 有质疑</option>
                                <option value="4">成功</option>
                            </c:if>
                            <c:if test="${dl.orderStatus == 4}">
                                <option value="1" >初始化</option>
                                <option value="2">超时/失败</option>
                                <option value="3">有质疑</option>
                                <option value="4" selected>成功</option>
                            </c:if>
                        </select>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>处罚类型</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="punishType" name="punishType" class='text-input medium-input'>
                            <c:if test="${dl.punishType == 1}">
                                <option value="1" selected>不处罚</option>
                                <option value="2">处罚</option>
                            </c:if>
                            <c:if test="${dl.punishType == 2}">
                                <option value="1" >不处罚</option>
                                <option value="2" selected>处罚</option>
                            </c:if>
                        </select>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>处罚金额</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="punishMoney" name="punishMoney" value="${dl.punishMoney}"		maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>数据类型</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="dataType" name="dataType" class='text-input medium-input'>
                            <c:if test="${dl.dataType == 1}">
                                <option value="1" selected>初始化</option>
                                <option value="2">其它</option>
                                <option value="3">加群</option>
                                <option value="4">发红包</option>
                                <option value="5">删小微</option>
                            </c:if>
                            <c:if test="${dl.dataType == 2}">
                                <option value="1" >初始化</option>
                                <option value="2" selected>其它</option>
                                <option value="3">加群</option>
                                <option value="4">发红包</option>
                                <option value="5">删小微</option>
                            </c:if>
                            <c:if test="${dl.dataType == 3}">
                                <option value="1" >初始化</option>
                                <option value="2">其它</option>
                                <option value="3" selected>加群</option>
                                <option value="4">发红包</option>
                                <option value="5">删小微</option>
                            </c:if>
                            <c:if test="${dl.dataType == 4}">
                                <option value="1" >初始化</option>
                                <option value="2">其它</option>
                                <option value="3" >加群</option>
                                <option value="4" selected>发红包</option>
                                <option value="5">删小微</option>
                            </c:if>
                            <c:if test="${dl.dataType == 5}">
                                <option value="1" >初始化</option>
                                <option value="2">其它</option>
                                <option value="3" >加群</option>
                                <option value="4">发红包</option>
                                <option value="5" selected>删小微</option>
                            </c:if>

                        </select>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>数据说明</span>
                    </div>
                    <div class="formCtrlDiv">
                        <textarea  id="dataExplain" name="dataExplain" value="${dl.dataExplain}"  maxlength="240" style="width: 250px;height: 100px">${dl.dataExplain}</textarea>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>数据处理状态</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="isOk" name="isOk" class='text-input medium-input'>
                            <c:if test="${dl.isOk == 1}">
                                <option value="1" selected>初始化</option>
                                <option value="2">处理中</option>
                                <option value="3">处理失败</option>
                                <option value="4">处理成功</option>
                            </c:if>
                            <c:if test="${dl.isOk == 2}">
                                <option value="1">初始化</option>
                                <option value="2" selected>处理中</option>
                                <option value="3">处理失败</option>
                                <option value="4">处理成功</option>
                            </c:if>
                            <c:if test="${dl.isOk == 3}">
                                <option value="1">初始化</option>
                                <option value="2" >处理中</option>
                                <option value="3" selected>处理失败</option>
                                <option value="4">处理成功</option>
                            </c:if>
                            <c:if test="${dl.isOk == 4}">
                                <option value="1">初始化</option>
                                <option value="2" >处理中</option>
                                <option value="3">处理失败</option>
                                <option value="4" selected>处理成功</option>
                            </c:if>
                        </select>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>派单类型</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="endType" name="endType" class='text-input medium-input'>
                            <c:if test="${dl.endType == 1}">
                                <option value="1" selected>需要处理完毕</option>
                                <option value="2">不需要处理完毕</option>
                            </c:if>
                            <c:if test="${dl.endType == 2}">
                                <option value="1" >需要处理完毕</option>
                                <option value="2" selected>不需要处理完毕</option>
                            </c:if>
                        </select>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>备注</span>
                    </div>
                    <div class="formCtrlDiv">
                        <textarea  id="remark" name="remark"  maxlength="240" style="width: 250px;height: 100px">${dl.remark}</textarea>
                        <%--<input type="text" class="formInput" id="remark" name="remark" value="${dl.remark}"		maxlength="240" />--%>
                    </div>
                </li>

                <%--<li style="border-top: none;">--%>
                <%--<div class="formTextDiv">--%>
                <%--<span class="require">有效状态</span>--%>
                <%--</div>--%>
                <%--<div class="formCtrlDiv">--%>
                <%--<select id="yn" name="yn" class='text-input medium-input'>--%>
                <%--<option value="0" selected>开启</option>--%>
                <%--<option value="1">删除</option>--%>
                <%--</select>--%>
                <%--</div>--%>
                <%--</li>--%>
                <li>
                    <div class="" style="margin-bottom: 20px; margin-top: 20px;margin-left:200px;">
                        <input type="submit" class="formBtn" value="添  加" style="background-color: #54D8FE;"/> <span>
						</span> <input type="reset" class="formBtn" value="重  置" style="background-color: #54D8FE;" />
                        <input type="button" onClick="javascript :history.back(-1);" class="formBtn" value=" 返 回 " style="background-color: #54D8FE;"/>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</div>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type="text/javascript">
    $(function(){
        //密码输入验证
        $("#addSupplierForm").validate({
            // rules:{
            //     cardName:{
            //         required:true,
            //         maxlength:50
            //     },
            //     bankType:{
            //         required:true,
            //         maxlength:10
            //     },
            //     useName:{
            //         required:true,
            //         maxlength:50
            //     },
            //     idCard:{
            //         required:true,
            //         maxlength:50
            //     },
            //     phoneNum:{
            //         required:true,
            //         maxlength:50
            //     },
            //     bindingMobile:{
            //         required:true,
            //         maxlength:50
            //     }
            // },
            // messages: {
            //     cardName:{
            //         required : "手机卡名称不能为空!",
            //         maxlength : "手机卡名称长度最多是50个字符!"
            //     },
            //     bankType:{
            //         required : "手机卡类型不能为空!",
            //         maxlength : "手机卡类型不能为空!"
            //     },
            //     useName:{
            //         required:"姓名不能为空!",
            //         number:"姓名长度最多是50个字符!"
            //     },
            //     idCard:{
            //         required:"身份证不能为空!",
            //         number:"身份证长度最多是50个字符!"
            //     },
            //     phoneNum:{
            //         required:"手机号不能为空!",
            //         number:"手机号长度最多是50个字符!"
            //     },
            //     bindingMobile:{
            //         required:"手机编号不能为空!",
            //         number:"手机编号长度最多是50个字符!"
            //     }
            // },

            submitHandler : function() {
                var formData = $("#addSupplierForm").serialize();
                $.ajax({
                    url : ctx+ "/operate/update.do",
                    type : 'post',
                    dataType : 'json',
                    data :formData,
                    success : function(data) {
                        if (data.success) {
                            alert("修改成功！");
                            window.location.href = ctx + "/operate/list.do";
                        } else {
                            art.alert(data.msg);
                        }
                    },
                    error : function(data) {
                        art.alert(data.info);
                    }
                });
                return false;
                //阻止表单提交
            }
        });
    });
</script>
</body>
</html>