package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmpDTO;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.model.EmpModel;
import com.example.demo.repository.EmpRepo;


@Service
public class EmpServiceImp implements EmpSer{
	
	@Autowired
	private EmpRepo emprepo;

	@Override
	public EmpDTO createEmployee(EmpDTO empdto) {
		
		EmpModel empmodel = EmpMapper.maptoEmpModel(empdto);
		EmpModel createEmployee = emprepo.save(empmodel);
		return EmpMapper.maptoEmpDTO(createEmployee);
	}

	@Override
	public EmpDTO getEmployeeById(Long empId) {
		EmpModel empmodel = emprepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFound("Employee is not Exist with given Id : "+empId));
		return EmpMapper.maptoEmpDTO(empmodel);
	}

	@Override
	public List<EmpDTO> getAllEmployees() {
		List<EmpModel> empmodel = emprepo.findAll();
		return empmodel.stream().map((employee) -> EmpMapper.maptoEmpDTO(employee)).collect(Collectors.toList());
	}

	@Override
	public EmpDTO updateEmp(Long empId, EmpDTO updateEmp) {
		EmpModel empmodel = emprepo.findById(empId).orElseThrow(() -> new ResourceNotFound("Employee not exsist with the given id : "+empId));
		empmodel.setFirstname(updateEmp.getFirstname());
		empmodel.setLastname(updateEmp.getLastname());
		empmodel.setEmail(updateEmp.getEmail());
		System.out.println(updateEmp);
		EmpModel updateEmployee = emprepo.save(empmodel);
		return EmpMapper.maptoEmpDTO(updateEmployee);
	}

	@Override
	public void deleteEmp(Long empId) {
		EmpModel empmodel = emprepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFound("Employee not exsist with the given id : "+empId));
		emprepo.deleteById(empId);
	}
	
}
