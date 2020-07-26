
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/operate/list.do',
        dataList_url : ctx + "/operate/dataList.do",
        add_url : ctx+ "/operate/add.do",
        update_url : ctx+ "/operate/update.do",
        queryId_url: ctx+ "/operate/getId.do",
        delete_url: ctx+ "/operate/delete.do",
        manyOperation_url: ctx+ "/operate/manyOperation.do"
    },
    //列表显示参数
    list:[
        {"data":"analysisId",},
        {"data":"did",},
        {"data":"wxId",},
        {"data":"collectionAccountId",},
        {"data":"groupWxid",},
        {"data":"groupName",},
        {"data":"userId",},
        {"data":"orderNo",},
        {"data":"orderMoney",},
        {"data":"orderStatus",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.orderStatus==1){
                    html='<span >初始化</span>';
                }else if(oData.orderStatus==2){
                    html='<span >超时/失败</span>';
                }else if(oData.orderStatus==3){
                    html='<span >有质疑</span>';
                }else if(oData.orderStatus==4){
                    html='<span >成功</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"punishType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.punishType==1){
                    html='<span >不处罚</span>';
                }else if(oData.punishType==2){
                    html='<span >处罚</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"punishMoney",},
        {"data":"dataType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.dataType==1){
                    html='<span ">初始化</span>';
                }else if(oData.dataType==2){
                    html='<span >其它</span>';
                }else if(oData.dataType==3){
                    html='<span >加群</span>';
                }else if(oData.dataType==4){
                    html='<span >发红包</span>';
                }else if(oData.dataType==5){
                    html='<span >删小微</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"dataExplain",},
        {"data":"isOk",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.isOk==1){
                    html='<span style="color:#fffc4a;">初始化</span>';
                }else if(oData.isOk==2){
                    html='<span style="color:#399d19;">处理中</span>';
                }else if(oData.isOk==3){
                    html='<span style="color:#ff301d;">处理失败</span>';
                }else if(oData.isOk==4){
                    html='<span style="color:#54ff20;">处理成功</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"endType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.endType==1){
                    html='<span style="color:#4aff1a;">需要处理完毕</span>';
                }else if(oData.endType==2){
                    html='<span style="color:#ff301d;">不需要处理完毕</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"remark",},
        {"data":"id",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                html+= '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/operate/jumpUpdate.do?id='+oData.id+'"> 编辑 </a>'
                    +' <a class = "dataTableBtn dataTableResetBtn"  directkey="' + oData.id + '" href = "javascript:void(0);">删除 </a>';
                $(nTd).html(html);
            }
        }
    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
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
            window.location.href = ctx + "/operate/jumpAdd.do";
        });
        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['orderNo'] = $("#orderNo").val();
            account.condJsonData['groupWxid'] = $("#groupWxid").val();
            account.condJsonData['groupName'] = $("#groupName").val();
            account.condJsonData['dataType'] = $("#dataType").val();
            account.condJsonData['isOk'] = $("#isOk").val();
            account.condJsonData['endType'] = $("#endType").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['orderNo'] = "";
            account.condJsonData['groupWxid'] = "";
            account.condJsonData['groupName'] = "";
            account.condJsonData['dataType'] = "0";
            account.condJsonData['isOk'] = "0";
            account.condJsonData['endType'] = "0";
            $("#orderNo").val("");
            $("#groupWxid").val("");
            $("#groupName").val("");
            $("#dataType").val("0");
            $("#isOk").val("0");
            $("#endType").val("0");
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
})
