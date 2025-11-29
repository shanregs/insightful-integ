package com.jmi.jobseekerapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InviteEmployeeRequest {

    private String name;
    private String email;
    private String teamId;
    private String sharedSettingsId;
}