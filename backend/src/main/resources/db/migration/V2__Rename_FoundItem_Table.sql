
CREATE TABLE new_found_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    location VARCHAR(255) NOT NULL,
    date VARCHAR(255) NOT NULL
);

DROP TABLE found_items;