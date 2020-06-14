
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/bankcard/list.do',
        dataList_url : ctx + "/bankcard/dataList.do",
        add_url : ctx+ "/bankcard/add.do",
        update_url : ctx+ "/bankcard/update.do",
        queryId_url: ctx+ "/bankcard/getId.do",
        delete_url: ctx+ "/bankcard/delete.do",
        manyOperation_url: ctx+ "/bankcard/manyOperation.do"
    },
    //列表显示参数
    list:[
        {"data":"cardName",},
        {"data":"bankName",},
        {"data":"bankType",},
        {"data":"bankCard",},
        {"data":"accountName",},

        {"data":"inDayMoney",},
        {"data":"outDayMoney",},
        {"data":"inMonthMoney",},
        {"data":"outMonthMoney",},
        {"data":"inTotalMoney",},
        {"data":"outTotalMoney",},

        {"data":"smsNum",},
        {"data":"lastNum",},
        {"data":"smsContent",},
        {"data":"startKey",},
        {"data":"endKey",},
        {"data":"specialType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.specialType==1){
                    html='<span style="color: #9D080D">满 额</span>';
                }else if(oData.specialType==2){
                    html='<span>随 机</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"openType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.openType==1){
                    html='<span style="color: #5E9861">白天</span>';
                }else if(oData.openType==2){
                    html='<span style="color: #0c0c0c">晚上</span>';
                }else if(oData.openType==3){
                    html='<span >全天</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"daySwitch",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.daySwitch==1){
                    html='<span style="color:#4aff1a;">启用</span>';
                }else if(oData.daySwitch==2){
                    html='<span style="color:#ff301d;">禁用</span>';
                }
                 $(nTd).html(html);
            }
        },
        {"data":"useStatus",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.useStatus==1){
                    html='<span style="color:#4aff1a;">启用</span>';
                }else if(oData.useStatus==2){
                    html='<span style="color:#ff301d;">禁用</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"createTime",},
        {"data":"id",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                // if(oData.useStatus==1){
                //     html = '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/mobilecard/manyOperation.do?id='+oData.id+'&useStatus=2"> 禁用 </a>';
                // }else if(oData.useStatus==2){
                //     html = '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/mobilecard/manyOperation.do?id='+oData.id+'&useStatus=1"> 启用 </a>';
                // }

                html+= '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/bankcard/jumpUpdate.do?id='+oData.id+'"> 编辑 </a>'
                    +' <a class = "dataTableBtn dataTableResetBtn"  directkey="' + oData.id + '" href = "javascript:void(0);">删除 </a>';
                $(nTd).html(html);
            }
        }
    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        accountNum:null
    },
    //页面加载
    indexInit : function (){
        //url同步
        common.updateUrl(this.url);

        // 查询条件 - 下拉框数据获取
        this.queryGewayAll();


        //添加
        $(".addbtn").live("click",function(){
            // console.log("==========="+ctx + "/bankcard/jumpAdd.do");
            window.location.href = ctx + "/bankcard/jumpAdd.do";
        });

        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            console.log( $("#mobileCardId").val());
            account.condJsonData['mobileCardId'] = $("#mobileCardId").val();
            account.condJsonData['bankName'] = $("#bankName").val();
            account.condJsonData['bankCard'] = $("#bankCard").val();
            account.condJsonData['openType'] = $("#sel_openType").val();
            account.condJsonData['specialType'] = $("#sel_specialType").val();
            account.condJsonData['daySwitch'] = $("#sel_daySwitch").val();
            account.condJsonData['useStatus'] = $("#sel_useStatus").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['mobileCardId'] = "";
            account.condJsonData['bankCard'] = "";
            account.condJsonData['openType'] = "0";
            account.condJsonData['specialType'] = "0";
            account.condJsonData['daySwitch'] = "0";
            account.condJsonData['useStatus'] = "0";
            $("#mobileCardId").val("");
            $("#bankCard").val("");
            $("#sel_openType").val("0");
            $("#sel_specialType").val("0");
            $("#sel_daySwitch").val("0");
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
    queryGewayAll:function(){
        var url = ctx + "/mobilecard/dataAllList.do";
        console.log(url);
        var data = {
        };
        common.ajax(url,data,function(data){
            var dataList=data;
            var shtml="";
            shtml += "<select id='mobileCardId' name='mobileCardId'  class='text-input medium-input'>";
            shtml +="<option value=''>===请选择===</option>";
            for (var i=0;i<dataList.length>0;i++) {
                shtml +="<option value="+dataList[i].id+">"+dataList[i].cardName+"</option>";
            }
            shtml +="</select>";
            $("#mobileCardIdDiv").html(shtml);
        });
    }

}

$(function(){
    account.indexInit();
})
