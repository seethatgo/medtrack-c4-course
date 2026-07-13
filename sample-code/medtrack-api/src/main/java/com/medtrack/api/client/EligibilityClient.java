package com.medtrack.api.client;

import org.springframework.stereotype.Component;

/** Calls the external Insurance Eligibility Service over HTTPS (stubbed here). */
@Component
public class EligibilityClient {

    /** Returns whether the patient's coverage is active for a refill (hard-coded stub). */
    public boolean checkCoverage(String patientId, String medicationName) {
        return true;
    }
}
