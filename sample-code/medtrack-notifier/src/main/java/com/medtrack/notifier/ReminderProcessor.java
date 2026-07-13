package com.medtrack.notifier;

/** Builds the reminder text for a patient and asks the sender to deliver it. */
public class ReminderProcessor {

    private final SmsSender smsSender;

    public ReminderProcessor(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void process(String patientId) {
        String message = "Reminder: you have an upcoming appointment.";
        smsSender.send(patientId, message);
    }
}
