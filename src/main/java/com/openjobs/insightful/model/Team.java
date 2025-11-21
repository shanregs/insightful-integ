package com.openjobs.insightful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    private String id;
    private boolean ignoreProductive;
    private boolean ignoreNeutral;
    private boolean ignoreUnproductive;
    private boolean ignoreUnreviewed;
    private String name;
    private String description;
    private String organizationId;
    private boolean isDefault;  // Renamed for Java boolean naming convention
    private List<String> employees;
    private List<String> projects;
    private Long createdAt; // Time in milliseconds
}
