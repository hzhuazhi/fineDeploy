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
                        <span class="require" ><font color="red">*</font>公告名称</span>
                    </div>

                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="noticeName" name="noticeName"	maxlength="240" value="${dl.noticeName}"/>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require" ><font color="red">*</font>公告标题</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="title" name="title" value="${dl.title}"	maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require" ><font color="red">*</font>简述</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="sketch" name="sketch" value="${dl.sketch}"	maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>公告内容</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="content" name="content" value="${dl.content}"	maxlength="240" />
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>公告的图标</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="file"  accept="image/*" class="formInput" id="iconAds1" name="iconAds1"	maxlength="240" onchange="excptions(1)"/>
                        <input type="text" hidden class="formInput" id="iconAds" name="iconAds"  value="${dl.iconAds}"	maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>内容图片</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" hidden class="formInput" id="pageAds" name="pageAds"	maxlength="240" />
                        <input type="file"  accept="image/*" class="formInput" id="pageAds1" name="pageAds1" value="${dl.pageAds1}"		maxlength="240" onchange="excptions(2)"/>
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>开始时间</span>
                    </div>
                    <div class="formCtrlDiv">

                        <input type="text" class ="inputCommonSty" name="startTime" id="startTime"  readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${dl.startTime}"/>
                        <%--<input type="text" class="formInput" id="startTime" name="startTime"	value="${dl.startTime}"	 maxlength="240" />--%>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>结束时间</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class ="inputCommonSty" name="endTime" id="endTime"  readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${dl.endTime}"/>
                        <%--<input type="text" class="formInput" id="endTime" name="endTime" value="${dl.endTime}"		maxlength="240" />--%>
                    </div>
                </li>

                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>位置</span>
                    </div>
                    <div class="formCtrlDiv">
                        <input type="text" class="formInput" id="seat" name="seat" value="${dl.seat}"		maxlength="240" />
                    </div>
                </li>
                <li style="border-top: none;">
                    <div class="formTextDiv">
                        <span class="require"><font color="red">*</font>公告类型</span>
                    </div>
                    <div class="formCtrlDiv">
                        <select id="noticeType" name="noticeType" class='text-input medium-input'>
                            <c:if test="${dl.noticeType == 1}">
                                <option value="1" selected>系统公告</option>
                                <option value="2">弹框公告</option>
                            </c:if>
                            <c:if test="${dl.noticeType == 2}">
                                <option value="1" >系统公告</option>
                                <option value="2" selected>弹框公告</option>
                            </c:if>
                        </select>



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
                    url : ctx+ "/notice/update.do",
                    type : 'post',
                    dataType : 'json',
                    data :formData,
                    success : function(data) {
                        if (data.success) {
                            alert("修改成功！");
                            window.location.href = ctx + "/notice/list.do";
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