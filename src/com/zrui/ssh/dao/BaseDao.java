package com.zrui.ssh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {
	
	private SessionFactory sessionfactory;
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	

	

}
