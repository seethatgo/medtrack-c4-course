# Diagram Review Checklist

Adapted from the official C4 model diagram review checklist:
<https://c4model.com/diagrams/checklist> (© Simon Brown / c4model.com).
Use it on every diagram before you call it done.

## Every diagram

- [ ] Title states the **diagram type**, **scope**, and **date** (e.g. "System Context — MedTrack — 2026-07").
- [ ] A **legend/key** explains shapes, colors, line styles, and acronyms.
- [ ] The **abstraction level is consistent** — no mixing containers with components on one diagram.

## Elements

- [ ] Every element has a **name**, an element **type**, and a short **description**.
- [ ] Containers and components state their **technology**.
- [ ] External systems are visually distinct (e.g. gray) from the system in scope.

## Relationships

- [ ] Every line is **labeled with a verb phrase** ("Gets patient records from", not "uses").
- [ ] Line **direction is meaningful** and matches the dependency.
- [ ] **Protocol/technology is noted** where it matters (e.g. "HL7 FHIR R4/HTTPS", "JDBC").

## Overall

- [ ] A **readable count** of elements — if it's crowded, split or raise the abstraction level.
- [ ] All **acronyms are expanded** at least once (EHR, FHIR, SMS, ...).
- [ ] The **intended audience is identified** and the diagram suits them.
