package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class TestORM {

	public static void main(String[] args) {
		
		//addStudent();
		//update();
		//delete();
		//getAll();
		testHql();
		
	}
	
	
	
	static void addStudent() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		
		Student s = new Student(0, "Rama", "Dhami", "IHIT", 10, "Pokhara");
		
		sess.save(s); // insert sql
		sess.getTransaction().commit();
		sess.close();
		
		
		
	}
	
	static void getAll() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		
		Criteria crt = sess.createCriteria(Student.class);
			crt.add(Restrictions.eq("college", "NCC"));
			crt.add(Restrictions.eq("city", "Jhapa"));
		List<Student>  slist = crt.list(); //select sql
		
		for (Student st : slist) {
			System.out.println(st);
		}
	
	}
		
	static void update() {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			Student s = (Student) sess.get(Student.class, 1);
			s.setCity("Delhi");
			s.setCollege("NECC");
			
			sess.update(s);//update sql
			sess.getTransaction().commit();
			sess.close();
			
			
		}
	static void delete() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		Student s = (Student) sess.get(Student.class, 1);
		
		
		sess.delete(s);//update sql
		sess.getTransaction().commit();
		sess.close();
		
		
	}
	
	
	static void testHql () {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		
		Query query = sess.createQuery("FROM Student where city = 'Jhapa'");
		List <Student> slist = query.list();
		slist.forEach(s-> System.out.println(s));
		
		
		
		
		
	}
		
	
		
		
	}


