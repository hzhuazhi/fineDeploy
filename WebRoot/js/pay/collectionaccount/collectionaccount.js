
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/collectionaccount/list.do',
        dataList_url : ctx + "/collectionaccount/dataList.do",
        add_url : ctx+ "/collectionaccount/add.do",
        update_url : ctx+ "/collectionaccount/update.do",
        queryId_url: ctx+ "/collectionaccount/getId.do",
        delete_url: ctx+ "/collectionaccount/delete.do",
        manyOperation_url: ctx+ "/collectionaccount/manyOperation.do",
        queryExamine_url: ctx+ "/collectionaccount/queryExamine.do"
    },
    //列表显示参数
    list:[
        {"data":"did",},
        {"data":"wxName",},
        {"data":"acName",},
        {"data":"acType",},
        // {"data":"acNum",},
        // {"data":"mmQrCode",},
        {"data":"ddQrCode",},
        {"data":"payee",},
        {"data":"businessType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.businessType==1){
                    html='<span >个人</span>';
                }else if(oData.businessType==3){
                    html='<span >个体工商</span>';
                }else if(oData.businessType==2){
                    html='<span >公司</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"wxQrCodeAds",},
        {"data":"checkStatus",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.checkStatus==1){
                    html='<span style="color:#ff80ef;">待审核</span>';
                }else if(oData.checkStatus==3){
                    html='<span style="color:#29ff20;">审核通过</span>';
                }else if(oData.checkStatus==2){
                    html='<span style="color:#ff301d;">审核失败</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"checkInfo",},
        {"data":"remark",},
        {"data":"createTime",},
        {"data":"id",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';

                html+= '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/collectionaccount/jumpUpdate.do?id='+oData.id+'"> 编辑 </a>'
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
        // $(".addbtn").live("click",function(){
        //     window.location.href = ctx + "/collectionaccount/jumpAdd.do";
        // });

        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['did'] = $("#did").val();
            account.condJsonData['checkStatus'] = $("#checkStatus").val();
            account.condJsonData['wxId'] = $("#wxId").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['did'] = "";
            account.condJsonData['checkStatus'] = "";
            account.condJsonData['wxId'] = "";
            $("#did").val("");
            $("#checkStatus").val("");
            $("#wxId").val("");
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
        var url = ctx + "/smallbusinesses/dataAllList.do";
        var data = {
        };
        common.ajax(url,data,function(data){
            var dataList=data;
            var shtml="";
            shtml += "<select id='wxId' name='wxId'  class='text-input medium-input'>";
            shtml +="<option value=''>===请选择===</option>";
            for (var i=0;i<dataList.length>0;i++) {
                shtml +="<option value="+dataList[i].id+">"+dataList[i].wxName+"</option>";
            }
            shtml +="</select>";
            $("#divWxid").html(shtml);
        });
    }

}

$(function(){
    account.indexInit();
})
