package com.zyp.service.impl;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.PayModel;
import com.zyp.service.PayService;
@Service
public class PayServiceImpl extends BaseDaoImpl<PayModel, Long> implements PayService
{

}
