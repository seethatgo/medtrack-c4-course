package com.medtrack.api.model;

/** Inbound payload for requesting a prescription refill. */
public class RefillRequestDto {

    private String patientId;
    private String medicationName;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }
}
