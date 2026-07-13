# AI Prompt Patterns

Five patterns for the five course AI use cases. Each has a template, a filled
MedTrack example, and a caveat.

## 1. Code to diagram

**Template:** `Analyze this <framework> service and generate a Mermaid <C4 level> diagram of its major elements and relationships. Group <what to collapse>. Include external systems.`

**Example:** "Analyze this Spring Boot service and generate a Mermaid C4Component diagram of its major components and their relationships. Group the repositories. Include the external systems the clients talk to."

**Caveat:** verify against the review checklist — AI invents relationships and drops clients.

## 2. Natural language to diagram code

**Template:** `Here's a system description: <paragraph>. Generate <Mermaid C4Context | Structurizr DSL> for it.`

**Example:** "Here's a system description: MedTrack lets patients book appointments and request refills from a mobile app; staff manage schedules in a web app; it integrates with an EHR over HL7 FHIR, a pharmacy network, an SMS provider, and an eligibility service. Generate a Mermaid C4Context diagram."

**Caveat:** verify against the checklist — technology on relationships is usually missing.

## 3. Diagram scoring

**Template:** `Review this diagram against this checklist. List violations and suggested fixes. <paste diagram source> <paste checklist>`

**Example:** paste the MedTrack Context Mermaid + `review-checklist.md`.

**Caveat:** AI both misses real violations and invents fake ones — treat its list as a draft, not a verdict.

## 4. ADR drafting

**Template:** `Draft an Architecture Decision Record in Nygard format (Title, Status, Context, Decision, Consequences) for this decision: <decision + constraints>.`

**Example:** "...our MedTrack team chose a single PostgreSQL database for both appointments and refills instead of separate databases. Team of six, launch in one quarter."

**Caveat:** AI cannot know your real Context or Consequences — it writes generic bad news; you supply the specific bad news.

## 5. Audience translation

**Template:** `Explain this architecture to <audience> in <format> — <constraints>. <paste diagram or DSL>`

**Example:** "Explain this architecture to a non-technical VP in five bullets — business language, no acronyms."

**Caveat:** hunt for the one confident-but-false sentence; there usually is one.

---

## House rules

- AI drafts; humans own scope, intent, and consequences.
- Label AI-drafted artifacts as AI-drafted.
- Never paste PHI or confidential material into a prompt.
