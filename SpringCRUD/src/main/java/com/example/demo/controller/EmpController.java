package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDTO;
import com.example.demo.service.EmpSer;

@RestController
@RequestMapping("/api/employee")
public class EmpController {
	
	@Autowired
	private EmpSer empservice;
	
	@PostMapping("/save")
	public ResponseEntity<EmpDTO> createEmployee(@RequestBody EmpDTO empdto){
		EmpDTO savedEmp = empservice.createEmployee(empdto);
		return new ResponseEntity<EmpDTO>(savedEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("/get{id}")
	public ResponseEntity<EmpDTO> getEmployeeById(@PathVariable("id") Long empId){
		EmpDTO empdto = empservice.getEmployeeById(empId);
		return new ResponseEntity<EmpDTO>(empdto, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<EmpDTO>> getAllEmployees(){
		List<EmpDTO> employees = empservice.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@PutMapping("/update{id}")
	public ResponseEntity<EmpDTO> updateEmployee(@PathVariable("id") Long empId , @RequestBody EmpDTO updateEmpdto){
		EmpDTO empdto = empservice.updateEmp(empId, updateEmpdto);
		return new ResponseEntity<EmpDTO>(empdto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Long empId){
		empservice.deleteEmp(empId);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}
}
