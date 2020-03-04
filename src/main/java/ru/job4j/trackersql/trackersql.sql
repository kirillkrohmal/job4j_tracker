CREATE TABLE trackersql
(
    id serial NOT NULL,
    key character varying(30) DEFAULT NULL::character varying,
    name text,
    creat integer,
    description text,
    CONSTRAINT trackersql_pkey PRIMARY KEY (id)
);