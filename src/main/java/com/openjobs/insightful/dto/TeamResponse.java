package com.openjobs.insightful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response for GET, POST, and PUT operations for Team
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {

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
