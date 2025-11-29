package com.jmi.jobseekerapi.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeOnboardRequest {

    private EmployeeInfo employee;
    private TeamInfo team;
    private SharedSettingInfo sharedSetting;
//    private ProjectInfo project;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ProjectInfo {
        private Boolean createNewProject;
        private CreateProjectRequest createProjectRequest;
        private String projectId;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class EmployeeInfo {
        private String name;
        private String email;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SharedSettingInfo {
        private Boolean createNewSharedSettings;
        private SharedSettingsRequest sharedSettingsRequest;
        private String sharedSettingsId;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TeamInfo {
        private Boolean createNewTeam;
        private CreateTeamRequest teamRequest;
        private String teamId;
    }
}
