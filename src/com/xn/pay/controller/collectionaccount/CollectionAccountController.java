package com.xn.pay.controller.collectionaccount;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.util.HtmlUtil;
import com.xn.pay.model.*;
import com.xn.pay.service.*;
import com.xn.system.entity.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2020/5/21 19:38
 * @Version 1.0
 */

@Controller
@RequestMapping("/collectionaccount")
public class CollectionAccountController<T> extends BaseController {
    private static Logger log = Logger.getLogger(CollectionAccountController.class);

    @Autowired
    private CollectionAccountService<CollectionAccount> collectionAccountService;

    @Autowired
    private WxClerkService<WxClerk> wxClerkService;

    @Autowired
    private SmallBusinessesService<SmallBusinesses> smallBusinessesService;

    @Autowired
    private CatDataBindingService<CatDataBinding> catDataBindingService;

    @Autowired
    private  DidCollectionAccountQrCodeService<DidCollectionAccountQrCode>  didCollectionAccountQrCodeService;

    /**
     * 获取页面
     */
    @RequestMapping("/list")
    public String list() {
        return "pay/collectionaccount/collectionaccountIndex";
    }


    /**
     *
     * 获取表格数据列表
     */
    @RequestMapping("/dataList")
    public void dataList(HttpServletRequest request, HttpServletResponse response, CollectionAccount model) throws Exception {
        List<CollectionAccount> dataList = new ArrayList<CollectionAccount>();
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() != ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                //不是管理员，只能查询自己的数据
//                model.setLinkId(account.getId());
//                model.setRoleId(account.getRoleId());
            }

            dataList = collectionAccountService.queryByList(model);
            for(CollectionAccount collectionAccount:dataList){
                DidCollectionAccountQrCode  didCollectionAccountQrCode  =new DidCollectionAccountQrCode();
                didCollectionAccountQrCode.setCollectionAccountId(collectionAccount.getId());
                List<DidCollectionAccountQrCode>  didList = didCollectionAccountQrCodeService.queryAllList(didCollectionAccountQrCode);
                if(didList.size()>0){
                    collectionAccount.setDdQrCode(didList.get(0).getDdQrCode());
                }
            }
        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
    }



    @RequestMapping("/queryExamine")
    public void queryExamine(HttpServletRequest request, HttpServletResponse response,CollectionAccount model) throws Exception {
        String state ="";
        String wxname ="";
        List<CatDataBinding> dataList = new ArrayList<CatDataBinding>();
        CatDataBinding  catDataBinding= new CatDataBinding();
        catDataBinding.setCollectionAccountId(model.getId());
        dataList = catDataBindingService.queryAllList(catDataBinding);
        List<Map<String,String>>    list= new ArrayList<>();
        Map<String,String> rsMap = new HashMap<>();
        if(dataList.size()==0){
//            sendSuccessMessage(response, "还未查询到绑定数据，稍等1 -2 秒在进行点击");
            state  ="还未查询到绑定数据，稍等1 -2 秒在进行点击";
            rsMap.put("rscode","1");
            rsMap.put("state",state);
        }else{
            wxname=dataList.get(0).getWxName();
           //更新微信昵称
//            CollectionAccount  collectionAccount = new  CollectionAccount();
//            collectionAccount.setId(model.getId());
//            collectionAccount.setWxId(dataList.get(0).getWxId());

//            CatDataBinding  catDataBinding1= new CatDataBinding();
//            catDataBinding1.setId(dataList.get(0).getId());
//            catDataBinding1.setRunStatus(3);
//            int  count =catDataBindingService.bindingSmail(collectionAccount,catDataBinding1);


            state="检查成功，请扫描微信二维码确定名字是否一致！";
            rsMap.put("rscode","0");
            rsMap.put("wx_id",""+dataList.get(0).getWxId());
            rsMap.put("state",state);
            rsMap.put("wxname",wxname);
            rsMap.put("rowCount","1");

        }
        list.add(rsMap);
        model.setRowCount(1);
        HtmlUtil.writerJson(response,model.getPage(), list);
    }



    /**
     *
     * 获取表格数据列表-无分页
     */
    @RequestMapping("/dataAllList")
    public void dataAllList(HttpServletRequest request, HttpServletResponse response, CollectionAccount model) throws Exception {
        List<CollectionAccount> dataList = new ArrayList<CollectionAccount>();
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() != ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                //不是管理员，只能查询自己的数据
//                model.setLinkId(account.getId());
//                model.setRoleId(account.getRoleId());
            }
            dataList = collectionAccountService.queryAllList(model);
        }
        HtmlUtil.writerJson(response, dataList);
    }

    /**
     * 获取新增页面
     */
    @RequestMapping("/jumpAdd")
    public String jumpAdd(HttpServletRequest request, HttpServletResponse response) {
//        model.addAttribute("rloeMenu", roleService.queryList());
        return "pay/collectionaccount/collectionaccountAdd";
    }

    /**
     * 添加数据
     */
    @RequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response, CollectionAccount bean) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
//            bean.setLinkId(account.getId());
//            bean.setRoleId(account.getRoleId());
            collectionAccountService.add(bean);
            sendSuccessMessage(response, "保存成功~");
        }else {
            sendFailureMessage(response,"登录超时,请重新登录在操作!");
        }
    }

    /**
     * 获取修改页面
     */
    @RequestMapping("/jumpUpdate")
    public String jumpUpdate(Model model, long id) {
        CollectionAccount atModel = new CollectionAccount();
        atModel.setId(id);
        CollectionAccount collectionAccount  =collectionAccountService.queryById(atModel);

        DidCollectionAccountQrCode  didCollectionAccountQrCode  =new DidCollectionAccountQrCode();
        didCollectionAccountQrCode.setCollectionAccountId(collectionAccount.getId());
        List<DidCollectionAccountQrCode>  didList = didCollectionAccountQrCodeService.queryAllList(didCollectionAccountQrCode);
        if(didList.size()>0){
            collectionAccount.setDdQrCode(didList.get(0).getDdQrCode());
        }
        List<SmallBusinesses>  list =   smallBusinessesService.queryAllList();
        model.addAttribute("account", collectionAccount);
        model.addAttribute("small", list);
        if(collectionAccount.getAcType()==3){
            return "pay/collectionaccount/collectionaccountgroupEdit";
        }else{
            return "pay/collectionaccount/collectionaccountEdit";
        }
    }

    /**
     * 修改数据
     */
    @RequestMapping("/update")
    public void update(HttpServletRequest request, HttpServletResponse response,CollectionAccount bean) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){


//            CollectionAccount  collectionAccount = new CollectionAccount();
//            collectionAccount.setAcType(3);
//            collectionAccount.setPayee(bean.getPayee());
//            List<CollectionAccount>  list = collectionAccountService.queryByListPayee(collectionAccount);

//            if(list.size()==0){
//                collectionAccountService.update(bean);
//            }else{
//                sendFailureMessage(response, "该名已经存在！");
//            }

            collectionAccountService.update(bean);

            if(bean.getCheckStatus()==3){
                WxClerk wxClerk =  new WxClerk();
                wxClerk.setWxId(bean.getWxId());
                wxClerk.setCollectionAccountId(bean.getId());
                wxClerkService.deleteCollectionAccountId(bean.getId());
                wxClerkService.add(wxClerk);
                CatDataBinding  catDataBinding = new  CatDataBinding();
                catDataBinding.setWxId(bean.getWxId());
                catDataBinding.setRunStatus(3);
                catDataBindingService.bindingSmail(catDataBinding);
            }

            if(bean.getWxId() == null || bean.getWxId() == 0){

            }else if(bean.getWxId()!=0){
                WxClerk wxClerk =  new WxClerk();
                wxClerk.setWxId(bean.getWxId());
                wxClerk.setCollectionAccountId(bean.getId());
                wxClerkService.deleteCollectionAccountId(bean.getId());
                wxClerkService.add(wxClerk);
                CatDataBinding  catDataBinding = new  CatDataBinding();
                catDataBinding.setWxId(bean.getWxId());
                catDataBinding.setRunStatus(3);
                catDataBindingService.bindingSmail(catDataBinding);
            }
            sendSuccessMessage(response, "保存成功~");
        }else {
            sendFailureMessage(response, "登录超时,请重新登录在操作!");
        }
    }





    /**
     * 修改数据
     */
    @RequestMapping("/updatePayee")
    public void updatePayee(HttpServletRequest request, HttpServletResponse response,CollectionAccount bean) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){

            CollectionAccount  collectionAccount = new CollectionAccount();
            collectionAccount.setAcType(3);
            collectionAccount.setPayee(bean.getPayee());
            List<CollectionAccount>  list = collectionAccountService.queryByListPayee(collectionAccount);
            if(list.size()==0){
                collectionAccountService.update(bean);
                sendSuccessMessage(response, "保存成功~");
            }else{
                sendFailureMessage(response, "该名已经存在！");
            }
        }else {
            sendFailureMessage(response, "登录超时,请重新登录在操作!");
        }
    }
    /**
     * 删除数据
     */
    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, CollectionAccount bean) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            collectionAccountService.delete(bean);
            sendSuccessMessage(response, "删除成功");
        }else{
            sendFailureMessage(response, "登录超时,请重新登录在操作!");
        }

    }

    /**
     * 启用/禁用
     */
    @RequestMapping("/manyOperation")
    public String manyOperation(HttpServletRequest request, HttpServletResponse response, CollectionAccount bean) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            collectionAccountService.manyOperation(bean);
//            sendSuccessMessage(response, "状态更新成功");
            return "pay/smallbusinesses/smallbusinessesIndex";
        }else{
            sendFailureMessage(response, "登录超时,请重新登录在操作!");
            return "";
        }
    }
}
