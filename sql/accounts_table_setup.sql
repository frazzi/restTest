CREATE TABLE
    account
    (
        id BIGINT NOT NULL,
        firstName VARCHAR,
        secondName VARCHAR,
        accountNumber VARCHAR,
        PRIMARY KEY (id)
    );

CREATE TABLE
    hibernate_sequence
    (
        next_val BIGINT
    );

INSERT INTO ACCOUNT (id, firstName, secondName, accountNumber)
  VALUES (1, 'John', 'Doe', '1234');
INSERT INTO ACCOUNT (id, firstName, secondName, accountNumber)
  VALUES (2, 'Jane', 'Doe', '1235');
INSERT INTO ACCOUNT (id, firstName, secondName, accountNumber)
    VALUES (3, 'Jim', 'Taylor', '1236');

INSERT INTO hibernate_sequence (next_val) VALUES (3);