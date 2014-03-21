package com.zyp.service;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.Orders;
@Service
public class OrdersServiceImpl extends BaseDaoImpl<Orders, String> implements OrdersService
{

}
