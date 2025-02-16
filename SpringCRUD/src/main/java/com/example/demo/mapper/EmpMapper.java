package com.example.demo.mapper;

import com.example.demo.dto.EmpDTO;
import com.example.demo.model.EmpModel;

public class EmpMapper {
	
	public static EmpDTO maptoEmpDTO(EmpModel empmodel) {
		return new EmpDTO(
				empmodel.getId(),
				empmodel.getFirstname(),
				empmodel.getLastname(),
				empmodel.getEmail(),
				empmodel.getAddress()
				);
	}
	
	public static EmpModel maptoEmpModel(EmpDTO empdto) {
		return new EmpModel(
				empdto.getId(),
				empdto.getFirstname(),
				empdto.getLastname(),
				empdto.getEmail(),
				empdto.getAddress()
				);
	}
}
