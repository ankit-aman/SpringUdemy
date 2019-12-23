package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {

			//Instructor instructor=new Instructor("ankit", "aman", "anky@abc.com");
		//	InstructorDetail instructorDetail=new InstructorDetail("Techey/Youtube", "coding");
			
			Instructor instructor=new Instructor("Tom", "Hardy", "warr@abc.com");
			InstructorDetail instructorDetail=new InstructorDetail("actey/Youtube", "fight");
			
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			session.save(instructor);
		
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
