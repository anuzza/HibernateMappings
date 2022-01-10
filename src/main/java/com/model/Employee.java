package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int salary;
	@OneToOne
	@JoinColumn(name = "addressId") //fk
	private Address address;
	
	@OneToMany(mappedBy = "employee")
	private List<Phone> PhoneList;
	
	@ManyToMany
	@JoinTable(name = "empDept", joinColumns = { @JoinColumn (name = "empId")}, inverseJoinColumns = {@JoinColumn(name = "deptId")})
	private List<Department> deptList;
	
	
	
	
	public List<Department> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}
	public List<Phone> getPhoneList() {
		return PhoneList;
	}
	public void setPhoneList(List<Phone> phoneList) {
		PhoneList = phoneList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
