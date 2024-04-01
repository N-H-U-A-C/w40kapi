------------------------------------------------------------
--        Script H2
------------------------------------------------------------



------------------------------------------------------------
-- Table: authors
------------------------------------------------------------
INSERT INTO authors(id_author, name_author) VALUES (1, 'Inquisitor Damarn');
INSERT INTO authors(id_author, name_author) VALUES (2, 'Inquisitor Czevak');
INSERT INTO authors(id_author, name_author) VALUES (3, 'Casimir');
INSERT INTO authors(id_author, name_author) VALUES (4, 'Boba Fett');
INSERT INTO authors(id_author, name_author) VALUES (5, 'Victor Hugo');



------------------------------------------------------------
-- Table: excerpts
------------------------------------------------------------
INSERT INTO excerpts(id_excerpt, content, id_author) VALUES (1, 'Mankind stands upon the brink; on the one hand lies a realm of unimaginable power, on the other awaits darkness, death and utter damnation. Only those that follow the guiding light of the Emperor may save their souls.', 1);
INSERT INTO excerpts(id_excerpt, content) VALUES (2, 'May the Emperor''s Wrath forever cleanse our souls');
INSERT INTO excerpts(id_excerpt, content, context, id_author) VALUES (3, 'There is a terrible darkness descending upon the galaxy, and we shall not see it end in our lifetimes.', 'at the Conclave of Har', 2);
INSERT INTO excerpts(id_excerpt, content) VALUES (4, 'Hope is the first step on the road to disappointment.');
INSERT INTO excerpts(id_excerpt, title_excerpt, content) VALUES (5, 'Thought For The Day', 'If a job''s worth doing it''s worth dying for!');



------------------------------------------------------------
-- Table: categories
------------------------------------------------------------
INSERT INTO categories(id_category, name_category) VALUES (1, 'Thought for the day');
INSERT INTO categories(id_category, name_category) VALUES (2, 'Military');
INSERT INTO categories(id_category, name_category) VALUES (3, '3rd');
INSERT INTO categories(id_category, name_category) VALUES (4, '4th');
INSERT INTO categories(id_category, name_category) VALUES (5, '5th');
INSERT INTO categories(id_category, name_category) VALUES (6, '6th');
INSERT INTO categories(id_category, name_category) VALUES (7, '7th');
INSERT INTO categories(id_category, name_category) VALUES (8, '8th');
INSERT INTO categories(id_category, name_category) VALUES (9, '9th');
INSERT INTO categories(id_category, name_category) VALUES (10, '10th');
INSERT INTO categories(id_category, name_category) VALUES (11, '11th');
INSERT INTO categories(id_category, name_category) VALUES (12, '12th');
INSERT INTO categories(id_category, name_category) VALUES (13, '13th');
INSERT INTO categories(id_category, name_category) VALUES (14, '14th');
INSERT INTO categories(id_category, name_category) VALUES (15, '15th');
INSERT INTO categories(id_category, name_category) VALUES (16, '16th');
INSERT INTO categories(id_category, name_category) VALUES (17, '17th');
INSERT INTO categories(id_category, name_category) VALUES (18, '18th');
INSERT INTO categories(id_category, name_category) VALUES (19, '19th');
INSERT INTO categories(id_category, name_category) VALUES (20, '20th');
INSERT INTO categories(id_category, name_category) VALUES (21, '21th');



------------------------------------------------------------
-- Table: sources
------------------------------------------------------------
INSERT INTO sources(id_source, title_source, publication) VALUES (1, 'Rulebook (3rd Ed.)', 1998);
INSERT INTO sources(id_source, title_source, publication) VALUES (2, 'Rulebook (4th Ed.)', 2004);
INSERT INTO sources(id_source, title_source, publication) VALUES (3, 'Rulebook (5th Ed.)', 2008);
INSERT INTO sources(id_source, title_source, publication) VALUES (4, 'Codex', 1998);
INSERT INTO sources(id_source, title_source, publication) VALUES (5, 'Dummy Book', 1950);



------------------------------------------------------------
-- Table: titles
------------------------------------------------------------
INSERT INTO titles(id_title, name_title) VALUES (1, 'Ordo Malleus');



------------------------------------------------------------
-- Table: include
------------------------------------------------------------
INSERT INTO include(id_source, id_excerpt, page) VALUES (1, 1, 98);
INSERT INTO include(id_source, id_excerpt, page) VALUES (1, 2, 1);
INSERT INTO include(id_source, id_excerpt, page) VALUES (1, 3, 39);
INSERT INTO include(id_source, id_excerpt, page) VALUES (1, 4, 52);
INSERT INTO include(id_source, id_excerpt, page) VALUES (1, 5, 64);



------------------------------------------------------------
-- Table: categorize
------------------------------------------------------------
INSERT INTO categorize(id_category, id_excerpt) VALUES (1, 5);



------------------------------------------------------------
-- Table: designate
------------------------------------------------------------
INSERT INTO designate(id_author, id_title) VALUES (1, 1);
