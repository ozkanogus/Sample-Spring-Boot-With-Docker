# Delivery Result

Recorded on 2026-09-07.

- replaced the obsolete Java 8 image with a Java 21 multi-stage build;
- run the runtime container as an unprivileged user;
- added an actuator-backed container health check;
- added least-privilege GitHub Actions jobs for Java 21, MySQL 8.4, and Docker;
- added a MySQL-gated context test for Flyway and Hibernate validation;
- replaced the placeholder README with setup, API, architecture, verification,
  container, and remaining-risk documentation.

The first hosted run exposed missing Spring Boot 4 Flyway auto-configuration.
The follow-up added the modular `spring-boot-starter-flyway` dependency and moved
GitHub's JavaScript actions to their Node 24-compatible major versions.
