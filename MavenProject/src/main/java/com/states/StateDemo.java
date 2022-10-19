package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Practical of States
//		1.Transient 
//		2.Persistence
//		3.Detached
//		4.Removed
		
		System.out.println("Eaample : ");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

//		Creating Student object
		
		Student student = new Student();
		student.setId(4);
		student.setName("Sudhanshu");
		student.setCity("Delhi");
		student.setCerti(new Certificate("java developer", "6Months"));
//		Student : Transient  
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		System.out.println(student.toString());
		
//		Student : Persistence Session ke_paas_bhi_h and databse_me_bhi_h 
//		student.setName("rahul");
		
		
		
		tx.commit();
		s.close();
//		detached_state Student : Database
		student.setName("rahul");
		System.out.println(student.toString());
		factory.close();
	}

}
