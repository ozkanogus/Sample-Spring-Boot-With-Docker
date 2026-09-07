CREATE TABLE employee (
    id CHAR(36) NOT NULL,
    name VARCHAR(255),
    role VARCHAR(32),
    remote_user_id CHAR(36),
    remote_addres VARCHAR(255),
    date_created TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    last_updated TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id)
);

CREATE TABLE revinfo (
    rev INTEGER NOT NULL AUTO_INCREMENT,
    revtstmp BIGINT,
    PRIMARY KEY (rev)
);

CREATE TABLE employee_aud (
    id CHAR(36) NOT NULL,
    rev INTEGER NOT NULL,
    revtype TINYINT,
    name VARCHAR(255),
    role VARCHAR(32),
    remote_user_id CHAR(36),
    remote_addres VARCHAR(255),
    date_created TIMESTAMP(6),
    last_updated TIMESTAMP(6),
    PRIMARY KEY (id, rev),
    CONSTRAINT fk_employee_aud_revinfo FOREIGN KEY (rev) REFERENCES revinfo (rev)
);
