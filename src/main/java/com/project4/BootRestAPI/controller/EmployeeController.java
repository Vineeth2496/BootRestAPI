package com.project4.BootRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project4.BootRestAPI.model.Employee;
import com.project4.BootRestAPI.service.EmployeeService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService eserv;

	public EmployeeController(EmployeeService eserv) {
		super();
		this.eserv = eserv;
	}
	//build create Empolyee Rest API
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(eserv.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllEmployees(){
		return eserv.getAllEmployee();
	}
	@GetMapping("get/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long eid){
		return new ResponseEntity<Employee>(eserv.getEmployeeById(eid), HttpStatus.OK);
	}
	
	@PutMapping("update/{eid}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long eid, @RequestBody Employee emp){
		return new ResponseEntity<Employee>(eserv.updateEmployee(emp, eid), HttpStatus.OK);
	}
	
		
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		//delete employee by id
		eserv.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted sucessfully!. ",HttpStatus.OK);
	}
}






