package com.practice.hibernate_practice.utils;

import java.util.Properties;

import org.hibernate.service.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.practice.hibernate_practice.model.Employee;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			Configuration cfg = new Configuration();
			Properties prop = new Properties();
			prop.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			prop.put(Environment.URL, "jdbc:mysql://localhost:3306/employees");
			prop.put(Environment.USER, "root");
			prop.put(Environment.PASS, "badru");
			prop.put(Environment.SHOW_SQL, "true");
			prop.put(Environment.HBM2DDL_AUTO, "update");
			
			//Add properties in config object 
			cfg.setProperties(prop);
			 
		System.out.println("111---");
             cfg.addAnnotatedClass(Employee.class);
             
             ServiceRegistry registry =  new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			
			sessionFactory= cfg.buildSessionFactory(registry);
		}
		
		return sessionFactory;
	}
		
		
	

}
