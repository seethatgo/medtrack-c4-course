package com.medtrack.api.model;

import java.time.LocalDateTime;

/** Inbound payload for booking an appointment. */
public class AppointmentRequestDto {

    private String patientId;
    private String providerId;
    private LocalDateTime scheduledFor;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public LocalDateTime getScheduledFor() {
        return scheduledFor;
    }

    public void setScheduledFor(LocalDateTime scheduledFor) {
        this.scheduledFor = scheduledFor;
    }
}
