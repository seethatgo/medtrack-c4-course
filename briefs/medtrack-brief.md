# MedTrack — System Brief

MedTrack is a patient appointment and prescription-refill platform for a regional
clinic network. It is fictional. Argue about it freely.

## What it does
- Patients book, reschedule, and cancel appointments.
- Patients request prescription refills and get status updates.
- Clinic staff manage provider schedules and approve or deny refill requests.

## Who uses it
- **Patients** — mobile-first users; book appointments and request refills.
- **Clinic Staff** — front desk and clinical staff; manage schedules, work the
  refill queue.

## What it must integrate with
- **EHR System** — the clinic's electronic health record; source of truth for
  patient records and appointments of record. Integration is HL7 FHIR over HTTPS.
- **Pharmacy Network** — receives approved refill requests and reports fill status.
- **SMS Provider** — sends appointment reminders and refill status texts.
- **Insurance Eligibility Service** — real-time coverage checks before a refill
  is submitted.

## Ground rules
- You choose the internal architecture. There is no single right answer.
- Every diagram follows the review checklist in /cheatsheets/review-checklist.md.
- Decisions you make here become your ADRs on Day 3. Notice yourself making them.
