package com.xn.pay.service.impl;

import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.ConsultAskReplyDao;
import com.xn.pay.service.ConsultAskReplyService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description TODO
 * @Date 2020/5/26 14:07
 * @Version 1.0
 */
@Service
public class ConsultAskReplyServiceImpl<T> extends BaseServiceImpl<T> implements ConsultAskReplyService<T> {
   private static Logger log= Logger.getLogger(ConsultAskReplyServiceImpl.class);

   @Autowired
   private ConsultAskReplyDao<T> consultAskReplyDao;
   @Override
   public ConsultAskReplyDao<T> getDao() {
       // TODO Auto-generated method stub
       return consultAskReplyDao;
   }
}
