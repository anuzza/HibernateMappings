package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="student")

public class Student {
	@Id //pk
	@GeneratedValue //auto increment
	@Column 
	private int id;
	@Column (name = "firstName")
	private String fname;
	@Column
	private String lname;
	@Column
	private String college;
	@Column
	private int rollno;
	@Column
	private String city;
	
	
	
	
	public Student () {
		
	}
	
	
	
	Student(int id, String fname, String lname, String college, int rollno, String city) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.college = college;
		this.rollno = rollno;
		this.city = city;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", college=" + college + ", rollno="
				+ rollno + ", city=" + city + "]";
	}
	
	
	
	
}
