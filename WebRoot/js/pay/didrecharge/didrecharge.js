
var datatable;
var basePath = $("#excDataHid").val();
var account = {
    //地址
    url:{
        list_url : ctx + '/didrecharge/list.do',
        dataList_url : ctx + "/didrecharge/dataList.do",
        add_url : ctx+ "/didrecharge/add.do",
        update_url : ctx+ "/didrecharge/update.do",
        queryId_url: ctx+ "/didrecharge/getId.do",
        delete_url: ctx+ "/didrecharge/delete.do",
        manyOperation_url: ctx+ "/didrecharge/manyOperation.do"
    },
    //列表显示参数
    list:[
        {"data":"orderNo",},
        {"data":"bankName",},
        {"data":"bankCard",},
        {"data":"accountName",},
        {"data":"orderMoney",},
        {"data":"invalidTime",},
        {"data":"depositor",},
        {"data":"depositMoney",},
        // {"data":"depositTime",},
        {"data":"lastNum",},
        // {"data":"pictureAds",},
        {"data":"pictureAds",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.pictureAds!=""){
                    html='<img src="'+oData.pictureAds+'"  style="width: 100px;height: 100px">';
                }
                $(nTd).html(html);
            }
        },
        {"data":"orderStatus",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.orderStatus==-1){
                    html='<span>申诉</span>';
                }else if(oData.orderStatus==1){
                    html='<span>初始化</span>';
                }else if(oData.orderStatus==2){
                    html='<span>超时</span>';
                }else if(oData.orderStatus==3){
                    html='<span>成功</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"checkStatus",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.checkStatus==1){
                    html='<span>初始化</span>';
                }else if(oData.checkStatus==2){
                    html='<span>审核中</span>';
                }else if(oData.checkStatus==3){
                    html='<span>审核失败</span>';
                }else if(oData.checkStatus==4){
                    html='<span>审核成功</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"checkInfo",},
        {"data":"id",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                var checkHtml = '';
                if (oData.checkStatus < 4){
                    checkHtml = '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/didrecharge/jumpUpdate.do?id='+oData.id+'"> 审核 </a>';
                }else{
                    checkHtml = '审核成功';
                }
                html += checkHtml;
                $(nTd).html(html);
            }
        }
    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        curdayStart:0,
        curdayEnd:0,
        orderNo:null,
        depositor:null,
        bankId:0,
        bankName:null,
        bankCard:null,
        accountName:null,
        orderStatus:0,
        checkStatus:0
    },
    //页面加载
    indexInit : function (){
        //url同步
        common.updateUrl(this.url);
        this.queryBankAll();
        // //添加
        // $(".addbtn").live("click",function(){
        //     window.location.href = ctx + "/bank/jumpAdd.do";
        // });

        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['curdayStart'] = $("#curdayStart").val();
            account.condJsonData['curdayEnd'] = $("#curdayEnd").val();
            account.condJsonData['orderNo'] = $("#orderNo").val();
            account.condJsonData['depositor'] = $("#depositor").val();
            account.condJsonData['bankId'] = $("#bankId").val();
            account.condJsonData['bankName'] = $("#bankName").val();
            account.condJsonData['bankCard'] = $("#bankCard").val();
            account.condJsonData['accountName'] = $("#accountName").val();
            account.condJsonData['orderStatus'] = $("#orderStatus").val();
            account.condJsonData['checkStatus'] = $("#checkStatus").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['curdayStart'] = "0";
            $("#curdayStart").val("0");
            account.condJsonData['curdayEnd'] = "0";
            $("#curdayEnd").val("0");
            account.condJsonData['orderNo'] = "";
            $("#orderNo").val("");
            account.condJsonData['depositor'] = "";
            $("#depositor").val("");
            account.condJsonData['bankId'] = "0";
            $("#bankId").val("0");
            account.condJsonData['bankName'] = "";
            $("#bankName").val("");
            account.condJsonData['bankCard'] = "";
            $("#bankCard").val("");
            account.condJsonData['accountName'] = "";
            $("#accountName").val("");
            account.condJsonData['orderStatus'] = "0";
            $("#orderStatus").val("0");
            account.condJsonData['checkStatus'] = "0";
            $("#checkStatus").val("0");
            common.showDatas(account.condJsonData,account.list);
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

    //下拉框数据填充
    //查询所有银行卡-无分页-下拉框选项:
    queryBankAll:function(){
        var url = basePath + "bankcard/dataAllList.do";
        var data = {
        };
        common.ajax(url,data,function(data){
            var dataList=data;
            var shtml="";
            shtml += "<select id='bankId' name='bankId'  class='text-input medium-input'>";
            shtml +="<option value=''>===请选择===</option>";
            for (var i=0;i<dataList.length>0;i++) {
                // shtml +="<option value="+dataList[i].id+">"+dataList[i].channelName+"</option>";
                shtml +="<option value="+dataList[i].id+">==="+dataList[i].bankName+"==="+dataList[i].accountName+"==="+dataList[i].bankCard+"</option>";
                // shtml +="<option value="+dataList[i].id+">==="+dataList[i].bankName+"==="+dataList[i].accountName+"</option>";
            }
            shtml +="</select>";
            $("#bankDiv").html(shtml);
        });
    }

}

$(function(){
    account.indexInit();
})
