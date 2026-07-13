# Environment Card B — "Hybrid" (Exercise 6)

Map YOUR containers onto this infrastructure. Show Production. Stretch: sketch
Development and note what's different.

Available infrastructure:
- Same cloud stack as Card A (managed K8s, managed PostgreSQL, API gateway,
  managed broker, object storage)
- BUT: the EHR System lives on-premises in the clinic data center, and all EHR
  traffic MUST route through an on-prem **EHR Integration Gateway** you operate.
- The clinic data center has: the EHR, the EHR Integration Gateway server, and a
  site-to-site VPN to the cloud.
- Everything else is as Card A.

Questions your diagram should answer: where does the trust boundary sit? What
happens to refill flow if the VPN drops?
