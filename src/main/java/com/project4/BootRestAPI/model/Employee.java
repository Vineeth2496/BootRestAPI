package com.project4.BootRestAPI.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Component
@Entity
@Table(name = "Employee_table")
public class Employee {
	@Id
	@Column(name = "emp_id")
	private Long EId;
	@Column(name = "emp_name")
	private String EName;
	@Column(name = "emp_email")
	private String EEmail;
	@Column(name = "emp_phnoneno")
	private Long EPhoneNo;
	@Column(name = "emp_salary")
	private Double ESalary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long eId, String eName, String eEmail, Long ePhoneNo, Double eSalary) {
		super();
		EId = eId;
		EName = eName;
		EEmail = eEmail;
		EPhoneNo = ePhoneNo;
		ESalary = eSalary;
	}
	public Long getEId() {
		return EId;
	}
	public void setEId(Long eId) {
		EId = eId;
	}
	public String getEName() {
		return EName;
	}
	public void setEName(String eName) {
		EName = eName;
	}
	public String getEEmail() {
		return EEmail;
	}
	public void setEEmail(String eEmail) {
		EEmail = eEmail;
	}
	public Long getEPhoneNo() {
		return EPhoneNo;
	}
	public void setEPhoneNo(Long ePhoneNo) {
		EPhoneNo = ePhoneNo;
	}
	public Double getESalary() {
		return ESalary;
	}
	public void setESalary(Double eSalary) {
		ESalary = eSalary;
	}
	@Override
	public String toString() {
		return "Employee [EId=" + EId + ", EName=" + EName + ", EEmail=" + EEmail + ", EPhoneNo=" + EPhoneNo
				+ ", ESalary=" + ESalary + "]";
	}
	
	
	
	
	
	
}
