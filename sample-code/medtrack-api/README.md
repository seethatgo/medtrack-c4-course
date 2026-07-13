# medtrack-api

This code exists to be diagrammed.

A deliberately small, layered Spring Boot 3 (Java 17) service. The package names
are the architecture: read them top to bottom and the component diagram draws
itself.

## Layered architecture

```
com.medtrack.api
├── controller/          REST endpoints, thin — call services only
│   ├── AppointmentController  -> AppointmentService
│   └── RefillController       -> RefillService
├── service/             business logic
│   ├── AppointmentService     -> AppointmentRepository, EhrClient
│   ├── RefillService          -> EligibilityService, PharmacyClient, NotificationService
│   ├── EligibilityService     -> EligibilityClient
│   └── NotificationService    -> SmsClient
├── repository/          Spring Data JPA over H2 (in-memory)
│   ├── AppointmentRepository
│   └── RefillRepository
├── client/              stubs for external systems (no real HTTP)
│   ├── EhrClient              (HL7 FHIR R4 over HTTPS)
│   ├── PharmacyClient
│   ├── SmsClient
│   └── EligibilityClient
└── model/               entities + DTOs
```

The refill flow is the demo's payoff — open `RefillService` and read it:
eligibility check, then pharmacy submission, then patient notification.

## Layering rules

- Controllers call only services.
- Services call repositories and clients.
- Nothing skips a layer.

## Build

```
mvn -q compile
```

No network calls at runtime; the client classes return hard-coded stub data.
