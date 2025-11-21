package com.openjobs.insightful.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ScreenAndSystemAudioRecording {
    AUTHORIZED, DENIED, UNDETERMINED;

    @JsonCreator
    public static ScreenAndSystemAudioRecording from(String v) {
        if (v == null) return null;
        return ScreenAndSystemAudioRecording.valueOf(v.trim().toUpperCase());
    }
}
