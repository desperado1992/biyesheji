package com.zyp.service;

import com.zyp.base.BaseDao;
import com.zyp.model.Setting;

public interface SettingService extends BaseDao<Setting, Long>{

	Setting findByPro(String prop);

}
