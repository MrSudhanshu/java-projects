package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");

//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

//         creating object of students class

		Student st = new Student();
		st.setCity("Pilibhit1");
		st.setId(3);
		st.setName("Sudhanshusudh");

//        creating object of address class

		Address add = new Address();
		add.setAddedDate(new Date());
		add.setCity("Pilibhit");
		add.setOpen(true);
		add.setStreet("Tanakpur Road");
		add.setX(6464.5554);
//        reading image
		FileInputStream fis = new FileInputStream("src/main/java/ok.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		add.setImage(data);
		fis.close();

		Session session = factory.openSession();
//        session.getTransaction().commit();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(add);
		tx.commit();
		session.close();
	}
}
