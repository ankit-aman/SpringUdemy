package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			//InstructorDetail instructorDetail=new InstructorDetail("actey/Youtube", "fight");
			
			Course course=new Course("Martial Arts");
			
			Course course2=new Course("Boxing");
			instructor.add(course);
			instructor.add(course2);
			
			
			session.save(course);
			session.save(course2);
		
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
