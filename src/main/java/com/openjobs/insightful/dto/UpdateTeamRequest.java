package com.openjobs.insightful.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTeamRequest {

    private List<String> employees;
    private List<String> projects;
    private String description;
    private Boolean ignoreProductive;
    private Boolean ignoreNeutral;
    private Boolean ignoreUnproductive;
    private Boolean ignoreUnreviewed;
}