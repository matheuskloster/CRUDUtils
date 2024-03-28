CREATE TABLE my_entity (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    idade INTEGER

);


CREATE TABLE other_entity (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    my_entity_id INTEGER,
    FOREIGN KEY (my_entity_id) REFERENCES my_entity(id)
);



