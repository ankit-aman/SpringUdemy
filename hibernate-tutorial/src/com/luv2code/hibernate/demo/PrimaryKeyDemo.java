package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			Student student=new Student("ohn", "Doe", "test5@abc.com");
			Student student1=new Student("Hello", "world", "test2@abc.com");
			Student student2	=new Student("primary", "test", "test3@abc.com");
			session.beginTransaction();
			session.save(student);
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			factory.close();
		}
	}

}
