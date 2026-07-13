package com.medtrack.notifier;

/** Pulls reminder messages off the queue and hands each to the processor. */
public class QueueListener {

    private final ReminderProcessor reminderProcessor;

    public QueueListener(ReminderProcessor reminderProcessor) {
        this.reminderProcessor = reminderProcessor;
    }

    public void onMessage(String patientId) {
        reminderProcessor.process(patientId);
    }
}
