
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/consultask/list.do',
        dataList_url : ctx + "/consultask/dataList.do",
        add_url : ctx+ "/consultask/add.do",
        update_url : ctx+ "/consultask/update.do",
        queryId_url: ctx+ "/consultask/getId.do",
        delete_url: ctx+ "/consultask/delete.do",
        manyOperation_url: ctx+ "/consultask/manyOperation.do"
    },
    //列表显示参数
    list:[
        {"data":"did",},
        {"data":"title",},
        {"data":"ask",},
        {"data":"askAds",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.askAds!=null&&oData.askAds!=""&&oData.askAds!=undefined&&oData.askAds!="undefined"){
                    html='<img src="'+oData.askAds+'" style="height: 200px;width: 200px">';
                }
                $(nTd).html(html);
            }
        },
        {"data":"replyStatus",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                if(oData.replyStatus==1){
                    html='<span style="color: #9D080D">待处理</span>';
                }else if(oData.replyStatus==2){
                    html='<span style="color: #399d19">回答完成</span>';
                }
                $(nTd).html(html);
            }
        },
        {"data":"createTime",},
        {"data":"updateTime",},
        {"data":"id",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                html+= '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/consultask/queryUpdate.do?id='+oData.id+'"> 查看 </a>'
                    +' <a class = "dataTableBtn dataTableResetBtn"  directkey="' + oData.id + '" href = "javascript:void(0);">删除 </a>';
                $(nTd).html(html);
            }
        }
    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
        replyStatus:"1"
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
            window.location.href = ctx + "/consultask/jumpAdd.do";
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
})
