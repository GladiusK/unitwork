package com.yx.baseframe.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 功能描述: 所有Dao的统一父类
 * 
 * 
 * 
 * ************************************************ 
 */

@Component
public abstract class AbstractBaseDaoSupport<EntityManager> {

	private EntityManager entityManager;

	@Autowired
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public AbstractBaseDaoSupport() {
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}