package com.openjobs.insightful.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenRecording {
    private Boolean enabled;
    private Boolean taskOnly;
}
