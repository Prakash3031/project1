package com.cg.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="EmpTable")
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private int empSal;
	
	@Autowired
	@OneToOne
	private Account account;
	

	public Employee() {
		super();
	}


	public Employee(int empId, String empName, int empSal, Account account) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.account = account;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getEmpSal() {
		return empSal;
	}


	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", account=" + account
				+ "]";
	}

	
}
