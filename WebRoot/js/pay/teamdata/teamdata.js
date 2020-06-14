
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/teamdata/list.do',
        dataList_url : ctx + "/teamdata/dataList.do",
        add_url : ctx+ "/teamdata/add.do",
        update_url : ctx+ "/teamdata/update.do",
        queryId_url: ctx+ "/teamdata/getId.do",
        delete_url: ctx+ "/teamdata/delete.do",
        manyOperation_url: ctx+ "/teamdata/manyOperation.do"
    },
    //列表显示参数
    list:[
        {"data":"nickname",},
        {"data":"acNum",},
        {"data":"totalMoney",},
        {"data":"balance",},
        {"data":"payee",},
        {"data":"isHave",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.isHave>=1){
                    html='<span>已绑</span>';
                }else{
                    html='<span>未绑</span>';
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
                    html='<span>审核失败</span>';
                }else if(oData.checkStatus==3){
                    html='<span>审核成功</span>';
                }else if(oData.checkStatus==4){
                    html='<span>无</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"checkInfo",}


    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        acNum:null,
        payee:null,
        isHave:0
    },
    //页面加载
    indexInit : function (){
        //url同步
        common.updateUrl(this.url);
        // //添加
        // $(".addbtn").live("click",function(){
        //     window.location.href = ctx + "/geway/jumpAdd.do";
        // });

        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['acNum'] = $("#acNum").val();
            account.condJsonData['payee'] = $("#payee").val();
            account.condJsonData['isHave'] = $("#isHave").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['acNum'] = "";
            $("#acNum").val("");
            account.condJsonData['payee'] = "";
            $("#payee").val("");
            account.condJsonData['isHave'] = "0";
            $("#isHave").val("0");
            common.showDatas(account.condJsonData,account.list);
        });
    }

}

$(function(){
    account.indexInit();
})
