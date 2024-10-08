CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);
