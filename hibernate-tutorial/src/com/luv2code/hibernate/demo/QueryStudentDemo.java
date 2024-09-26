package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> list=session.createQuery("from Student s").getResultList();
			displayStudents(list);
			
			List<Student> list2=session.createQuery("from Student s where s.lastName='Aman'").getResultList();
			displayStudents(list2);
			
			
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

	private static void displayStudents(List<Student> list) {
		for (Student student: list) {
			System.out.println(student);
			
		}
	}

}
