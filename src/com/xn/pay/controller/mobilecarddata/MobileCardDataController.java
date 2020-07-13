package com.xn.pay.controller.mobilecarddata;

import com.xn.common.constant.ManagerConstant;
import com.xn.common.controller.BaseController;
import com.xn.common.util.BeanUtils;
import com.xn.common.util.DateUtil;
import com.xn.common.util.ExportData;
import com.xn.common.util.HtmlUtil;
import com.xn.pay.controller.teamzfbdata.TeamZfbDataController;
import com.xn.pay.model.MobileCardDataModel;
import com.xn.pay.model.MobileCardDataModel;
import com.xn.pay.service.MobileCardDataService;
import com.xn.pay.service.TeamZfbDataService;
import com.xn.system.entity.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description 手机卡所有短信内容数据的Controller层
 * @Author yoko
 * @Date 2020/7/12 21:37
 * @Version 1.0
 */
@Controller
@RequestMapping("/mobilecarddata")
public class MobileCardDataController extends BaseController {

    private static Logger log = Logger.getLogger(MobileCardDataController.class);

    @Autowired
    private MobileCardDataService<MobileCardDataModel> mobileCardDataService;


    /**
     * 获取页面
     */
    @RequestMapping("/list")
    public String list() {
        return "pay/mobilecarddata/mobilecarddataIndex";
    }


    /**
     *
     * 获取表格数据列表
     */
    @RequestMapping("/dataList")
    public void dataList(HttpServletRequest request, HttpServletResponse response, MobileCardDataModel model) throws Exception {
        List<MobileCardDataModel> dataList = new ArrayList<MobileCardDataModel>();
        if (model.getCurdayStart() == 0 || model.getCurdayEnd() == 0){
            model.setCurdayStart(DateUtil.getDayNumber(new Date()));
            model.setCurdayEnd(DateUtil.getDayNumber(new Date()));
        }
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            if (account.getRoleId() == ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ONE){
                //不是管理员，只能查询自己的数据
                dataList = mobileCardDataService.queryByList(model);
            }
        }
        HtmlUtil.writerJson(response, model.getPage(), dataList);
    }


    /**
     * 按照Excel报表导出数据
     */
    @RequestMapping("/exportData")
    public void exportDataNew(HttpServletRequest request, HttpServletResponse response, MobileCardDataModel model) throws Exception {
        exportData(request,response,model);
    }


    /**
     * 实际导出Excel
     * @param request
     * @param response
     * @param model
     */
    public void exportData(HttpServletRequest request, HttpServletResponse response, MobileCardDataModel model) {
        Account account = (Account) WebUtils.getSessionAttribute(request, ManagerConstant.PUBLIC_CONSTANT.ACCOUNT);
        if(account !=null && account.getId() > ManagerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){

            if (model.getCurdayStart() ==0 || model.getCurdayEnd() == 0){
                model.setCurdayStart(DateUtil.getDayNumber(new Date()));
                model.setCurdayEnd(DateUtil.getDayNumber(new Date()));
            }
            List<MobileCardDataModel> dataList = new ArrayList<MobileCardDataModel>();
            dataList = mobileCardDataService.queryAllList(model);
            // 导出数据
            String[] titles = new String[10];
            String[] titleCode = new String[10];
            String filename = "短信信息";
            titles = new String[]{"手机号", "短信号段", "短信内容", "短信类型", "创建时间", "手机卡名称", "手机卡归属人"};
            titleCode = new String[]{"phoneNum", "smsNum", "smsContent", "dataTypeStr", "createTime", "cardName", "useName"};
            List<Map<String,Object>> paramList = new ArrayList<>();
            for(MobileCardDataModel paramO : dataList){

                if (paramO.getDataType() == 1){
                    paramO.setDataTypeStr("广告短信");
                }else if (paramO.getDataType() == 2){
                    paramO.setDataTypeStr("挂失短信");
                }else if (paramO.getDataType() == 3){
                    paramO.setDataTypeStr("欠费短信");
                }else if (paramO.getDataType() == 4){
                    paramO.setDataTypeStr("普通短信");
                }else if (paramO.getDataType() == 5){
                    paramO.setDataTypeStr("手机卡变更");
                }else if (paramO.getDataType() == 6){
                    paramO.setDataTypeStr("其它短信");
                }

                Map<String,Object> map = BeanUtils.transBeanToMap(paramO);
                paramList.add(map);
            }
            ExportData.exportExcel(paramList, titles, titleCode, filename, response);

        }
    }
}
