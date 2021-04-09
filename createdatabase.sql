DROP SCHEMA IF EXISTS dat109_project CASCADE;
CREATE SCHEMA dat109_project;
SET search_path TO dat109_project;

CREATE TABLE role
(
    role VARCHAR(20) NOT NULL,
    PRIMARY KEY (role)
);

INSERT INTO role (role)
VALUES ('ADMIN'), ('MODERATOR'), ('ARTIST'), ('REGULAR');

CREATE TABLE usertable
(
    username VARCHAR(20) NOT NULL,
    role VARCHAR(20),
    email VARCHAR(30) NOT NULL,
    displayname VARCHAR(50),
    password VARCHAR(128) NOT NULL,
    PRIMARY KEY (username),
    FOREIGN KEY (role) REFERENCES role(role)
);

INSERT INTO usertable (username, role, email, displayname, password)
VALUES ('admin', 'ADMIN', 'sysadmin@playalong.com', 'systemadmin', 'AkFsNSw0pMXGeuuAjIM6fsm0pwJUtvnhycfF7uhB+Iu6x6G47uZ1Mxn+zG29Qnn2ih7RYZLqYSM=');
-- password: sysadm
CREATE TABLE log
(
    id SERIAL NOT NULL,
    timestamp BIGINT NOT NULL,
    messagetype VARCHAR(48),
    message VARCHAR(256),
    PRIMARY KEY (id)
)
