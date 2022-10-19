package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		List<Emp> emps = new ArrayList<Emp>();
		List<Project> projects = new ArrayList<Project>();
		
//		Creating Employees
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(21);
		e2.setEid(22);
		
		e1.setEname("Sudhanshu");
		e2.setEname("Mahak");

//		Creating Project
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(11);
		p2.setPid(12);
		
		p1.setProjectName("Food Order");
		p2.setProjectName("Chat Bot");

		emps.add(e1);
		emps.add(e2);
		
		projects.add(p1);
		projects.add(p2);
		
		e1.setProjects(projects);
		p2.setEmps(emps);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
