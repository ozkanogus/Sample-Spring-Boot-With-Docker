# Platform Upgrade Result

Recorded on 2026-09-07.

## Changes

- Java compiler release 8 to 21;
- Spring Boot 2.4.3 to 4.1.1;
- Java EE `javax` APIs to Jakarta APIs;
- MapStruct 1.4.2.Final to stable 1.6.3;
- springdoc 1.6.5 to the Spring Boot 4 starter line 3.1.0;
- legacy MySQL and Hibernate coordinates updated;
- Hibernate UUID mappings updated for Hibernate 7;
- unused Lombok removed;
- redundant explicit entity/repository scanning removed;
- Maven wrapper regenerated for Maven 3.9.11 and made executable.

The target versions were checked against official Spring Boot, MapStruct, and
springdoc release sources before implementation.

## Verification

`MAVEN_USER_HOME=<temporary> JAVA_HOME=<Temurin 21> ./mvnw -B -ntp clean verify`
succeeds and produces `target/employee-service.jar`. No tests exist yet, so this
stage proves compilation and packaging only.
