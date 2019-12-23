package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

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
			int id=10;
			Course course=session.get(Course.class, id);
			session.remove(course);
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
