DROP TABLE IF EXISTS cities;
CREATE TABLE cities(id serial PRIMARY KEY, name VARCHAR(255), population integer);

DROP TABLE IF EXISTS countries;
CREATE TABLE countries(id serial PRIMARY KEY, name VARCHAR(255), population integer);