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
                        <span class="require" ><font color="red">*</font>订单号</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="bankName" name="bankName" value="${dl.orderNo}" disabled	maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>银行名称</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="bankName" name="bankName" value="${dl.bankName}" disabled 	maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>银行卡号</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="bankCard" name="bankCard" value="${dl.bankCard}" disabled maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>开户人</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="accountName" name="accountName" value="${dl.accountName}" disabled maxlength="240" />
                    </div>
                </li>



                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">订单金额</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="orderMoney" name="orderMoney" value="${dl.orderMoney}"  disabled maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">超时时间</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="invalidTime" name="invalidTime" value="${dl.invalidTime}"  disabled maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">超时时间</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="invalidTime" name="invalidTime" value="${dl.invalidTime}"  disabled maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">超时时间</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="invalidTime" name="invalidTime" value="${dl.invalidTime}"  disabled maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">打款人名称</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="depositor" name="depositor" value="${dl.depositor}"  disabled maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">打款金额</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="depositMoney" name="depositMoney" value="${dl.depositMoney}"  disabled maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">打款尾号</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="lastNum" name="lastNum" value="${dl.lastNum}"  disabled maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">图片</span>
                    </div>
                    <div class="formCtrlDiv">
                        <img src="${dl.pictureAds}" alt="">
                        <input type="text" class="formInput" id="depositMoney" name="depositMoney" value="${dl.depositMoney}"  disabled maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">订单状态</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="orderStatus" name="orderStatus" disabled>
                            <option value="">===请选择===</option>
                            <c:if test="${dl.orderStatus == -1}">
                                <option value="-1" selected="selected">申诉</option>
                            </c:if>
                            <c:if test="${dl.orderStatus == 1}">
                                <option value="1" selected="selected">初始化</option>
                            </c:if>
                            <c:if test="${dl.orderStatus == 2}">
                                <option value="2" selected="selected">超时</option>
                            </c:if>
                            <c:if test="${dl.orderStatus == 3}">
                                <option value="3" selected="selected">成功</option>
                            </c:if>
                        </select>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require" ><font color="red">*</font>审核状态</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="checkStatus" name="checkStatus">
                            <option value="">===请选择===</option>
                            <c:if test="${dl.checkStatus == 1}">
                                <option value="1" selected="selected">初始化</option>
                                <option value="2">审核中</option>
                                <option value="3">审核失败</option>
                                <option value="4">审核成功</option>
                            </c:if>
                            <c:if test="${dl.checkStatus == 2}">
                                <option value="1">初始化</option>
                                <option value="2" selected="selected">审核中</option>
                                <option value="3">审核失败</option>
                                <option value="4">审核成功</option>
                            </c:if>
                            <c:if test="${dl.checkStatus == 3}">
                                <option value="1">初始化</option>
                                <option value="2">审核中</option>
                                <option value="3" selected="selected">审核失败</option>
                                <option value="4">审核成功</option>
                            </c:if>
                            <c:if test="${dl.checkStatus == 4}">
                                <option value="1">初始化</option>
                                <option value="2">审核中</option>
                                <option value="3">审核失败</option>
                                <option value="4" selected="selected">审核成功</option>
                            </c:if>
                        </select>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require">审核备注</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="checkInfo" name="checkInfo" value="${dl.checkInfo}" 	maxlength="240" />
                    </div>
                </li>
                <li>
                    <div class="" style="margin-bottom: 20px; margin-top: 20px;margin-left:200px;">
                        <input type="submit" class="dataTableBtn dataTableDeleteBtn" value="修 改" /> <span>
						</span> <input type="reset" class="dataTableBtn dataTableDeleteBtn" value="重  置" />
                        <input type="button" onClick="javascript :history.back(-1);" class="dataTableBtn dataTableDeleteBtn" value=" 返 回 " />
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
                checkStatus:{
                    required:true
                }

            },
            messages: {
                checkStatus:{
                    required : "请选择审核状态!"
                }
            },

            submitHandler : function() {
                var formData = $("#addSupplierForm").serialize();
                $.ajax({
                    url : ctx+ "/didrecharge/update.do",
                    type : 'post',
                    dataType : 'json',
                    data :formData,
                    success : function(data) {
                        if (data.success) {
                            alert("修改成功！");
                            window.location.href = ctx + "/didrecharge/list.do";
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