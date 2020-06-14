
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/accountteam/list.do',
        dataList_url : ctx + "/accountteam/dataList.do",
        add_url : ctx+ "/accountteam/add.do",
        update_url : ctx+ "/accountteam/update.do",
        queryId_url: ctx+ "/accountteam/getId.do",
        delete_url: ctx+ "/accountteam/delete.do",
        manyOperation_url: ctx+ "/accountteam/manyOperation.do"
    },
    //列表显示参数
    list:[
        {"data":"accountNum",},
        {"data":"roleName",},
        {"data":"teamName",},
        {"data":"contacts",},
        {"data":"phoneNum",},
        {"data":"did",},

        {"data":"id",
            "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                var html = '';
                var isEnableHtml = '';
                html = html = '<a class = "dataTableBtn dataTableDeleteBtn " href="'+ctx+'/accountteam/jumpUpdate.do?op=1&id='+oData.id+'"> 编辑 </a>'
                    +'<a class = "dataTableBtn" href="'+ctx+'/accountteam/jumpUpdate.do?op=2&id='+oData.id+'">重置密码 </a>'
                    +isEnableHtml
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
            window.location.href = ctx + "/accountteam/jumpAdd.do";
        });

        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);
        // 条件查询按钮事件
        $('#btnQuery').click(function() {
            account.condJsonData['accountNum'] = $("#accountNum").val();
            common.showDatas(account.condJsonData,account.list);
        });

        // 重置
        $("#butReset").click(function(){
            account.condJsonData['accountNum'] = "";
            $("#accountNum").val("");
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


}

$(function(){
    account.indexInit();
})
