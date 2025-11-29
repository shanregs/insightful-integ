package com.jmi.jobseekerapi.core;

import com.jmi.jobseekerapi.core.enums.BreakTimeType;
import com.jmi.jobseekerapi.core.enums.SettingsMode;
import com.jmi.jobseekerapi.core.enums.SettingsType;
import com.jmi.jobseekerapi.dto.request.SharedSettingsRequest;
import org.springframework.stereotype.Component;

@Component
public class SharedSettingsFactory {
    // ---------------------------------------------------------------------
    // PRIVILEGES BUILDER
    // ---------------------------------------------------------------------
    public Privileges buildDefaultPrivileges() {
        return Privileges.builder()
                .apps(true)
                .productivity(false)
                .pm(false)
                .screenshots(false)
                .offline(false)
                .manualTime(false)
                .build();
    }

    // ---------------------------------------------------------------------
    // BREAK TIME BUILDER
    // ---------------------------------------------------------------------
    public BreakTime buildDisabledBreakTime() {
        return BreakTime.builder()
                .type(BreakTimeType.DISABLED)
                .build();
    }

    // ---------------------------------------------------------------------
    // DAYS BUILDER
    // ---------------------------------------------------------------------
    public WeekDays buildDefaultWorkDays() {
        return WeekDays.builder()
                .monday(true)
                .tuesday(true)
                .wednesday(true)
                .thursday(true)
                .friday(true)
                .saturday(false)
                .sunday(false)
                .build();
    }

    public WeekDays buildWorkDays(boolean monday, boolean tuesday, boolean wednesday,
                                         boolean thursday, boolean friday,
                                         boolean saturday, boolean sunday) {
        return WeekDays.builder()
                .monday(monday)
                .tuesday(tuesday)
                .wednesday(wednesday)
                .thursday(thursday)
                .friday(friday)
                .saturday(saturday)
                .sunday(sunday)
                .build();
    }

    // ---------------------------------------------------------------------
    // SETTINGS BUILDER
    // ---------------------------------------------------------------------
    public SharedSettings buildPersonalUnlimitedSharedSettings() {
        return SharedSettings.builder()
                .type("unlimited")
                .icon(true)
                .timer(true)
                .clocker(true)
                .start(2)
                .idle(1)
                .breaks(0)
                .screenshots(1)
                .breakTime(buildDisabledBreakTime())
                .days(buildDefaultWorkDays())
                .privileges(buildDefaultPrivileges())
                .build();
    }

    // ---------------------------------------------------------------------
    // FINAL WRAPPER: SHARED SharedSettings REQUEST BUILDER
    // ---------------------------------------------------------------------
    public SharedSettingsRequest buildPersonalSharedSettings(String name) {
        return SharedSettingsRequest.builder()
                .name(name)
                .type("personal")
                .settings(buildPersonalUnlimitedSharedSettings())
                .build();
    }
}
