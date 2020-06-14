package com.xn.pay.service;

import com.xn.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2020/5/27 19:38
 * @Version 1.0
 */
public interface SmallBusinessesService <T> extends BaseService<T> {

    public void  updateRemarks(long wxId);
}
