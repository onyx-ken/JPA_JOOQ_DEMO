CREATE TABLE team
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE member
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    team_id INTEGER,
    CONSTRAINT fk_team
        FOREIGN KEY (team_id)
            REFERENCES team (id)
            ON DELETE SET NULL
);
