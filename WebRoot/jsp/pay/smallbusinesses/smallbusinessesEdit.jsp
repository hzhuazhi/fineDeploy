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
                            <span class="require" ><font color="red">*</font>手机编号</span>
                        </div>

                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="bindingMobile" name="bindingMobile"	maxlength="240" value="${dl.bindingMobile}"/>
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>微信账号</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="acName" name="acName"	maxlength="240" value="${dl.acName}"/>
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">微信登录密码</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="wxPassWd" name="wxPassWd"	value="${dl.wxPassWd}" maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>微信昵称</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="wxName" name="wxName" value="${dl.wxName}"	maxlength="240" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>可爱猫id</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="toWxid" name="toWxid" value="${dl.toWxid}"	maxlength="240" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>旗下绑定多少个店员</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="totalLink" name="totalLink" value="${dl.totalLink}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">使用状态</span>
                        </div>
                        <div class="formCtrlDiv">
                            <select id="useStatus" name="useStatus" class='text-input medium-input'>
                                <c:if test="${dl.useStatus == 1}">
                                    <option value="1" selected>启用</option>
                                    <option value="2">禁用</option>
                                </c:if>
                                <c:if test="${dl.useStatus == 2}">
                                    <option value="1" >启用</option>
                                    <option value="2"selected>禁用</option>
                                </c:if>
                            </select>
                        </div>
                    </li>
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
            rules:{
                bindingMobile:{
                    required:true,
                    maxlength:20
                },
                acName:{
                    required:true,
                    maxlength:50
                },
                wxName:{
                    required:true,
                    maxlength:50
                },
                toWxid:{
                    required:true,
                    maxlength:50
                },
                totalLink:{
                    required:true,
                    maxlength:4
                }
            },
            messages: {
                bindingMobile:{
                    required : "手机编号不能为空!",
                    maxlength : "手机编号长度最多是50个字符!"
                },
                acName:{
                    required:"微信账号不能为空!",
                    number:"微信账号最多是50个字符!"
                },
                wxName:{
                    required:"微信昵称不能为空!",
                    number:"微信昵称最多是50个字符!"
                },
                toWxid:{
                    required:"可爱猫id不能为空!",
                    number:"可爱猫id长度最多是50个字符!"
                },
                totalLink:{
                    required:"绑定店员数不能为空!",
                    number:"绑定店员数长度最多是4个字符!"
                }
            },

            submitHandler : function() {
                var formData = $("#addSupplierForm").serialize();
                $.ajax({
                    url : ctx+ "/smallbusinesses/update.do",
                    type : 'post',
                    dataType : 'json',
                    data :formData,
                    success : function(data) {
                        if (data.success) {
                            alert("修改成功！");
                            window.location.href = ctx + "/smallbusinesses/list.do";
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