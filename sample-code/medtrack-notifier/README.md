# medtrack-notifier

This code exists to be diagrammed.

A tiny plain-Java (no Spring) queue consumer that sends SMS appointment
reminders. It does not need to run; it compiles and reads clearly.

## Flow

```
QueueListener  -> ReminderProcessor -> SmsSender
(reads queue)     (builds message)     (delivers text)
```

## Build

```
mvn -q compile
```
