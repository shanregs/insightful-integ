package com.jmi.jobseekerapi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response for DELETE operation
 * Can also reuse TeamResponse instead of creating a separate class
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTeamResponse {

    private String id;
    private String name;

    @JsonProperty("default")
    private Boolean defaultTeam;

    private String description;
    private String organizationId;
    private List<String> managers;
    private List<String> employees;
    private List<String> projects;
    private Boolean ignoreProductive;
    private Boolean ignoreNeutral;
    private Boolean ignoreUnproductive;
    private Boolean ignoreUnreviewed;
    private Long createdAt;
    private Long updatedAt;
    private String modelName;
}
