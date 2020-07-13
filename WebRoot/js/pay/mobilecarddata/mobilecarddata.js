
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/mobilecarddata/list.do',
        dataList_url : ctx + "/mobilecarddata/dataList.do",
        add_url : ctx+ "/mobilecarddata/add.do",
        update_url : ctx+ "/mobilecarddata/update.do",
        queryId_url: ctx+ "/mobilecarddata/getId.do",
        delete_url: ctx+ "/mobilecarddata/delete.do",
        manyOperation_url: ctx+ "/mobilecarddata/manyOperation.do",
        exportData_url : ctx +  "/mobilecarddata/exportData.do"
    },
    //列表显示参数
    list:[
        {"data":"phoneNum",},
        {"data":"smsNum",},
        {"data":"smsContent",},
        {"data":"dataType",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html="";
                if(oData.dataType==1){
                    html='<span>广告短信</span>';
                }else if (oData.dataType==2) {
                    html='<span>挂失短信</span>';
                }else if (oData.dataType==3) {
                    html='<span>欠费短信</span>';
                }else if (oData.dataType==4) {
                    html='<span><font color="red">普通短信</font></span>';
                }else if (oData.dataType==5) {
                    html='<span>手机卡变更</span>';
                }else if (oData.dataType==6) {
                    html='<span>其它短信</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"createTime",},

        {"data":"cardName",},
        {"data":"useName",}

    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        curdayStart:0,
        curdayEnd:0,
        phoneNum:null,
        smsNum:null,
        dataType:0
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
            account.condJsonData['curdayStart'] = $("#curdayStart").val();
            account.condJsonData['curdayEnd'] = $("#curdayEnd").val();
            account.condJsonData['phoneNum'] = $("#phoneNum").val();
            account.condJsonData['smsNum'] = $("#smsNum").val();
            account.condJsonData['dataType'] = $("#dataType").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['curdayStart'] = "";
            $("#curdayStart").val("");
            account.condJsonData['curdayEnd'] = "";
            $("#curdayEnd").val("");
            account.condJsonData['phoneNum'] = "";
            $("#phoneNum").val("");
            account.condJsonData['smsNum'] = "";
            $("#smsNum").val("");
            account.condJsonData['dataType'] = "0";
            $("#dataType").val("0");
            common.showDatas(account.condJsonData,account.list);
        });

        // 数据按照Excel格式导出
        $("#butExcelExport").click(function () {
            common.dataExportExcel($("#condForm"));
        });
    }

}

$(function(){
    account.indexInit();
})
