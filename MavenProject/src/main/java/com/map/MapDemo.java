package com.map;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
//		creating question
		Question que = new Question();
		que.setQuestionId(101);
		que.setQuestion("What is Java ?");
		
//		creating answer
		Answer ans = new Answer();
		ans.setAnswerId(201);
		ans.setAnswer("Java is a programming language.");
		ans.setQuestion(que);
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(211);
		ans1.setAnswer("Java is a good.");
		ans1.setQuestion(que);
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(221);
		ans2.setAnswer("Using java we can create a website.");
		ans2.setQuestion(que);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		que.setAnswers(list);
		
////		creating question
//		Question que2 = new Question();
//		que2.setQuestionId(102);
//		que2.setQuestion("What is Collection ?");
		
//		creating answer
//		Answer ans2 = new Answer();
//		ans2.setAnswerId(202);
//		ans2.setAnswer("Data Structure of java. ");
//		ans2.setQuestion(que2);
//		que2.setAnswers(ans2);
		
		
		Session session = factory.openSession();
//      session.getTransaction().commit();
		Transaction tx = session.beginTransaction();
		
//		
		
//		session.get(Question.class, 101);
//		session.save(que);
//		session.save(ans);
//		session.save(ans1);
//		session.save(ans2);
//		session.save(que);
//		session.save(ans2);
//		
//		
		
		
		Question q1 = (Question)session.get(Question.class, 101);
//		
		System.out.println(q1.getQuestionId());
		System.out.println(q1.getQuestion());
		
//		System.out.println(q1.getAnswers().size());
		
		
		for(Answer a:q1.getAnswers()) {
			System.out.println(a.getAnswer());
		}

		
		
		
		tx.commit();
		
		
//		Question q1 = session.get(Question.class, 102);
//		System.out.println(q1.getQuestion()+"\n"+q1.getAnswers().getAnswer());
		session.close();
		
	}
	
}
