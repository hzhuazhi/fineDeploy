
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/askreply/list.do',
        dataList_url : ctx + "/askreply/dataList.do",
        add_url : ctx+ "/askreply/add.do",
        update_url : ctx+ "/askreply/update.do",
        queryId_url: ctx+ "/askreply/getId.do",
        delete_url: ctx+ "/askreply/delete.do",
        manyOperation_url: ctx+ "/askreply/manyOperation.do"
    },


    //添加修改验证参数
    validate:{
        rules:{
            ask:{
                required:true,
                maxlength:600
            },
        },
        messages: {
            ask:{
                required : "回复内容不能为空",
                maxlength : "回复内容长度最多是20个汉字或字母"
            },
        },
        submitHandler : function() {

            //阻止表单提交
        }
    },

    //列表显示参数
    list:[
        {"data":"askType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.askType==1){
                    html='<span >超时未放币</span>';
                }else if(oData.askType==2){
                    html='<span >超时未付款</span>';
                }else if(oData.askType==3){
                    html='<span >充提币问题</span>';
                }else if(oData.askType==4){
                    html='<span >修改支付宝问题</span>';
                }else if(oData.askType==5){
                    html='<span >其他问题</span>';
                }
                $(nTd).html(html);
            }
         },
        {"data":"askContent",},
        {"data":"askCountAds",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.askCountAds!=null&&oData.askCountAds!=""&&oData.askCountAds!=undefined&&oData.askCountAds!="undefined"){
                    html='<img src="'+oData.askCountAds+'" style="height: 200px;width: 200px">';
                }
                $(nTd).html(html);
            }
         },
        {"data":"askReply",},
        {"data":"askReplyAds",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.askReplyAds!=null&&oData.askReplyAds!=""&&oData.askReplyAds!=undefined&&oData.askReplyAds!="undefined"){
                    html='<img src="'+oData.askReplyAds+'" style="height: 200px;width: 200px">';
                }
                $(nTd).html(html);
            }
        },
        {"data":"createTime",},
        {"data":"dataType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.dataType==1){
                    html='<span style="color: #9D080D">问</span>';
                }else if(oData.dataType==2){
                    html='<span style="color: #4aff1a">回答</span>';
                }
                $(nTd).html(html);
            }
        },

    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        consultAskId:$("#id").val()
    },
    //页面加载
    indexInit : function (){
        //url同步
        common.updateUrl(this.url);

        // 查询条件 - 下拉框数据获取
        // this.queryGewayAll();


        //添加
        $(".addbtn").live("click",function(){
            // console.log("==========="+ctx + "/bankcard/jumpAdd.do");
            window.location.href = ctx + "/askreply/jumpAdd.do";
        });

        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['did'] = $("#did").val();
            account.condJsonData['title'] = $("#title").val();
            account.condJsonData['startTime'] = $("#startTime").val();
            account.condJsonData['endTime'] = $("#endTime").val();
            account.condJsonData['replyStatus'] = $("#replyStatus").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['noticeName'] = "";
            account.condJsonData['title'] = "";
            account.condJsonData['startTime'] = "0";
            account.condJsonData['endTime'] = "0";
            account.condJsonData['sel_useStatus'] = "0";
            $("#noticeName").val("");
            $("#title").val("");
            $("#startTime").val("0");
            $("#endTime").val("0");
            $("#sel_useStatus").val("0");
            // common.showDatas(account.condJsonData,account.list);
        });
        //删除
        $(".dataTableResetBtn").live("click",function(){
            var id = $(this).attr('directkey');
            var data = {
                id:id,
                yn:'1'
            }
            common.updateStatus(data);
        });




        //启用/禁用
        $(".dataTableEnableBtn").live("click",function(){
            var id = $(this).attr('directkey');
            var isEnable = $(this).attr('directValue');
            var data = {
                id:id,
                isEnable:isEnable
            }
            common.manyOperation(data);
        });
    },

    //查询所有银行卡-无分页-下拉框选项:
    // queryGewayAll:function(){
    //     var url = ctx + "/notice/dataAllList.do";
    //     console.log(url);
    //     var data = {
    //     };
    //     common.ajax(url,data,function(data){
    //         var dataList=data;
    //         var shtml="";
    //         shtml += "<select id='mobileCardId' name='mobileCardId'  class='text-input medium-input'>";
    //         shtml +="<option value=''>===请选择===</option>";
    //         for (var i=0;i<dataList.length>0;i++) {
    //             shtml +="<option value="+dataList[i].id+">"+dataList[i].cardName+"</option>";
    //         }
    //         shtml +="</select>";
    //         $("#mobileCardIdDiv").html(shtml);
    //     });
    // }



}

$(function(){
    account.indexInit();

    // 跳出dialog  elementId:div层的id名称  ；dialogTitle:弹出来的dialog名称（主题）
    function showDialog(elementId,dialogTitle,okFunction){
        dialog = art.dialog.get(elementId);
        if(!dialog){
            dialog = art.dialog.get(elementId);
            if(dialog)
                dialog.close();

            opt = {
                id : elementId,
                title : dialogTitle,
                content : document.getElementById(elementId),
                cancel : true,
                padding : 5,
                lock : true
            };

            newOpt = ($.isPlainObject(okFunction) || !okFunction) ? $.extend(true,{},opt,okFunction) : $.extend({},opt);
            art.dialog(newOpt);
        }
        $(".d-content").css("padding","4px 18px");
    }
// 关闭模式对话窗    elementId:div层的id名称
    function closeDialog(elementId){
        dialog = art.dialog.get(elementId);
        dialog.close();
    }

//跳出dialog  elementId:div层的id名称  ；dialogTitle:弹出来的dialog名称（主题）
    function commonShowDialog(elementId,dialogTitle,functionName){
        dialog = art.dialog.get(elementId);
        if(!dialog){
            dialog = art.dialog.get(elementId);
            if(dialog)
                dialog.close();
            art.dialog({
                id : elementId,
                title : dialogTitle,
                content : document.getElementById(elementId),
                lock: true,
                cancel:true,
                ok:function(){
                    functionName();
                    return false;
                }
            });
        }
    }
    function openDialog(elementId,dialogTitle){
        dialog = art.dialog.get(elementId);
        if(!dialog){
            dialog = art.dialog.get(elementId);
            if(dialog)
                dialog.close();

            opt = {
                id : elementId,
                title : dialogTitle,
                content : document.getElementById(elementId),
                padding : 5,
                lock : true
            };

            newOpt = $.extend({},opt);
            art.dialog(newOpt);
        }
        $(".d-content").css("padding","4px 18px");
    }



})

function sava() {
    var consultAskId = $("#consultAskId").val();
    var askReply = $("#askReply").val();


    var queryObj = {
        'askReply': askReply,
        'consultAskId': consultAskId
    };

    var url = account.url.add_url;
    // formData.add("consultAskId",id);

    $.ajax({
        url : url,
        type : 'post',
        dataType : 'json',
        data :queryObj,
        success : function(data) {
            if(data.success){

                parentId = 0;
                var datas = {
                    'consultAskId': consultAskId
                };
                var listInfo=[
                    {"data":"askType",
                        "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                            var html = '';
                            if(oData.askType==1){
                                html='<span >超时未放币</span>';
                            }else if(oData.askType==2){
                                html='<span >超时未付款</span>';
                            }else if(oData.askType==3){
                                html='<span >充提币问题</span>';
                            }else if(oData.askType==4){
                                html='<span >修改支付宝问题</span>';
                            }else if(oData.askType==5){
                                html='<span >其他问题</span>';
                            }
                            $(nTd).html(html);
                        }
                    },
                    {"data":"askContent",},
                    {"data":"askCountAds",
                        "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                            var html = '';
                            if(oData.askCountAds!=null&&oData.askCountAds!=""&&oData.askCountAds!=undefined&&oData.askCountAds!="undefined"){
                                html='<img src="'+oData.askCountAds+'" style="height: 200px;width: 200px">';
                            }
                            $(nTd).html(html);
                        }
                    },
                    {"data":"askReply",},
                    {"data":"askReplyAds",
                        "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                            var html = '';
                            if(oData.askReplyAds!=null&&oData.askReplyAds!=""&&oData.askReplyAds!=undefined&&oData.askReplyAds!="undefined"){
                                html='<img src="'+oData.askReplyAds+'" style="height: 200px;width: 200px">';
                            }
                            $(nTd).html(html);
                        }
                    },
                    {"data":"createTime",},
                    {"data":"dataType",
                        "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                            var html = '';
                            if(oData.dataType==1){
                                html='<span style="color: #9D080D">问</span>';
                            }else if(oData.dataType==2){
                                html='<span style="color: #4aff1a">回答</span>';
                            }
                            $(nTd).html(html);
                        }
                    },

                ];
                common.showDatas(datas,listInfo);
                promptMessage ('保存成功！','success',true);
                closeDialog('show');

            }else{
                promptMessage(data.msg, 'warning', false);
            }

        }
    });
}


