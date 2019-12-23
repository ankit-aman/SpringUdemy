package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			Student student=new Student("Ashish", "Aman", "ash@abc.com");
			session.beginTransaction();
			System.out.println(student);
			int id=(int) session.save(student);
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student student2=session.get(Student.class, id);
			System.out.println("Getting value" + student2);
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
