package com.medtrack.api.client;

import org.springframework.stereotype.Component;

/** Submits approved refills to the external Pharmacy Network over HTTPS (stubbed here). */
@Component
public class PharmacyClient {

    /** Submits an approved refill and returns a pharmacy tracking id (hard-coded stub). */
    public String submitRefill(String patientId, String medicationName) {
        return "PHARMACY-REF-1001";
    }
}
