# ADR-0001: Use a single PostgreSQL database for appointments and refills

## Status
Accepted (2026-07-14)

## Context
MedTrack v1 serves ~50k patients with two workloads: appointment scheduling
(read-heavy, spiky Monday mornings) and refill processing (low volume,
human-in-the-loop, hours-long lifecycle). The team is six engineers, two of
whom have production PostgreSQL experience; nobody has run a multi-database
system in production. Launch is in one quarter. Splitting stores was proposed
to isolate the workloads.

## Decision
We will run both workloads in a single PostgreSQL instance, in separate
schemas, behind one API application.

## Consequences
Better: one backup/restore story, one connection pool, transactions can span
appointments and refills (audit writes are atomic), and the team's existing
skills cover it. Simpler local dev.

Worse: the workloads now share a blast radius — a runaway scheduling query can
slow refill processing. Schema-level separation is a convention, not an
enforcement boundary, so coupling can creep. If either workload grows an order
of magnitude, we revisit; the exit path is per-schema extraction, and this
record should be superseded when that happens.
