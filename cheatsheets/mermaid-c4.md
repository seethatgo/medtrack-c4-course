# Mermaid C4 — Reference

Run these at [mermaid.live](https://mermaid.live).

## Diagram types

- `C4Context` — Level 1, system in its environment
- `C4Container` — Level 2, deployable/runnable units
- `C4Component` — Level 3, building blocks inside one container
- `C4Dynamic` — a numbered flow across elements

## Core keywords

- `Person(id, "Name", "Description")`
- `System(id, "Name", "Description")` / `System_Ext(...)` for external
- `Container(id, "Name", "Technology", "Description")`
- `ContainerDb(id, "Name", "Technology", "Description")` for data stores
- `Component(id, "Name", "Technology", "Description")`
- `Rel(from, to, "Label", "Technology")` — technology is optional
- Boundaries: `System_Boundary(id, "Name") { ... }`, `Container_Boundary(id, "Name") { ... }`

## Level 1 — Context

```
C4Context
    title System Context — MedTrack — 2026-07
    Person(patient, "Patient", "Books appointments and requests refills")
    Person(staff, "Clinic Staff", "Manages schedules and refill queue")
    System(medtrack, "MedTrack", "Appointment and prescription-refill platform")
    System_Ext(ehr, "EHR System", "Patient records of record")
    System_Ext(pharmacy, "Pharmacy Network", "Fulfills approved refills")
    System_Ext(sms, "SMS Provider", "Sends reminder and status texts")
    System_Ext(elig, "Insurance Eligibility Service", "Real-time coverage checks")
    Rel(patient, medtrack, "Books appointments, requests refills using", "HTTPS")
    Rel(staff, medtrack, "Manages schedules using", "HTTPS")
    Rel(medtrack, ehr, "Gets patient records from", "HL7 FHIR R4/HTTPS")
    Rel(medtrack, pharmacy, "Submits approved refills to", "HTTPS")
    Rel(medtrack, sms, "Sends notifications via", "HTTPS")
    Rel(medtrack, elig, "Checks coverage with", "HTTPS")
```

## Level 2 — Container

```
C4Container
    title Container diagram — MedTrack — 2026-07
    Person(patient, "Patient", "Books appointments and requests refills")
    Person(staff, "Clinic Staff", "Manages schedules and refill queue")
    System_Boundary(medtrack, "MedTrack") {
        Container(mobile, "Mobile App", "React Native", "Patient appointment and refill features")
        Container(web, "Staff Web App", "React SPA", "Schedule management and refill queue")
        Container(api, "API Application", "Java / Spring Boot", "Business logic and integrations")
        ContainerDb(db, "Database", "PostgreSQL", "Appointments, refills, audit log")
    }
    System_Ext(ehr, "EHR System", "Patient records of record")
    Rel(patient, mobile, "Uses", "HTTPS")
    Rel(staff, web, "Uses", "HTTPS")
    Rel(mobile, api, "Makes API calls to", "JSON/HTTPS")
    Rel(web, api, "Makes API calls to", "JSON/HTTPS")
    Rel(api, db, "Reads from and writes to", "JDBC")
    Rel(api, ehr, "Gets patient records from", "HL7 FHIR R4/HTTPS")
```

## Level 3 — Component

```
C4Component
    title Component diagram — MedTrack API — 2026-07
    Container_Boundary(api, "API Application") {
        Component(refillController, "RefillController", "Spring MVC", "Refill REST endpoints")
        Component(refillService, "RefillService", "Spring Service", "Orchestrates the refill flow")
        Component(eligibilityService, "EligibilityService", "Spring Service", "Checks coverage")
        Component(notificationService, "NotificationService", "Spring Service", "Sends patient notifications")
    }
    System_Ext(pharmacy, "Pharmacy Network", "Fulfills approved refills")
    System_Ext(sms, "SMS Provider", "Sends texts")
    Rel(refillController, refillService, "Calls")
    Rel(refillService, eligibilityService, "Checks eligibility with")
    Rel(refillService, pharmacy, "Submits approved refill to", "HTTPS")
    Rel(refillService, notificationService, "Notifies via")
    Rel(notificationService, sms, "Sends text via", "HTTPS")
```

## Dynamic — a numbered flow

```
C4Dynamic
    title Dynamic diagram — Refill request — 2026-07
    Person(patient, "Patient", "Requests a refill")
    Container(api, "API Application", "Java / Spring Boot", "Orchestration")
    System_Ext(elig, "Insurance Eligibility Service", "Coverage checks")
    System_Ext(pharmacy, "Pharmacy Network", "Fulfills refills")
    System_Ext(sms, "SMS Provider", "Sends texts")
    Rel(patient, api, "1. Requests prescription refill", "HTTPS")
    Rel(api, elig, "2. Checks coverage with", "HTTPS")
    Rel(api, pharmacy, "3. Submits approved refill to", "HTTPS")
    Rel(api, sms, "4. Sends status text via", "HTTPS")
```

## Gotchas

- Mermaid C4 is officially **experimental** — syntax and rendering can change between versions.
- Layout follows **statement order**, not an algorithm. Reordering lines moves the diagram; there is no autoLayout.
- Use `UpdateLayoutConfig($c4ShapeInRow="3")` to change how many shapes sit per row.
