package com.jmi.jobseekerapi.service;

import com.jmi.jobseekerapi.dto.request.EmployeeOnboardRequest;
import com.jmi.jobseekerapi.dto.request.InviteEmployeeRequest;
import com.jmi.jobseekerapi.dto.response.EmployeeResponse;
import com.jmi.jobseekerapi.dto.response.SharedSettingsResponse;
import com.jmi.jobseekerapi.dto.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeOnboardingService {

    private final EmployeeService employeeService;
    private final TeamService teamService;
    private final SharedSettingsService sharedSettingsService;


    public EmployeeResponse onboardEmployee(EmployeeOnboardRequest request) {
        // 1 - create or use Shared Settings
        SharedSettingsResponse sharedSettingsResponse = null;
        EmployeeResponse employeeResponse = null;
        EmployeeOnboardRequest.SharedSettingInfo sharedSetting = request.getSharedSetting();
        String sharedSettingId = null;
        if (sharedSetting != null && sharedSetting.getCreateNewSharedSettings()) {
            if (sharedSetting.getSharedSettingsRequest() != null) {
                sharedSettingsResponse = sharedSettingsService.createSetting(sharedSetting.getSharedSettingsRequest());
            } else {
                log.error("Null sharedSetting.getSharedSettingsRequest");
                return null;
            }
            if (sharedSettingsResponse != null) {
                sharedSettingId = sharedSettingsResponse.getId();
                if (sharedSettingId == null) {
                    log.error("Shared Setting ID is null, cannot proceed with onboarding");
                    return null;
                }
            }
        } else {
            sharedSettingId = sharedSetting.getSharedSettingsId();
            if (sharedSettingId == null) {
                log.error("Shared Setting ID is null, cannot proceed with onboarding");
                return null;
            }
        }

        //2 - create or use Team
        String teamId = null;
        TeamResponse teamResponse = null;
        EmployeeOnboardRequest.TeamInfo teamInfo = request.getTeam();
        if (teamInfo != null) {
            if (teamInfo.getCreateNewTeam() != null && teamInfo.getCreateNewTeam()) {
                if (teamInfo.getTeamRequest() != null) {
                    teamResponse = teamService.createTeam(teamInfo.getTeamRequest());
                    if (teamResponse == null || teamResponse.getId() == null) {
                        log.error("Failed to create new team, cannot proceed with onboarding");
                        return null;
                    } else {
                        teamId = teamResponse.getId();
                    }
                } else {
                    log.error("Null teamInfo.getTeamRequest");
                    return null;
                }
            } else {
                teamId = teamInfo.getTeamId();
                if (teamId == null) {
                    log.error("Team ID is null, cannot proceed with onboarding");
                    return null;
                }
            }
        }

        // 3 - create Employee
        EmployeeOnboardRequest.EmployeeInfo employeeInfo = request.getEmployee();
        if (employeeInfo != null) {
            InviteEmployeeRequest employeeRequest = new InviteEmployeeRequest();
            employeeRequest.setName(employeeInfo.getName());

            employeeRequest.setEmail(employeeInfo.getEmail());

            employeeRequest.setTeamId(teamId);
            employeeRequest.setSharedSettingsId(sharedSettingId);

            employeeResponse = employeeService.inviteEmployee(employeeRequest);
            if(employeeResponse == null) {
                log.error("Failed to create employee during onboarding");
                return null;
            }
            log.info(" {} ", employeeResponse);
        } else {
            log.error("Null employeeInfo in onboarding request");
            return null;
        }
        return employeeResponse;
    }

   /* private SharedSettingsResponse createNewSharedSettings(EmployeeOnboardRequest.SharedSettingInfo sharedSetting) {
        if(sharedSetting.getSharedSettingsRequest() != null) {
            return sharedSettingsService.createSetting(sharedSetting.getSharedSettingsRequest());
        } else {
            log.error("Null sharedSetting.getSharedSettingsRequest");
            return null;
        }
    }*/


}

