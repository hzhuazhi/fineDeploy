<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>后台管理系统</title>
    <%@ include file="/jsp/manager/common/head-meta.jsp"%>
    <%@ include file="/jsp/manager/common/js-meta.jsp"%>
    <script type='text/javascript' src='${ctxData}js/plugins/ajaxfileupload.js'></script>
    <script type='text/javascript' src='${ctxData}js/common/qrcode.js'></script>
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
<form id="addSupplierForm">
<div class="col_main">
        <div class="formHeadDiv">
            <h2>编辑银行</h2>
        </div>
        <div >
                <ul>
                    <c:set var="dl" value="${account}"/>
                    <input type="hidden" id="id" name="id" value="${dl.id}">

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>收款账户名称</span>
                        </div>

                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="acName" name="acName"	maxlength="240" value="${dl.acName}"  disabled/>
                        </div>
                    </li>


                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>绑定小微号</span>
                        </div>

                        <div class="formCtrlDiv">
                            <select id="wxId" name="wxId" class='text-input medium-input' >
                                <option value="">===请选择===</option>
                                <c:forEach items="${small}" var="dataList">
                                    <c:choose>
                                        <%--<c:when test="${null ==dataList.id||'' == dataList.id}">--%>
                                            <%----%>
                                        <%--</c:when>--%>
                                        <c:when test="${dl.wxId == dataList.id}">
                                            <option selected="selected" value="${dataList.id}">${dataList.wxName}</option>
                                        </c:when>
                                        <c:when test="${dl.wxId != dataList.id}">
                                            <option value="${dataList.id}">${dataList.wxName}</option>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require" ><font color="red">*</font>收款账户类型</span>
                        </div>

                        <div class="formCtrlDiv">
                            <select id="acType" name="acType" class='text-input medium-input' disabled>
                                <c:if test="${dl.acType == 1}" >
                                    <option value="1" selected>微信</option>
                                    <option value="2">支付宝</option>
                                    <option value="3">银行卡</option>
                                </c:if>
                                <c:if test="${dl.acType == 2}">
                                    <option value="1" >微信</option>
                                    <option value="2"selected>支付宝</option>
                                    <option value="3">银行卡</option>
                                </c:if>
                                <c:if test="${dl.acType == 3}">
                                    <option value="1" >微信</option>
                                    <option value="2">支付宝</option>
                                    <option value="3" selected>银行卡</option>
                                </c:if>
                            </select>
                            <%--<input type="text" class="formInput" id="ac_type" name="ac_type"	maxlength="240" value="${dl.bindingMobile}"/>--%>
                        </div>
                    </li>
                    <%--<li style="border-top: none;">--%>
                        <%--<div class="formTextDiv">--%>
                            <%--<span class="require" ><font color="red">*</font>收款的具体账号</span>--%>
                        <%--</div>--%>
                        <%--<div class="formCtrlDiv">--%>


                            <%--<input type="text" class="formInput" id="acNum" name="acNum"	disabled maxlength="240" value="${dl.acNum}"/>--%>
                        <%--</div>--%>
                    <%--</li>--%>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">收款账号/地址</span>
                        </div>
                        <div class="formCtrlDiv" id="mmQrCode">

                            <%--<img  width="250px" height="250px" alt="mmQrCode" id="mmQrCode">--%>
                            <%--<input type="text" class="formInput" id="mmQrCode" name="mmQrCode"	value="${dl.mmQrCode}" maxlength="240"  />--%>
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">替换生成出码地址</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="ddQrCode" name="ddQrCode"	value="${dl.ddQrCode}" maxlength="240"   size="250"/>
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>收款人（昵称）</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input type="text" class="formInput" id="payee" name="payee" value="${dl.payee}"	maxlength="240"  />
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>经营范围类型</span>
                        </div>
                        <div class="formCtrlDiv">

                            <select id="businessType" name="businessType" class='text-input medium-input' disabled>
                                <c:if test="${dl.businessType == 1}">
                                    <option value="1" selected>个体</option>
                                    <option value="2">个体工商户</option>
                                    <option value="3">公司</option>
                                </c:if>
                                <c:if test="${dl.businessType == 2}">
                                    <option value="1" >个体</option>
                                    <option value="2"selected>个体工商户</option>
                                    <option value="3">公司</option>
                                </c:if>
                                <c:if test="${dl.businessType == 3}">
                                    <option value="1" >个体</option>
                                    <option value="2">个体工商户</option>
                                    <option value="3" selected>公司</option>
                                </c:if>
                            </select>
                        </div>
                    </li>
                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require"><font color="red">*</font>状态审核</span>
                        </div>
                        <div class="formCtrlDiv">
                            <select id="checkStatus" name="checkStatus" class='text-input medium-input'>
                                <c:if test="${dl.checkStatus == 1}">
                                    <option value="1" selected>初始化</option>
                                    <option value="2">审核失败</option>
                                    <option value="3">审核成功</option>
                                </c:if>
                                <c:if test="${dl.checkStatus == 2}">
                                    <option value="1" >初始化</option>
                                    <option value="2" selected>审核失败</option>
                                    <option value="3">审核成功</option>
                                </c:if>
                                <c:if test="${dl.checkStatus == 3}">
                                    <option value="1" >初始化</option>
                                    <option value="2">审核失败</option>
                                    <option value="3" selected>审核成功</option>
                                </c:if>
                            </select>
                        </div>
                    </li>

                    <li style="border-top: none;">
                        <div class="formTextDiv">
                            <span class="require">审核状态备注</span>
                        </div>
                        <div class="formCtrlDiv">
                            <input id="checkInfo" name="checkInfo" value="${dl.checkInfo}"  type="text" style="height: 50px">
                        </div>
                    </li>
                    <li>
                        <div class="" style="margin-bottom: 20px; margin-top: 20px;margin-left:200px;">
                            <input type="button" class="formBtn" value="检测小薇用户" id="add_xw" name="add_xw" style="background-color: #54D8FE;"/>
                            <input type="submit" class="formBtn" value="添  加" style="background-color: #54D8FE;"/>
                            <span>
						</span> <input type="reset" class="formBtn" value="重  置" style="background-color: #54D8FE;" />
                            <input type="button" onClick="javascript :history.back(-1);" class="formBtn" value=" 返 回 " style="background-color: #54D8FE;"/>
                        </div>
                    </li>
                </ul>

        </div>
</div>

<li style="border-top: none;">
        <div class="formTextDiv">
            <span class="require">小微地址</span>
        </div>
    </li>

    <div >
        <img src="${dl.wxQrCodeAds}"  alt="wxQrCodeAds" id="wxQrCodeAds">
        <%--<input type="text" class="formInput" id="wxQrCodeAds" name="wxQrCodeAds"	value="${dl.wxQrCodeAds}" maxlength="240"  />--%>
    </div>
</form>
<script type='text/javascript' charset="utf-8" src='${ctxData}js/common/common2.js'></script>
<script type="text/javascript">



    $(function(){
        var    qrcodeIntn =document.getElementById("mmQrCode");
        var qrcode = new QRCode(qrcodeIntn, {
            width : 200,//设置宽高
            height : 200
        });
        qrcode.makeCode($("#ddQrCode").val());

        //密码输入验证
        $("#addSupplierForm").validate({
            rules:{

                checkStatus:{
                    required:true,
                    maxlength:10
                },
                checkInfo:{
                    required:true,
                    maxlength:200
                }
            },
            messages: {

                checkStatus:{
                    required:"状态审核不能为空!",
                    number:"状态审核最多是2个字符!"
                },
                checkInfo:{
                    required:"审核状态备注不能为空!",
                    number:"审核状态备注最多是50个字符!"
                }
            },

            submitHandler : function() {
                var formData = $("#addSupplierForm").serialize();
                $.ajax({
                    url : ctx+ "/collectionaccount/update.do",
                    type : 'post',
                    dataType : 'json',
                    data :formData,
                    success : function(data) {
                        if (data.success) {
                            alert("修改成功！");
                            window.location.href = ctx + "/collectionaccount/list.do";
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

        $("#add_xw").click(function(){
            var url = ctx + "/collectionaccount/queryExamine.do";
            var data = {
            };
            common.ajax(url,data,function(data){
                var dataList=data.rows;
                if(dataList[0].rscode!=0){
                    if(dataList[0].wx_id==undefined||dataList[0].wx_id=="undefined"){
                        alert("当前没有可用的小薇可以用来认证，请等待2秒再试！");
                        return
                    }
                }else{
                    if(dataList[0].wx_id==undefined||dataList[0].wx_id=="undefined"){
                        alert("当前没有可用的小薇可以用来认证，请稍等！");
                        return
                    }
                    $("#wxId").val(dataList[0].wx_id);
                    $("#payee").val(dataList[0].wxname);

                }
            });
            common.showDatas(account.condJsonData,account.list);
        });


    });
</script>
</body>
</html>