# Repository Working Agreement

## Purpose

This repository contains an employee-management REST service and its container
packaging. Preserve observable API behavior while modernizing its platform,
configuration, tests, documentation, and delivery controls.

## Branching

- Never commit modernization work directly to `main`.
- Merge focused `modernization/*` branches into
  `modernization/java21-spring-boot`.
- Leave the final pull request to `main` for owner review and merge.

## Verification

- Use Java 21.
- Run `./mvnw -B -ntp clean verify` before merging a focused branch.
- Keep credentials out of tracked configuration.
- Prefer deterministic tests using H2; verify MySQL separately where practical.

## Compatibility

- Preserve `/api/employee` routes and their response shapes unless a change is
  explicitly documented.
- Treat database schema changes as migrations, not implicit Hibernate updates.
