# Test Baseline

Recorded on 2026-09-07 before modernization.

## Commands and Results

- `./mvnw -B -ntp test`: blocked because the wrapper metadata and JAR are absent
  and `mvnw` is not executable.
- `JAVA_HOME=<Temurin 21> mvn -B -ntp test`: build succeeds after dependency
  resolution through system Maven.
- Tests discovered: 0.

The successful compilation does not establish Java 21 support because the legacy
POM still compiles with source and target 1.8. It also provides no behavioral
regression protection.

## Initial Risks

- no automated API, service, repository, or packaging verification;
- an `active` persistence attribute is referenced by the paging specification
  but is absent from the entity model;
- update mapping can discard the path identifier;
- catch-all error handling prints stack traces and exposes exception types;
- permissive global CORS;
- tracked MySQL root credentials and implicit schema mutation;
- obsolete container base image and root container execution.
