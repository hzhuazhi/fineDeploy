
var datatable;
var account = {
    //地址
    url:{
        list_url : ctx + '/team/list.do',
        dataList_url : ctx + "/team/dataList.do"
    },
    //列表显示参数
    list:[
        {"data":"directNum",},
        {"data":"totalMoney",},
        {"data":"totalBalance",},
        {"data":"totalOrderMoney",},
        {"data":"oneMoneyNum",},
        {"data":"twoMoneyNum",},
        {"data":"threeMoneyNum",},
        {"data":"fourMoneyNum",},
        {"data":"fiveMoneyNum",}



    ],
    // 查询条件，aoData是必要的。其他的就是对应的实体类字段名，因为条件查询是把数据封装在实体类中的。
    condJsonData : {
    },
    //页面加载
    indexInit : function (){
        //url同步
        common.updateUrl(this.url);


        // 初始化列表数据
        common.showDatas(this.condJsonData,this.list);



    }

}

$(function(){
    account.indexInit();
})
