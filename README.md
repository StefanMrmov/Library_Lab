INSERT INTO Country (name, continent)
VALUES ('United States', 'North America');

INSERT INTO Author (name, surname, country_id)
VALUES ('John', 'Doe', (SELECT id FROM Country WHERE name = 'United States'));

INSERT INTO Book (name, category, author_id, available_copies)
VALUES ('The Great Gatsby', 'NOVEL', 1, 100);
