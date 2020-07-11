package com.xn.pay.service.impl;

import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.ConsultAskDao;
import com.xn.pay.dao.NoticeDao;
import com.xn.pay.service.ConsultAskService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description TODO
 * @Date 2020/5/26 14:07
 * @Version 1.0
 */
@Service
public class ConsultAskServiceImpl<T> extends BaseServiceImpl<T> implements ConsultAskService<T> {
   private static Logger log= Logger.getLogger(ConsultAskServiceImpl.class);

   @Autowired
   private ConsultAskDao<T> consultAskDao;
   @Override
   public ConsultAskDao<T> getDao() {
       // TODO Auto-generated method stub
       return consultAskDao;
   }
}
