package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmpDTO;



@Service
public interface EmpSer {
	public EmpDTO createEmployee (EmpDTO empdto);
	
	public EmpDTO getEmployeeById(Long empId);
	
	public List<EmpDTO> getAllEmployees();
	
	public EmpDTO updateEmp(Long empId,EmpDTO updateemp);
	
	public void deleteEmp(Long empId);
}
