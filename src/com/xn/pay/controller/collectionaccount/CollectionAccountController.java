package com.xn.pay.controller.collectionaccount;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.util.HtmlUtil;
import com.xn.pay.model.CollectionAccount;
import com.xn.pay.model.SmallBusinesses;
import com.xn.pay.model.WxClerk;
import com.xn.pay.service.CollectionAccountService;
import com.xn.pay.service.SmallBusinessesService;
import com.xn.pay.service.WxClerkService;
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
import java.util.List;

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
        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
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
        model.addAttribute("account", collectionAccountService.queryById(atModel));
        model.addAttribute("small", smallBusinessesService.queryAllList());
        return "pay/collectionaccount/collectionaccountEdit";
    }

    /**
     * 修改数据
     */
    @RequestMapping("/update")
    public void update(HttpServletRequest request, HttpServletResponse response,CollectionAccount bean) throws Exception {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            collectionAccountService.update(bean);
            if(bean.getWxId() == null || bean.getWxId() == 0){

            }else if(bean.getWxId()!=0){
                WxClerk wxClerk =  new WxClerk();
                wxClerk.setWxId(bean.getWxId());
                wxClerk.setCollectionAccountId(bean.getId());
                wxClerkService.deleteCollectionAccountId(bean.getId());
                wxClerkService.add(wxClerk);
            }
            sendSuccessMessage(response, "保存成功~");
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
