package com.project4.BootRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project4.BootRestAPI.model.Employee;
@Component
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
