package com.jmi.jobseekerapi.mapper;


import com.jmi.jobseekerapi.dto.request.CreateProjectRequest;
import com.jmi.jobseekerapi.core.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  ProjectMapper {

    Project toModel(CreateProjectRequest dto);

//    Project toModel(CreateProjectResponseDTO dto);
}
