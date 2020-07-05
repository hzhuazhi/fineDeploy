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
                            <span class="require" ><font color="red">*</font>归属手机信息</span>
                        </div>

                        <div class="formCtrlDiv">
                            <select id="mobileCardId" name="mobileCardId" >
                                <option value="">===请选择===</option>
                                <c:forEach items="${bank}" var="dataList">
                                    <c:choose>
                                        <c:when test="${dl.mobileCardId == dataList.id}">
                                            <option selected="selected" value="${dataList.id}">${dataList.cardName}</option>
                                        </c:when>
                                        <c:when test="${dl.mobileCardId != dataList.id}">
                                            <option value="${dataList.id}">${dataList.cardName}</option>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>银行名称</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="bankName" name="bankName"	maxlength="240" value="${dl.bankName}"/>
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>银行类型</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="bankType" name="bankType"	maxlength="240" value="${dl.bankType}"/>
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>银行卡账号</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="bankCard" name="bankCard"	value="${dl.bankCard}" maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>开户名</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="accountName" name="accountName" value="${dl.accountName}"	maxlength="240" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>凭证短信号</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="smsNum" name="smsNum" value="${dl.smsNum}"	maxlength="240" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>凭证银行卡尾号</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="lastNum" name="lastNum" value="${dl.lastNum}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>照凭证内容</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="smsContent" name="smsContent" value="${dl.smsContent}"	maxlength="240" />
                        </div>
                    </li>


                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>截取开始字段</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="startKey" name="startKey" value="${dl.startKey}"	maxlength="240" />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>截取结束字段</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="endKey" name="endKey" value="${dl.endKey}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>日收款金额</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="inDayMoney" name="inDayMoney" value="${dl.inDayMoney}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>日转账金额</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="outDayMoney" name="outDayMoney" value="${dl.outDayMoney}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>月收款金额</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="inMonthMoney" name="inMonthMoney" value="${dl.inMonthMoney}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>月转账金额</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="outMonthMoney" name="outMonthMoney" value="${dl.outMonthMoney}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>总收款金额</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="inTotalMoney" name="inTotalMoney" value="${dl.inTotalMoney}"	maxlength="240" />
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>总转账金额</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="outTotalMoney" name="outTotalMoney" value="${dl.outTotalMoney}"	maxlength="240" />
                        </div>
                    </li>



                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">优先级</span>
                        </div>
                        <div class="formCtrlDiv">
                            <select id="specialType" name="specialType" class='text-input medium-input'>
                                <c:if test="${dl.specialType == 1}">
                                    <option value="1" selected>满 额</option>
                                    <option value="2">随 机</option>
                                </c:if>
                                <c:if test="${dl.specialType == 2}">
                                    <option value="1" >满 额</option>
                                    <option value="2" selected>随 机</option>
                                </c:if>
                            </select>
                        </div>
                    </li>


                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">放量类型</span>
                        </div>
                        <div class="formCtrlDiv">
                            <select id="openType" name="openType" class='text-input medium-input'>
                                <c:if test="${dl.openType == 1}">
                                    <option value="1" selected>白天</option>
                                    <option value="2">晚上</option>
                                    <option value="3">全天</option>
                                </c:if>
                                <c:if test="${dl.openType == 2}">
                                    <option value="1" >白天</option>
                                    <option value="2"selected>晚上</option>
                                    <option value="3">全天</option>
                                 </c:if>
                                <c:if test="${dl.openType == 3}">
                                    <option value="1" >白天</option>
                                    <option value="2">晚上</option>
                                    <option value="3" selected>全天</option>
                                 </c:if>
                            </select>
                        </div>
                    </li>


                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">日开关状态</span>
                        </div>
                        <div class="formCtrlDiv">
                            <select id="daySwitch" name="daySwitch" class='text-input medium-input'>
                                <c:if test="${dl.daySwitch == 1}">
                                    <option value="1" selected>启用</option>
                                    <option value="2">禁用</option>
                                </c:if>
                                <c:if test="${dl.daySwitch == 2}">
                                    <option value="1" >启用</option>
                                    <option value="2"selected>禁用</option>
                                </c:if>
                            </select>
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
                cardName:{
                    required:true,
                    maxlength:50
                },
                bankType:{
                    required:true,
                    maxlength:10
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
                bankType:{
                    required : "手机卡类型不能为空!",
                    maxlength : "手机卡类型不能为空!"
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
                    url : ctx+ "/bankcard/update.do",
                    type : 'post',
                    dataType : 'json',
                    data :formData,
                    success : function(data) {
                        if (data.success) {
                            alert("修改成功！");
                            window.location.href = ctx + "/bankcard/list.do";
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