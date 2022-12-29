package com.sessionfactorylevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Std_Main {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// session Object-1
		Session session = sessionFactory.openSession();
		// student Object-1
		Student s1 = (Student) session.load(Student.class, 10);

		System.out.println("Student Data is >");
		System.out.println("Name >> " + s1.getName());
		System.out.println("City >> " + s1.getCity());
		System.out.println("Mobile >> " + s1.getMobile());

		System.out.println("Second Level Cache................");
		// session Object-2
		Session session1 = sessionFactory.openSession();
		// student Object-2
		Student s2 = (Student) session1.load(Student.class, 10);

		System.out.println("Student Data is >");
		System.out.println("Name >> " + s2.getName());
		System.out.println("City >> " + s2.getCity());
		System.out.println("Mobile >> " + s2.getMobile());
	}

}
