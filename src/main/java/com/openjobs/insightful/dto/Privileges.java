package com.openjobs.insightful.dto;

import com.openjobs.insightful.dto.enums.PrivilegeLevel;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Privileges {
    private PrivilegeLevel apps;
    private PrivilegeLevel productivity;
    private PrivilegeLevel screenshots;
    private PrivilegeLevel pm;
    private PrivilegeLevel offline;
    private PrivilegeLevel manualTime;
    private PrivilegeLevel manualTimeCreate;
    private PrivilegeLevel shiftScheduling;
}