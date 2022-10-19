package com.tut;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class FetchDemo {

	public static void main(String[] args) {
//		get, load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

//        get student id = 3

		Student st = (Student) session.load(Student.class, 3);
		System.out.println(st.getName());

//        Student st1 = (Student)session.load(Student.class, 3); 
//        System.out.println(st1);

//        
//        Address ad = (Address)session.get(Address.class, 1); 
//        System.out.println(ad.toString());
//        
//        Address ad1 = (Address)session.get(Address.class, 1); 
//        System.out.println(ad1.toString());

		factory.close();
	}

}
