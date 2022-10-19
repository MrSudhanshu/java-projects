package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student stu = new Student();
		stu.setId(143);
		stu.setName("Rahul");
		stu.setCity("Bareilly");

		Certificate cer = new Certificate();
		cer.setCourse("B.tech");
		cer.setDuration("4 Years");
		stu.setCerti(cer);

		Student stu1 = new Student();
		stu.setId(143);
		stu.setName("Sudhanshu");
		stu.setCity("Pilibhit");

		Certificate cer1 = new Certificate();
		cer1.setCourse("M.tech");
		cer1.setDuration("2 Years");
		stu1.setCerti(cer1);

//      session.getTransaction().commit();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(stu);
		session.save(stu1);

		tx.commit();
		factory.close();
		session.close();
	}
}
