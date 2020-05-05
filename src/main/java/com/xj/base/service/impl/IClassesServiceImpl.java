package com.xj.base.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.base.dao.IClassesDao;
import com.xj.base.dao.support.IBaseDao;
import com.xj.base.entity.Classes;
import com.xj.base.entity.Course;
import com.xj.base.service.IClassesService;
import com.xj.base.service.support.impl.BaseServiceImpl;


@Service
public class IClassesServiceImpl  extends BaseServiceImpl <Classes, Integer> implements IClassesService{
	
	@Autowired
	private IClassesDao classesDao;

	@Override
	public IBaseDao<Classes, Integer> getBaseDao() {
		// TODO Auto-generated method stub
		return classesDao;
	}

	@Override
	public void saveOrUpdate(Classes classes) {
		if(classes.getId() != null){
			Classes dbcourse = find(classes.getId());
			dbcourse.setName(classes.getName());
			dbcourse.setUpdateTime(new Date());
			update(dbcourse);
		}else{
			
			classes.setCreateTime(new Date());
			save(classes);
		}		
	}

}
