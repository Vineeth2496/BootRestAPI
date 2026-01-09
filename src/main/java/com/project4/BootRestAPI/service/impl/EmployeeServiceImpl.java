package com.project4.BootRestAPI.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project4.BootRestAPI.exception.ResourceNotFoundException;
import com.project4.BootRestAPI.model.Employee;
import com.project4.BootRestAPI.repository.EmployeeRepository;
import com.project4.BootRestAPI.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository erepo;
	
	public EmployeeServiceImpl(EmployeeRepository erepo) {
		super();
		this.erepo = erepo;
	}
	
	@Override
	public Employee saveEmployee(Employee emp) {
		return erepo.save(emp);
	}
	
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> li=erepo.findAll();
		return li;
	}

	@Override
	public Employee getEmployeeById(Long id) {
				
//		Optional<Employee> oemp=erepo.findById(id);
//		if(oemp.isPresent()) {
//			return oemp.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}
		
		return erepo.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
	}

	@Override
	public Employee updateEmployee(Employee emp, Long id) {
		
		Employee empExist=erepo.findById(id).
			orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
		empExist.setEName(emp.getEName());
		empExist.setEEmail(emp.getEEmail());
		empExist.setEPhoneNo(emp.getEPhoneNo());
		empExist.setESalary(emp.getESalary());
		
		return erepo.save(empExist);
	}

	@Override
	public void deleteEmployee(Long id) {
		erepo.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
		erepo.deleteById(id);
	}

}




