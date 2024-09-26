package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

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
			session.beginTransaction();
			int id=1;
			Instructor instructor=session.get(Instructor.class, id);
			
			System.out.println(instructor);
			System.out.println("Love to code"+instructor.getInstructorDetail());
			
			
			System.out.println("Love to code"+instructor.getCourses());
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
