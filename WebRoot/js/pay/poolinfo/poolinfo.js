
var datatable;
var basePath = $("#excDataHid").val();
var account = {
    //地址
    url:{
        list_url : ctx + '/poolinfo/list.do',
        dataList_url : ctx + "/poolinfo/dataList.do",
        // add_url : ctx+ "/poolinfo/add.do",
        // update_url : ctx+ "/poolinfo/update.do",
        // queryId_url: ctx+ "/poolinfo/getId.do",
        // delete_url: ctx+ "/poolinfo/delete.do",
        manyOperation_url: ctx+ "/poolinfo/manyOperation.do",
        exportData_url : ctx +  "/poolinfo/exportData.do"
    },
    //列表显示参数
    list:[
        {"data":"poolType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.poolType==1){
                    html='<span>等待池</span>';
                }else if(oData.poolType==2){
                    html='<span><font color="red">抢单池</font></span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"nickname",},
        {"data":"phoneNum",},
        {"data":"balance",},
        {"data":"useMoney",},
        {"data":"wxName",},
        {"data":"bankName",},
        {"data":"payee",},
        {"data":"redPackNum",},
        {"data":"createTime",},
        // {"data":"ddQrCode",
        // },
        // {"data":"ddQrCode",
        //     "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
        //         // var html = '<div style="width: 50px;height: 50px">';
        //         var html = '<div class="divcss5">';
        //         html+='<img src="'+oData.ddQrCode+'" class="divcss5" >';
        //         html+='</div>';
        //         $(nTd).html(html);
        //     }
        // },

        {"data":"id",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                html+= '<a class = "dataTableBtn dataTableResetBtn"  directkey="' + oData.did + '"  directValue="' + oData.poolType + '" href = "javascript:void(0);"> 移出池子 </a>'
                    +' <a class = "dataTableBtn dataTableEnableBtn"  directkey="'+ oData.collectionAccountId + '"  directValue="2" href = "javascript:void(0);">暂停此群</a>'
                $(nTd).html(html);
            }
        }
    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        dataType:0,
        nickname:null,
        phoneNum:null,
        wxName:null,
        payee:null
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
            account.condJsonData['dataType'] = $("#dataType").val();
            account.condJsonData['nickname'] = $("#nickname").val();
            account.condJsonData['phoneNum'] = $("#phoneNum").val();
            account.condJsonData['wxName'] = $("#wxName").val();
            account.condJsonData['payee'] = $("#payee").val();
            account.queryTotal();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['dataType'] = "0";
            $("#dataType").val("0");
            account.condJsonData['nickname'] = "";
            $("#nickname").val("");
            account.condJsonData['phoneNum'] = "";
            $("#phoneNum").val("");
            account.condJsonData['wxName'] = "";
            $("#wxName").val("");
            account.condJsonData['payee'] = "";
            $("#payee").val("");
            common.showDatas(account.condJsonData,account.list);
        });


        //移出池子
        $(".dataTableResetBtn").live("click",function(){
            var did = $(this).attr('directkey');
            var poolType = $(this).attr('directValue');
            var data = {
                did:did,
                poolType:poolType
            }
            common.updateStatusByAlert(data, "移出池子");
        });

        //暂停群
        $(".dataTableEnableBtn").live("click",function(){
            var id = $(this).attr('directkey');
            var useStatus = $(this).attr('directValue');
            var data = {
                id:id,
                useStatus:useStatus
            }
            common.changeUseStatus(data);
        });
    },


    //汇总数据填充
    //查询所有池子汇总数据
    queryTotal:function(){
        var url = basePath + "poolinfo/totalData.do";

        var data = {
        };
        common.ajax(url,data,function(data){
            var data=data;
            var shtml="";
            shtml += "<font color='red'>《等待池：》</font>";
            shtml += "      用户数：";
            shtml += "<font color='red'>" + data.waitDidNum + "</font>";
            shtml += "      群数量：";
            shtml += "<font color='red'>" + data.waitGroupNum + "</font>";
            shtml += "      红包数：";
            shtml += "<font color='red'>" + data.waitRedPackNum + "</font>";
            shtml += "      余额：";
            shtml += "<font color='red'>" + data.waitBalance + "</font>";
            shtml += "      可用金额：";
            shtml += "<font color='red'>" + data.waitUseMoney + "</font>";

            shtml += "<font color='red'>《抢单池：》</font>";
            shtml += "      用户数：";
            shtml += "<font color='red'>" + data.openDidNum + "</font>";
            shtml += "      群数量：";
            shtml += "<font color='red'>" + data.openGroupNum + "</font>";
            shtml += "      红包数：";
            shtml += "<font color='red'>" + data.openRedPackNum + "</font>";
            shtml += "      余额：";
            shtml += "<font color='red'>" + data.openBalance + "</font>";
            shtml += "      可用金额：";
            shtml += "<font color='red'>" + data.openUseMoney + "</font>";

            shtml += "<font color='red'>《两池汇总：》</font>";
            shtml += "      用户数：";
            shtml += "<font color='red'>" + data.totalDidNum + "</font>";
            shtml += "      群数量：";
            shtml += "<font color='red'>" + data.totalGroupNum + "</font>";
            shtml += "      红包数：";
            shtml += "<font color='red'>" + data.totalRedPackNum + "</font>";
            shtml += "      余额：";
            shtml += "<font color='red'>" + data.totalBalance + "</font>";
            shtml += "      可用金额：";
            shtml += "<font color='red'>" + data.totalUseMoney + "</font>";
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
