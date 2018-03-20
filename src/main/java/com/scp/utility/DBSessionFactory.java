package com.scp.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface DBSessionFactory {
	Configuration cfg = new Configuration().configure("hibernate-cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
}
