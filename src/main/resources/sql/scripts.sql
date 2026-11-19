CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(45) NOT NULL,
                       password VARCHAR(200) NOT NULL,
                       role VARCHAR(45) NOT NULL
);


CREATE TABLE auth_logs(
                          id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          username VARCHAR(100) NOT NULL,
                          event_type VARCHAR(50) NOT NULL,
                          timestamp timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP
);


