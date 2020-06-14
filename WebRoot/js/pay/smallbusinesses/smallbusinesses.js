
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/smallbusinesses/list.do',
        dataList_url : ctx + "/smallbusinesses/dataList.do",
        add_url : ctx+ "/smallbusinesses/add.do",
        update_url : ctx+ "/smallbusinesses/update.do",
        queryId_url: ctx+ "/smallbusinesses/getId.do",
        delete_url: ctx+ "/smallbusinesses/delete.do",
        manyOperation_url: ctx+ "/smallbusinesses/manyOperation.do"
    },
    //列表显示参数
    list:[
        {"data":"bindingMobile",},
        {"data":"acName",},
        {"data":"wxPassWd",},
        {"data":"wxName",},
        {"data":"toWxid",},
        {"data":"totalLink",},
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
                if(oData.useStatus==1){
                    html = '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/smallbusinesses/manyOperation.do?id='+oData.id+'&useStatus=2"> 禁用 </a>';
                }else if(oData.useStatus==2){
                    html = '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/smallbusinesses/manyOperation.do?id='+oData.id+'&useStatus=1"> 启用 </a>';
                }

                html+= '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/smallbusinesses/jumpUpdate.do?id='+oData.id+'"> 编辑 </a>'
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
        //添加
        $(".addbtn").live("click",function(){
            window.location.href = ctx + "/smallbusinesses/jumpAdd.do";
        });

        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['bindingMobile'] = $("#bindingMobile").val();
            account.condJsonData['acName'] = $("#acName").val();
            account.condJsonData['wxName'] = $("#wxName").val();
            account.condJsonData['toWxid'] = $("#toWxid").val();
            account.condJsonData['useStatus'] = $("#useStatus").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['cardName'] = "";
            account.condJsonData['useName'] = "";
            account.condJsonData['phoneNum'] = "";
            account.condJsonData['bindingMobile'] = "";
            account.condJsonData['useStatus'] = "0";
            $("#cardName").val("");
            $("#useName").val("");
            $("#phoneNum").val("");
            $("#bindingMobile").val("");
            $("#useStatus").val("0");
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
    }

}

$(function(){
    account.indexInit();
})
