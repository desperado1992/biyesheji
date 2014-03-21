package com.zyp.service;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.CartProduct;
@Service
public class CartProductServiceImpl extends BaseDaoImpl<CartProduct, String> implements CartProductService
{

}
