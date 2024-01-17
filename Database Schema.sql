DROP DATABASE spring_bishamonten_idp;
CREATE DATABASE spring_bishamonten_idp;
USE spring_bishamonten_idp;

CREATE TABLE authentication_methods
(
    id   SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) UNIQUE                          NOT NULL
);

INSERT INTO authentication_methods (name)
VALUES ('client_secret_basic'),
       ('client_secret_post'),
       ('client_secret_jwt'),
       ('private_key_jwt'),
       ('none');

CREATE TABLE grant_types
(
    id   SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) UNIQUE                          NOT NULL
);

INSERT INTO authentication_methods (name)
VALUES ('authorization_code'),
       ('refresh_token'),
       ('client_credentials');

CREATE TABLE scopes
(
    id   INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)                            NOT NULL
);

CREATE TABLE clients
(
    id                       BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    client_id                VARCHAR(255)                               NOT NULL,
    client_id_issued_at      TIMESTAMP                                  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    client_secret            VARCHAR(255)                               NOT NULL,
    client_secret_expires_at TIMESTAMP,
    client_name              VARCHAR(255)                               NOT NULL
);

CREATE TABLE clients_authentication_methods
(
    authentication_method_id SMALLINT UNSIGNED NOT NULL,
    client_id                BIGINT UNSIGNED   NOT NULL,
    UNIQUE (authentication_method_id, client_id),
    CONSTRAINT fk_clients_authentication_methods_authentication_methods FOREIGN KEY (authentication_method_id) REFERENCES authentication_methods (id),
    CONSTRAINT fk_clients_authentication_methods_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE clients_grant_types
(
    grant_type_id SMALLINT UNSIGNED NOT NULL,
    client_id     BIGINT UNSIGNED   NOT NULL,
    UNIQUE (grant_type_id, client_id),
    CONSTRAINT fk_clients_grant_types_grant_types FOREIGN KEY (grant_type_id) REFERENCES authentication_methods (id),
    CONSTRAINT fk_clients_grant_types_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE redirect_uris
(
    id        SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255)                                 NOT NULL,
    client_id BIGINT UNSIGNED                              NOT NULL,
    CONSTRAINT fk_redirect_uris_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE post_logout_redirect_uris
(
    id        SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255)                                 NOT NULL,
    client_id BIGINT UNSIGNED                              NOT NULL,
    CONSTRAINT fk_post_logout_redirect_uris_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE clients_scopes
(
    scope_id  INT UNSIGNED    NOT NULL,
    client_id BIGINT UNSIGNED NOT NULL,
    UNIQUE (scope_id, client_id),
    CONSTRAINT fk_clients_scopes_scopes FOREIGN KEY (scope_id) REFERENCES scopes (id),
    CONSTRAINT fk_clients_scopes_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE token_settings
(
    id                           BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    authorization_code_ttl       SMALLINT UNSIGNED           NOT NULL,
    access_token_ttl             SMALLINT UNSIGNED           NOT NULL,
    access_token_format          ENUM ('self-contained', 'reference'),
    device_code_ttl              SMALLINT UNSIGNED           NOT NULL,
    reuse_refresh_token          BOOLEAN                     NOT NULL DEFAULT FALSE,
    refresh_token_ttl            SMALLINT UNSIGNED           NOT NULL,
    id_token_signature_algorithm VARCHAR(10)                 NOT NULL DEFAULT 'RS256',
    client_id                    BIGINT UNSIGNED             NOT NULL,
    CONSTRAINT fk_token_settings_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE client_settings
(
    id                                              BIGINT UNSIGNED PRIMARY KEY NOT NULL,
    require_proof_key                               BOOLEAN                     NOT NULL,
    require_authorization_consent                   BOOLEAN                     NOT NULL,
    jwk_set_url                                     VARCHAR(255)                NOT NULL,
    token_endpoint_authentication_signing_algorithm VARCHAR(10)                 NOT NULL DEFAULT 'RS256',
    client_id                                       BIGINT UNSIGNED             NOT NULL,
    CONSTRAINT fk_client_settings_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);