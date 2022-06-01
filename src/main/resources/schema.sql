DROP TABLE IF EXISTS memo;
DROP SEQUENCE IF EXISTS seq_memo_id;

CREATE SEQUENCE seq_memo_id INCREMENT BY 1 START WITH 1;

CREATE TABLE memo(
    id INTEGER PRIMARY KEY DEFAULT nextval('seq_memo_id'),
    content VARCHAR(256),
    created_at TIMESTAMP DEFAULT current_timestamp
);
