package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForAshDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {

			
			session.beginTransaction();
			int id=2;
			Student student=session.get(Student.class, id);

			Course course=new Course("COD2");
			Course course2=new Course("FreeFire");
			course.addStudents(student);
			course2.addStudents(student);
			session.save(course2);
			session.save(course);
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
