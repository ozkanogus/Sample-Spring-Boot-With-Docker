# Configuration and Database Result

Recorded on 2026-09-07.

- removed the tracked MySQL root password;
- externalized database, server-port, and audit-path settings;
- replaced Hibernate schema mutation with validation;
- added a Flyway-owned MySQL baseline for the employee and Envers tables;
- disabled Open EntityManager in View;
- added an isolated H2 test profile;
- removed unrestricted global CORS from the controller.

Existing databases require an owner-reviewed Flyway baseline/adoption procedure
before deployment. No real database was modified by this stage.
