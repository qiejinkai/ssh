package com.qjk.ssh.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<T> {
	
	@Resource
	protected SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	protected void save(T t) {
		this.getSession().save(t);
	}

	protected void update(T t) {
		this.getSession().update(t);
	}

	protected T findById(Class<? extends T> clazz,Serializable id) {
		return this.getSession().load(clazz, id);
	}

	protected void delete(Class<? extends T> clazz,Serializable id) {
		this.getSession().delete(this.findById(clazz,id));
	}

	public List<T> findListByHQL(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params);
		}
		return query.list();
	}
	
	public T findOneByHQL(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params);
		}
		return (T) query.uniqueResult();
	}
}
