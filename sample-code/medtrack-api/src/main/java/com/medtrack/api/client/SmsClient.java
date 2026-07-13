package com.medtrack.api.client;

import org.springframework.stereotype.Component;

/** Sends text messages via the external SMS Provider over HTTPS (stubbed here). */
@Component
public class SmsClient {

    /** Sends an SMS and returns whether it was accepted for delivery (hard-coded stub). */
    public boolean sendSms(String patientId, String message) {
        return true;
    }
}
