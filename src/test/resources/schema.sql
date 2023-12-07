------------------------------------------------------------
--        Script H2 
------------------------------------------------------------



------------------------------------------------------------
-- Table: authors
------------------------------------------------------------
CREATE TABLE authors(
	id_author     SERIAL NOT NULL ,
	name_author   VARCHAR (50) NOT NULL  ,
	CONSTRAINT authors_PK PRIMARY KEY (id_author)
);


------------------------------------------------------------
-- Table: excerpts
------------------------------------------------------------
CREATE TABLE excerpts(
	id_excerpt      SERIAL NOT NULL ,
	title_excerpt   VARCHAR (75)  ,
	content         VARCHAR (2000)  NOT NULL ,
	context         VARCHAR (2000)   ,
	id_author       INT    ,
	CONSTRAINT excerpts_PK PRIMARY KEY (id_excerpt)

	,CONSTRAINT excerpts_authors_FK FOREIGN KEY (id_author) REFERENCES authors(id_author)
);


------------------------------------------------------------
-- Table: categories
------------------------------------------------------------
CREATE TABLE categories(
	id_category     SERIAL NOT NULL ,
	name_category   VARCHAR (50) NOT NULL  ,
	CONSTRAINT categories_PK PRIMARY KEY (id_category)
);


------------------------------------------------------------
-- Table: sources
------------------------------------------------------------
CREATE TABLE sources(
	id_source      SERIAL NOT NULL ,
	title_source   VARCHAR (75) NOT NULL ,
	publication    SMALLINT  ,
	CONSTRAINT sources_PK PRIMARY KEY (id_source)

	,CONSTRAINT CHK_publication_validity 
   		CHECK (publication >= 1900 and publication <= 3000)  
);


------------------------------------------------------------
-- Table: titles
------------------------------------------------------------
CREATE TABLE titles(
	id_title    SERIAL NOT NULL ,
	name_title   VARCHAR (75) NOT NULL  ,
	CONSTRAINT titles_PK PRIMARY KEY (id_title)
);


------------------------------------------------------------
-- Table: include
------------------------------------------------------------
CREATE TABLE include(
	id_source    INT  NOT NULL ,
	id_excerpt   INT  NOT NULL ,
	page         SMALLINT    ,
	CONSTRAINT include_PK PRIMARY KEY (id_source,id_excerpt)

	,CONSTRAINT include_sources_FK FOREIGN KEY (id_source) REFERENCES sources(id_source)
	,CONSTRAINT include_excerpts0_FK FOREIGN KEY (id_excerpt) REFERENCES excerpts(id_excerpt)
);


------------------------------------------------------------
-- Table: categorize
------------------------------------------------------------
CREATE TABLE categorize(
	id_category   INT  NOT NULL ,
	id_excerpt    INT  NOT NULL  ,
	CONSTRAINT categorize_PK PRIMARY KEY (id_category,id_excerpt)

	,CONSTRAINT categorize_categories_FK FOREIGN KEY (id_category) REFERENCES categories(id_category)
	,CONSTRAINT categorize_excerpts0_FK FOREIGN KEY (id_excerpt) REFERENCES excerpts(id_excerpt)
);


------------------------------------------------------------
-- Table: designate
------------------------------------------------------------
CREATE TABLE designate(
	id_author          INT  NOT NULL ,
	id_title           INT  NOT NULL  ,
	CONSTRAINT designate_PK PRIMARY KEY (id_author,id_title)

	,CONSTRAINT designate_authors_FK FOREIGN KEY (id_author) REFERENCES authors(id_author)
	,CONSTRAINT designate_titles0_FK FOREIGN KEY (id_title) REFERENCES titles(id_title)
);
