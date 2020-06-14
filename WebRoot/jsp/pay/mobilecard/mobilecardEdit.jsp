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
            <h2>编辑银行</h2>
        </div>
        <div class="formContentDiv">
            <form id="addSupplierForm">
                <ul>
                    <c:set var="dl" value="${account}"/>
                    <input type="hidden" id="id" name="id" value="${dl.id}">
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>手机卡名称</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="cardName" name="cardName"	maxlength="240" value="${dl.cardName}" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>姓名</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="useName" name="useName"	maxlength="240" value="${dl.useName}"/>
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>身份证</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="idCard" name="idCard"	maxlength="240" value="${dl.idCard}" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>手机号</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="phoneNum" name="phoneNum"	maxlength="240"  value="${dl.phoneNum}"/>
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>手机编号</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="bindingMobile" name="bindingMobile"	maxlength="240" value="${dl.bindingMobile}" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">每月话费</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="cost" name="cost"	maxlength="240" value="${dl.cost}" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">使用状态</span>
                        </div>
                        <div class="formCtrlDiv">
                            <%--<select id="useStatus" name="useStatus" class='text-input medium-input' value="${dl.useStatus}">--%>
                                <%--<option value="0" selected>有效</option>--%>
                                <%--<option value="1">无效</option>--%>
                            <%--</select>--%>

                            <select id="useStatus" name="useStatus">
                                <c:if test="${dl.useStatus ==1}">
                                    <option value="1" selected>开启</option>
                                    <option value="2">禁用</option>
                                </c:if>
                                <c:if test="${dl.useStatus ==2}">
                                    <option value="1" >开启</option>
                                    <option value="2" selected>禁用</option>
                                </c:if>
                            </select>
                        </div>
                    </li>

                    <li>
                        <div class="" style="margin-bottom: 20px; margin-top: 20px;margin-left:200px;">
                            <input type="submit" class="formBtn" value="保 存" style="background-color: #54D8FE;"/> <span>
						</span>
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
            rules:{
                cardName:{
                    required:true,
                    maxlength:50
                },
                useName:{
                    required:true,
                    maxlength:50
                },
                idCard:{
                    required:true,
                    maxlength:50
                },
                phoneNum:{
                    required:true,
                    maxlength:50
                },
                bindingMobile:{
                    required:true,
                    maxlength:50
                }
            },
            messages: {
                cardName:{
                    required : "手机卡名称不能为空!",
                    maxlength : "手机卡名称长度最多是50个字符!"
                },
                useName:{
                    required:"姓名不能为空!",
                    number:"姓名长度最多是50个字符!"
                },
                idCard:{
                    required:"身份证不能为空!",
                    number:"身份证长度最多是50个字符!"
                },
                phoneNum:{
                    required:"手机号不能为空!",
                    number:"手机号长度最多是50个字符!"
                },
                bindingMobile:{
                    required:"手机编号不能为空!",
                    number:"手机编号长度最多是50个字符!"
                }
            },

            submitHandler : function() {
                var formData = $("#addSupplierForm").serialize();
                $.ajax({
                    url : ctx+ "/mobilecard/update.do",
                    type : 'post',
                    dataType : 'json',
                    data :formData,
                    success : function(data) {
                        if (data.success) {
                            alert("修改成功！");
                            window.location.href = ctx + "/mobilecard/list.do";
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