package com.medtrack.api.service;

import com.medtrack.api.client.SmsClient;
import org.springframework.stereotype.Service;

/** Sends patient-facing notifications by delegating to the SMS client. */
@Service
public class NotificationService {

    private final SmsClient smsClient;

    public NotificationService(SmsClient smsClient) {
        this.smsClient = smsClient;
    }

    public void notifyRefillStatus(String patientId, String status) {
        smsClient.sendSms(patientId, "Your refill is now: " + status);
    }
}
