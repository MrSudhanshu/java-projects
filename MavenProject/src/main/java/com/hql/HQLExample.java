package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.tut.Student;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

public class HQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		
		
		
		
//		 HQL syntax
//		String query = "from Student where name='rahul'";
//		String query = "from Student as s where s.name=:x and s.city=:c";
//
//		Query q = s.createQuery(query);
//
//		q.setParameter("x", "Sudhanshu");
//		q.setParameter("c", "Delhi");
//		Single result - unique
//		multiple result -list

//		List<Student> lst = q.list();
//		for (Student s1 : lst) {
//			System.out.println(s1.getId());
//		}
//		System.out.println("===============================================================================================");
//		Query q2 = s.createQuery("update Student as s set s.city=:c where s.id=:n");
		
		
//		delete in hibernate
		 
//		Query q2 = s.createQuery("delete from Student as s s.city=:c where s.id=:n");
//		System.out.println(r);
//		q2.setParameter("n", 2);
//		q2.setParameter("c", "Noida");
//		int r = q2.executeUpdate();
		
		
		
		
		// join in hiber_nate
		
//		jo jo data chahiye result me bohi is query me likho jaise isme question h uper bale me neeche bale me ni h

		Query q3 = s.createQuery("select q.question, q.questionId, a.answer from  Question as q inner join q.answers a");
//		Query q3 = s.createQuery("select q.question, a.answer from  Question as q inner join q.answers a");
//		q3.executeUpdate();
		
		List<Object []> lst1 = q3.getResultList();
		
		for(Object[] obj:lst1) {
			System.out.println(Arrays.toString(obj));
		}
		
		
		
		
		
		
		
		
		tx.commit();
		s.close();
		factory.close();
	}

}
