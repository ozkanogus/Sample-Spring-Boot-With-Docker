# Repository Profile

## Application

- Type: Spring Boot employee-management REST service
- Build: Maven
- Database: MySQL in runtime configuration, H2 test dependency
- Container: single-stage Docker image
- Default branch: `main`
- Modernization integration branch: `modernization/java21-spring-boot`

## Legacy Baseline

- Java target: 8
- Spring Boot: 2.4.3
- Persistence namespace: `javax.persistence`
- Tests: none
- CI: none
- Schema management: `spring.jpa.hibernate.ddl-auto=update`
- Credentials: tracked development MySQL username and password
- Maven wrapper: scripts tracked without `.mvn/wrapper` metadata; Unix script
  not executable

## Intended Target

- Java 21
- A currently supported Spring Boot line compatible with Java 21
- Jakarta APIs
- externalized database settings and migration-safe defaults
- characterization, service, and HTTP tests
- reproducible Maven wrapper, container build, and GitHub Actions verification

API behavior and persisted schema are compatibility boundaries.
