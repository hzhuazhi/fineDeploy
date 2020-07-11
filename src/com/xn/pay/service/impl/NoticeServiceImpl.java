package com.xn.pay.service.impl;

import com.xn.common.service.impl.BaseServiceImpl;
import com.xn.pay.dao.BankDao;
import com.xn.pay.dao.NoticeDao;
import com.xn.pay.service.BankService;
import com.xn.pay.service.NoticeService;
import jxl.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/26 14:07
 * @Version 1.0
 */
@Service
public class NoticeServiceImpl<T> extends BaseServiceImpl<T> implements NoticeService<T> {
   private static Logger log= Logger.getLogger(NoticeServiceImpl.class);

   @Autowired
   private NoticeDao<T> noticeDao;
   @Override
   public NoticeDao<T> getDao() {
       // TODO Auto-generated method stub
       return noticeDao;
   }
}
