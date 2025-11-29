package com.jmi.jobseekerapi.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {

    @Size(min = 1, message = "Name cannot be empty")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 1, message = "Title cannot be empty")
    private String title;

    private String teamId;

    private String sharedSettingsId;

    /**
     * List of project IDs the employee should belong to.
     */
    private List<String> projects;
}