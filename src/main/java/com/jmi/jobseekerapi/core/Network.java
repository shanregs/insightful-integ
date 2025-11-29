package com.jmi.jobseekerapi.core;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Network {
    @NotNull
    private String name;        // required
    @NotNull
    private String macAddress;  // required
}
