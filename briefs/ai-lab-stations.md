# AI Acceleration Lab — Station Cards 

Pick **two** of the three stations below, about 15 minutes each. Every station ends on the same question: **where was the AI right, where was it wrong, and how did you know?**

## Station A — The AI Reviewer

Paste your Day 1 Context diagram source plus `cheatsheets/review-checklist.md` into Copilot Chat:

> Review this diagram against this checklist. List violations and suggested fixes.

Compare its findings to Monday's human review. Tally three things: what did
AI catch that humans missed? What did it flag that's wrong or pedantic? What
did it miss entirely?

## Station B — The Translator

Feed in your Container diagram source, then run both prompts:

> Prompt 1: Explain this architecture to a non-technical VP in five bullets — business language, no acronyms.
>
> Prompt 2: Write a one-page "start here" summary for an engineer joining this team Monday.

Grade both for accuracy — hunt for the confident sentence that's simply
false. There's usually one.

## Station C — English to Model

Write 4–6 plain-English sentences describing MedTrack, then prompt:

> Generate a Structurizr DSL workspace for this system with a context view and a container view.

Paste the result into [https://playground.structurizr.com/](https://playground.structurizr.com/)
Fix errors until it parses **and** renders sensibly. Count your fixes.