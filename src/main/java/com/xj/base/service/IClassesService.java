package com.xj.base.service;

import com.xj.base.entity.Classes;
import com.xj.base.service.support.IBaseService;

public interface IClassesService extends IBaseService<Classes, Integer>{

	void saveOrUpdate(Classes classes);

}
