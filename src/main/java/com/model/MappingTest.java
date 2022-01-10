package com.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {
	public static void main(String[] args) {
		
		//oneToOne();
		//oneTomany();
		manyTomany();
		
		
	}
	
	
	
	
	//one-to-one mapping
	
	static void oneToOne() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Ktm");
		adr.setState("Bagmati");
		
		sess.save(adr);
		
		Employee emp = new Employee();
		emp.setName("Nabin Gautam");
		emp.setSalary(700000);
		emp.setAddress(adr);
		
		sess.save(emp);
		sess.getTransaction().commit();
		sess.close();
		
		
	}
	
	
	//onetomany
	
		static void oneTomany () {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			Address adr = new Address();
			adr.setCountry("Nepal");
			adr.setCity("Ktm");
			adr.setState("Bagmati");
			
			sess.save(adr);
			
			Employee emp = new Employee();
			emp.setName("Nabin Gautam");
			emp.setSalary(700000);
			emp.setAddress(adr);
			
			Phone p1 = new Phone();
			p1.setNumber("9861314243");
			p1.setType("NCELL");
			p1.setEmployee(emp);
			sess.save(p1);
			
			Phone p2 = new Phone();
			p2.setNumber("9843470125");
			p2.setType(("NTC"));
			p2.setEmployee(emp);
			sess.save(p2);
			
			
			
			emp.setPhoneList(Arrays.asList(p1,p2));
			sess.save(emp);
			sess.getTransaction().commit();
			sess.close();
			
			
		}
		
		///many to many
		
		static void manyTomany() {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			Address adr = new Address();
			adr.setCountry("Nepal");
			adr.setCity("Ktm");
			adr.setState("Bagmati");
			
			sess.save(adr);
			
			Employee emp = new Employee();
			emp.setName("Nabin Gautam");
			emp.setSalary(700000);
			emp.setAddress(adr);
			
			Phone p1 = new Phone();
			p1.setNumber("9861314243");
			p1.setType("NCELL");
			p1.setEmployee(emp);
			sess.save(p1);
			
			Phone p2 = new Phone();
			p2.setNumber("9843470125");
			p2.setType(("NTC"));
			p2.setEmployee(emp);
			sess.save(p2);
			
			Department d1 = new Department();
			d1.setDeptName("IT");
			sess.save(d1);
			
			Department d2 = new Department();
			d2.setDeptName("Admin");
			sess.save(d2);
			
		
			emp.setDeptList(Arrays.asList(d1,d2));
			emp.setPhoneList(Arrays.asList(p1,p2));
			sess.save(emp);
			sess.getTransaction().commit();
			sess.close();
			
		}

}
