package com.medtrack.api.client;

import org.springframework.stereotype.Component;

/** Talks to the external EHR System over HL7 FHIR R4 over HTTPS (stubbed here). */
@Component
public class EhrClient {

    /** Returns the patient's record of appointments from the EHR (hard-coded stub). */
    public String fetchPatientRecord(String patientId) {
        return "EHR record for patient " + patientId;
    }
}
