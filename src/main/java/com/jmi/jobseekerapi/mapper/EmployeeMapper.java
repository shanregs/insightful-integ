package com.jmi.jobseekerapi.mapper;

import com.jmi.jobseekerapi.dto.response.EmployeeResponse;
import com.jmi.jobseekerapi.dto.request.InviteEmployeeRequest;
import com.jmi.jobseekerapi.core.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toModel(EmployeeResponse response);

    EmployeeResponse toResponse(Employee model);

    Employee toModel(InviteEmployeeRequest request);
}