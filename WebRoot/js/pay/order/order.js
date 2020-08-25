
var datatable;
var basePath = $("#excDataHid").val();
var account = {
    //地址
    url:{
        list_url : ctx + '/order/list.do',
        dataList_url : ctx + "/order/dataList.do",
        // add_url : ctx+ "/tpDataInfo/add.do",
        // update_url : ctx+ "/tpDataInfo/update.do",
        // queryId_url: ctx+ "/tpDataInfo/getId.do",
        // delete_url: ctx+ "/tpDataInfo/delete.do",
        manyOperation_url: ctx+ "/order/manyOperation.do",
        exportData_url : ctx +  "/order/exportData.do"
    },
    //列表显示参数
    list:[
        {"data":"orderNo",},
        {"data":"outTradeNo",},
        {"data":"orderMoney",},
        {"data":"nickname",},
        {"data":"collectionType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.collectionType==1){
                    html='<span>微信个码</span>';
                }else if(oData.collectionType==2){
                    // html='<span><font color="red">失败</font></span>';
                    html='<span>支付宝个码</span>';
                }else if(oData.collectionType==3){
                    html='<span>微信群</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"wxNickname",},
        {"data":"orderStatus",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.orderStatus==1){
                    html='<span>初始化</span>';
                }else if(oData.orderStatus==2){
                    // html='<span><font color="red">失败</font></span>';
                    html='<span>超时/失败</span>';
                }else if(oData.orderStatus==3){
                    html='<span>质疑</span>';
                }else if(oData.orderStatus==4){
                    html='<span><font color="red">成功</font></span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"invalidTime",},
        {"data":"profit",},
        {"data":"isRedPack",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.isRedPack==1){
                    html='<span>未发红包</span>';
                }else if(oData.isRedPack==2){
                    html='<span><font color="red">已发红包</font></span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"redPackTime",},
        {"data":"isReply",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.isReply==1){
                    html='<span>初始化</span>';
                }else if(oData.isReply==2){
                    html='<span>系统回复</span>';
                }else if(oData.isReply==3){
                    html='<span><font color="red">回复失败</font></span>';
                }else if(oData.isReply==4){
                    html='<span>回复成功</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"replyData",
            // "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
            //     var html="";
            //     if(oData.moneyFitType==1){
            //         html='<span>初始化</span>';
            //     }else if(oData.moneyFitType==2){
            //         html='<span><font color="red">少了</font></span>';
            //     }else if(oData.moneyFitType==3){
            //         html='<span><font color="red">多了</font></span>';
            //     }else if(oData.moneyFitType==4){
            //         html='<span>一致</span>';
            //     }
            //     $(nTd).html(html);
            // }
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                html='<span style="color:red ">'+oData.replyData+'</span>';
                $(nTd).html(html);
            }
        },
        {"data":"replyTime",},
        {"data":"actualMoney",},
        {"data":"moneyFitType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.moneyFitType==1){
                    html='<span>初始化</span>';
                }else if(oData.moneyFitType==2){
                    html='<span><font color="red">少了</font></span>';
                }else if(oData.moneyFitType==3){
                    html='<span><font color="red">多了</font></span>';
                }else if(oData.moneyFitType==4){
                    html='<span>一致</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"replenishType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.replenishType==1){
                    html='<span>不是补单</span>';
                }else if(oData.replenishType==2){
                    html='<span><font color="red">是补单</font></span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"createTime",}
    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        orderNo:null,
        outTradeNo:null,
        nickname:null,
        wxNickname:null,
        orderStatus:0,
        isRedPack:0,
        isReply:0,
        moneyFitType:0,
        replenishType:0,
        curdayStart:0,
        curdayEnd:0
    },
    //页面加载
    indexInit : function (){
        //url同步
        common.updateUrl(this.url);

        // 初始化列表数据
        this.queryTotal();
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['orderNo'] = $("#orderNo").val();
            account.condJsonData['outTradeNo'] = $("#outTradeNo").val();
            account.condJsonData['nickname'] = $("#nickname").val();
            account.condJsonData['wxNickname'] = $("#wxNickname").val();
            account.condJsonData['orderStatus'] = $("#orderStatus").val();
            account.condJsonData['isRedPack'] = $("#isRedPack").val();
            account.condJsonData['isReply'] = $("#isReply").val();
            account.condJsonData['moneyFitType'] = $("#moneyFitType").val();
            account.condJsonData['replenishType'] = $("#replenishType").val();
            account.condJsonData['curdayStart'] = $("#curdayStart").val();
            account.condJsonData['curdayEnd'] = $("#curdayEnd").val();
            account.queryTotal();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['orderNo'] = "";
            $("#orderNo").val("");
            account.condJsonData['outTradeNo'] = "";
            $("#outTradeNo").val("");
            account.condJsonData['nickname'] = "";
            $("#nickname").val("");
            account.condJsonData['wxNickname'] = "";
            $("#wxNickname").val("");
            account.condJsonData['orderStatus'] = "0";
            $("#orderStatus").val("0");
            account.condJsonData['isRedPack'] = "0";
            $("#isRedPack").val("0");
            account.condJsonData['isReply'] = "0";
            $("#isReply").val("0");
            account.condJsonData['moneyFitType'] = "0";
            $("#moneyFitType").val("0");
            account.condJsonData['replenishType'] = "0";
            $("#replenishType").val("0");
            account.condJsonData['curdayStart'] = "";
            $("#curdayStart").val("");
            account.condJsonData['curdayEnd'] = "";
            $("#curdayEnd").val("");
            common.showDatas(account.condJsonData,account.list);
        });


        // 数据按照Excel格式导出
        $("#butExcelExport").click(function () {
            common.dataExportExcel($("#condForm"));
        });
    },


    //汇总数据填充
    //查询所有订单汇总数据
    queryTotal:function(){
        var url = basePath + "order/totalData.do";
        var orderNo = $("#orderNo").val();
        var outTradeNo = $("#outTradeNo").val();
        var nickname = $("#nickname").val();
        var wxNickname = $("#wxNickname").val();
        var orderStatus = $("#orderStatus").val();
        var isRedPack = $("#isRedPack").val();
        var isReply = $("#isReply").val();
        var moneyFitType = $("#moneyFitType").val();
        var replenishType = $("#replenishType").val();
        var curdayStart = $("#curdayStart").val();
        var curdayEnd = $("#curdayEnd").val();
        var data = {
            "orderNo":orderNo,
            "outTradeNo":outTradeNo,
            "nickname":nickname,
            "wxNickname":wxNickname,
            "orderStatus":orderStatus,
            "isRedPack":isRedPack,
            "isReply":isReply,
            "moneyFitType":moneyFitType,
            "replenishType":replenishType,
            "curdayStart":curdayStart,
            "curdayEnd":curdayEnd
        };
        common.ajax(url,data,function(data){
            var data=data;
            var shtml="";
            shtml += "汇总：         订单金额：";
            shtml += "<font color='red'>" + data.totalOrderMoney + "</font>";
            shtml += "      收益：";
            shtml += "<font color='red'>" + data.totalProfit + "</font>";
            shtml += "      实际上报金额：";
            shtml += "<font color='red'>" + data.totalActualMoney + "</font>";
            shtml += "      总订单数：";
            shtml += "<font color='red'>" + data.totalOrderNum + "</font>";
            shtml += "      总成功订单数：";
            shtml += "<font color='red'>" + data.totalSuccessOrderNum + "</font>";
            shtml += "      总质疑订单数：";
            shtml += "<font color='red'>" + data.totalQuestionOrderNum + "</font>";
            shtml += "      总成功金额：";
            shtml += "<font color='red'>" + data.totalSuccessMoney + "</font>";
            shtml += "      总质疑金额：";
            shtml += "<font color='red'>" + data.totalQuestionMoney + "</font>";
            shtml += "      总进群次数：";
            shtml += "<font color='red'>" + data.totalComeInGroupNum + "</font>";
            $("#totalDiv").html(shtml);
        });
    }

}

// function outQueryTotal(){
//     var url = basePath + "tpdata/totalData.do";
//     var myTradeNo = $("#myTradeNo").val();
//     var outTradeNo = $("#outTradeNo").val();
//     var tradeStatus = $("#tradeStatus").val();
//     var runStatus = $("#runStatus").val();
//     var curdayStart = $("#curdayStart").val();
//     var curdayEnd = $("#curdayEnd").val();
//     var data = {
//         "myTradeNo":myTradeNo,
//         "outTradeNo":outTradeNo,
//         "tradeStatus":tradeStatus,
//         "runStatus":runStatus,
//         "curdayStart":curdayStart,
//         "curdayEnd":curdayEnd
//     };
//     common.ajax(url,data,function(data){
//         var data=data;
//         var shtml="";
//         shtml += "汇总：         订单金额：";
//         shtml += "<font color='red'>" + data.totalMoney + "</font>";
//         shtml += "      手续费：";
//         shtml += "<font color='red'>" + data.totalServiceCharge + "</font>";
//         shtml += "      实际金额：";
//         shtml += "<font color='red'>" + data.totalActualMoney + "</font>";
//         $("#totalDiv").html(shtml);
//     });
// }

$(function(){
    account.indexInit();
})
