CREATE DATABASE team;
USE team;
CREATE TABLE team (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    city VARCHAR(50),
    sport VARCHAR(50),
    PRIMARY KEY (id)
);
INSERT INTO team (name, city, sport)
VALUES
('Tigres UANL', 'Monterrey', 'Soccer'),
('Rayados', 'Monterrey', 'Soccer'),
('Los Angeles Lakers', 'Los Angeles', 'Basketball'),
('New York Yankees', 'New York', 'Baseball'),
('Dallas Cowboys', 'Dallas', 'American Football');