package com.darunkar.hrms_backend.mapper;

import com.darunkar.hrms_backend.dto.EmployeeRequest;
import com.darunkar.hrms_backend.dto.EmployeeResponse;
import com.darunkar.hrms_backend.entity.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	EmployeeEntity toEntity(EmployeeRequest employeeRequest);
	EmployeeResponse toResponseDto(EmployeeEntity entity);
	List<EmployeeResponse> toResponseDto(List<EmployeeEntity> entity);
}
