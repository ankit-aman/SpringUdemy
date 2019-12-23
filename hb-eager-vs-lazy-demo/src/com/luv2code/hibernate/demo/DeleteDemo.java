package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {

	
			session.beginTransaction();
			int id=4;
			
			InstructorDetail instructor=session.get(InstructorDetail.class, id);
			
			System.out.println(instructor);
			System.out.println(instructor.getInstructor());
			/*
			 * if(instructor!=null) { System.out.println("Deleteing");
			 * session.delete(instructor); }
			 */
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
	
	
	}

}
