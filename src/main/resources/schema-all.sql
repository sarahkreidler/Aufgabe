//Wenn die Tabelle exisitert so wird diese zunächst entfernt und neu geschrieben
DROP TABLE mapping IF EXISTS;

CREATE TABLE mapping  (
    isin VARCHAR(20),
    tradeid VARCHAR(20)
);
