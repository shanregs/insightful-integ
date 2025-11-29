package com.jmi.jobseekerapi.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InviteEmployeeRequest {
    @NotNull
    private String name;
    private String email;
    @NotNull
    private String teamId;
    @NotNull
    private String sharedSettingsId;
}