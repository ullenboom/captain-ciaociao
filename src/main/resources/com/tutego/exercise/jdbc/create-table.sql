DROP ALL OBJECTS;

CREATE TABLE Pirate (
  id           IDENTITY,
  nickname     VARCHAR(255) UNIQUE NOT NULL,
  email        VARCHAR(255) UNIQUE NOT NULL,
  swordlength  INT,
  birthdate    DATE,
  description  VARCHAR(4096)
);
