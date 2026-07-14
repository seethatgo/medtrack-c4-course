# MedTrack — Non-Functional Hints (for Exercise 2)

- ~50,000 registered patients; peak load is Monday 8–10 a.m.
- Mobile-first: most patient traffic comes from the mobile app.
- EHR integration is HL7 FHIR R4 over HTTPS.
- Refill approval involves a human (clinic staff). Design for a request that
  waits hours, not milliseconds.
- SMS delivery is fire-and-forget with retry; the SMS provider has outages.
- Eligibility checks are synchronous and slow (1–3 s). Decide where that
  latency lives.
- Audit: every refill decision must be traceable — who, when, why.
