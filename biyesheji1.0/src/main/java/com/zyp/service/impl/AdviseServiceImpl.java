package com.zyp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.Advise;
import com.zyp.model.AdvisePosition;
import com.zyp.service.AdviseService;
@Service
public class AdviseServiceImpl extends BaseDaoImpl<Advise, Long> implements AdviseService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Advise> findByPosition(AdvisePosition advisePosition)
	{
		
		return getSession().createQuery("FROM Advise a WHERE a.advisePosition=?").setParameter(0, advisePosition).list();
	}

}
