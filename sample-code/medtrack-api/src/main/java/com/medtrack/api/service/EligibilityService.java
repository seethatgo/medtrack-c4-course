package com.medtrack.api.service;

import com.medtrack.api.client.EligibilityClient;
import org.springframework.stereotype.Service;

/** Decides whether a patient is covered for a refill, using the eligibility client. */
@Service
public class EligibilityService {

    private final EligibilityClient eligibilityClient;

    public EligibilityService(EligibilityClient eligibilityClient) {
        this.eligibilityClient = eligibilityClient;
    }

    public boolean isCovered(String patientId, String medicationName) {
        return eligibilityClient.checkCoverage(patientId, medicationName);
    }
}
