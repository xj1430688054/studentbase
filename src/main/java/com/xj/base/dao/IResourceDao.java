package com.xj.base.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xj.base.dao.support.IBaseDao;
import com.xj.base.entity.Resource;

@Repository
public interface IResourceDao extends IBaseDao<Resource, Integer> {

	@Modifying
	@Query(nativeQuery = true,value = "DELETE FROM tb_role_resource WHERE resource_id = :id")
	void deleteGrant(@Param("id") Integer id);

}
