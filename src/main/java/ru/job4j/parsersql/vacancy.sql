CREATE TABLE vacancy (
    id serial NOT NULL,
    name character varying(200),
    text character varying(200),
    link character varying(2000),
    CONSTRAINT vacancy_pkey PRIMARY KEY (id)
);