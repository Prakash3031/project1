package com.cg.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.entity.Employee;
import com.cg.rest.service.EmployeeService;

@RestController
public class EmployeeRest {{
	
}
	
   @Autowired
   private EmployeeService eservice;
   
   
   @PostMapping("/addemp")
   public ResponseEntity<Employee> createEmployee(@RequestBody Employee e1){
	   try {
	   Employee emp =eservice.addEmployee(e1); 
	return new ResponseEntity<>(emp, HttpStatus.CREATED);
   } catch (Exception e) {
	   System.out.println("\n"+e.getMessage());
	   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
   }
  }
   
   @GetMapping("/getallemployee")
   public ResponseEntity<Employee> getallemp(@RequestBody Employee e1){
	   try {
		   List<Employee> elist=eservice.findAllEmployee();
		   if(elist.isEmpty()) {
			   return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		   }else {
			   return new ResponseEntity(elist, HttpStatus.OK);
		}
	}
		   catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
   }
   
   @GetMapping(path="/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		try {
			Employee emp = eservice.findEmployeeById(id);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}catch(Exception e){
			System.out.println("\n"+e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

   @PutMapping(path="/modifyEmployee/{id}")
	public ResponseEntity<Employee> modifyEmployeeById(@PathVariable("id") int id, @RequestBody Employee e1){
		try {
			Employee emp = eservice.modifyEmployee(e1, id);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}catch(Exception e){
			System.out.println("\n"+e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
   
   @DeleteMapping(path="/deleteEmp/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable("id") int id){
		try {
			boolean isDel = eservice.removeEmployee(id);
			return new ResponseEntity<>(isDel, HttpStatus.OK);
		}catch(Exception e){
			System.out.println("\n"+e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
