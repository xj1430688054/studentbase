package com.xj.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xj.base.entity.support.BaseEntity;

import lombok.Data;

/**
 * 公告实体类
 * @author xj
 *
 */
@Data
@Entity
@Table(name = "tb_notice_type")
public class NoticeType extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	private String name;
	private Integer tid;
	
	
}
