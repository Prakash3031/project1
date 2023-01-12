package com.cg.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.dao.EmployeeRepo;
import com.cg.rest.entity.Employee;
import com.cg.rest.exception.NoSuchEmployeeFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return  empRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) throws NoSuchEmployeeFoundException {
		Optional<Employee> emp_list =empRepo.findById(id);
		if(emp_list.isPresent())
			return emp_list.get();
		else throw new NoSuchEmployeeFoundException();
	}

	@Override
	public Employee modifyEmployee(Employee emp, int id) throws NoSuchEmployeeFoundException {
		Employee findEmp = findEmployeeById(id);
		findEmp.setEmpName(emp.getEmpName());
		return null;
	}

	@Override
	public boolean removeEmployee(int id) throws NoSuchEmployeeFoundException {
		empRepo.deleteById(id);
		Optional<Employee> emp=empRepo.findById(id);
		if(emp.isPresent()) {
		return false;}
		else return true;
	}

	@Override
	public List<Employee> findEmpByAccount(int account) {
		
		return empRepo.findById(account);
	}

	

}
