package com.zyp.service;

import java.util.List;

import com.zyp.base.BaseDao;
import com.zyp.model.Advise;
import com.zyp.model.AdvisePosition;

public interface AdviseService extends BaseDao<Advise, Long>{

	List<Advise> findByPosition(AdvisePosition advisePosition);

}
