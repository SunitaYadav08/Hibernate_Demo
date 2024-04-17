package com.practice.hibernate_practice.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.hibernate_practice.model.Employee;
import com.practice.hibernate_practice.utils.HibernateUtils;

public class HibernateServcieDemo {
	
	public static void main(String args[]) {
		Transaction tx = null;
		try(SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		Session session = sessionFactory.openSession();){
		tx= session.beginTransaction();
			
		Employee emp1 = new Employee();
		emp1.setEmpName("Sunita");
		emp1.setCity("Agar");
		emp1.setStatus(true);
		
		session.save(emp1);
		System.out.println("Employee saved "+emp1 );
		
		tx.commit();
		
		}catch(Exception e) {
			if(tx==null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

}
