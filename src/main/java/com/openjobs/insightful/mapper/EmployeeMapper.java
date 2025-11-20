package com.openjobs.insightful.mapper;

import com.openjobs.insightful.dto.EmployeeResponse;
import com.openjobs.insightful.dto.InviteEmployeeRequest;
import com.openjobs.insightful.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // Map Response -> Domain model
    Employee toModel(EmployeeResponse response);

    // Map Domain -> Response
    EmployeeResponse toResponse(Employee model);

    // If you want to map request -> domain for local creation (optional):
    Employee toModel(InviteEmployeeRequest request);
}