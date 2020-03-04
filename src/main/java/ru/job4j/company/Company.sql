CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);


insert into company(id, name) values (1, 'МММ');

insert into company(id, name) values (2, 'ВТБ24');

insert into company(id, name) values (3, 'Сбербанк');

insert into company(id, name) values (4, 'Лазурит');

insert into company(id, name) values (5, 'Ядро');

insert into company(id, name) values (6, 'Кока-Кола');

insert into company(id, name) values (7, 'Пепси');

insert into company(id, name) values (8, 'Инком');

insert into company(id, name) values (9, 'Аьфа-банк');

insert into company(id, name) values (10, 'Радуга');

insert into company(id, name) values (11, 'Возрождение');

insert into company(id, name) values (12, 'Гречанка');

insert into company(id, name) values (13, 'Русский Стандарт');

insert into company(id, name) values (14, 'Газпром');

insert into company(id, name) values (15, 'Лукойл');

insert into company(id, name) values (16, 'Ренесанс');

insert into company(id, name) values (17, 'ПИК');

insert into company(id, name) values (18, 'МИЦ');

insert into company(id, name) values (19, 'ОРТ');

insert into company(id, name) values (20, 'Россия-24');

insert into company(id, name) values (21, 'Сбертех');

insert into company(id, name) values (22, 'Русь');

insert into company(id, name) values (23, 'BMW');

insert into company(id, name) values (24, 'Mercedes');


insert into person(id, name, company_id) values (1, 'Александр', 1);

insert into person(id, name, company_id) values (2, 'Алексей', 2);

insert into person(id, name, company_id) values (3, 'Владимир', 3);

insert into person(id, name, company_id) values (4, 'Даниил', 4);

insert into person(id, name, company_id) values (5, 'Егор', 5);

insert into person(id, name, company_id) values (6, 'Кирилл', 6);

insert into person(id, name, company_id) values (7, 'Борис', 7);

insert into person(id, name, company_id) values (8, 'Валерий', 8);

insert into person(id, name, company_id) values (9, 'Артём', 9);

insert into person(id, name, company_id) values (10, 'Юрий', 10);

insert into person(id, name, company_id) values (11, 'Ярослав', 11);

insert into person(id, name, company_id) values (12, 'Сергей', 12);

insert into person(id, name, company_id) values (13, 'Пётр', 13);

insert into person(id, name, company_id) values (14, 'Павел', 14);

insert into person(id, name, company_id) values (15, 'Владислав', 15);

insert into person(id, name, company_id) values (16, 'Валентин', 16);

insert into person(id, name, company_id) values (17, 'Михаил', 17);

insert into person(id, name, company_id) values (18, 'Максим', 18);

insert into person(id, name, company_id) values (19, 'Леонид', 19);

insert into person(id, name, company_id) values (20, 'Роман', 20);

insert into person(id, name, company_id) values (21, 'Олег', 21);

insert into person(id, name, company_id) values (22, 'Фёдор', 22);

insert into person(id, name, company_id) values (23, 'Руслан', 23);

insert into person(id, name, company_id) values (24, 'Константин', 24);

insert into person(id, name, company_id) values (25, 'Аврора', 1);

insert into person(id, name, company_id) values (26, 'Рита', 2);

insert into person(id, name, company_id) values (27, 'Русалина', 3);

insert into person(id, name, company_id) values (28, 'Татьяна', 4);

insert into person(id, name, company_id) values (29, 'Светлана', 5);

insert into person(id, name, company_id) values (30, 'Ольга', 6);

insert into person(id, name, company_id) values (31, 'Оксана', 7);

insert into person(id, name, company_id) values (32, 'Калерия', 8);

insert into person(id, name, company_id) values (33, 'Полина', 9);

insert into person(id, name, company_id) values (34, 'Зоя', 10);

insert into person(id, name, company_id) values (35, 'Карина', 11);

insert into person(id, name, company_id) values (36, 'Олеся', 12);

insert into person(id, name, company_id) values (37, 'Лариса', 13);

insert into person(id, name, company_id) values (38, 'Пелагея', 14);

insert into person(id, name, company_id) values (39, 'Евгения', 15);

insert into person(id, name, company_id) values (40, 'Наталья', 16);

insert into person(id, name, company_id) values (41, 'Инга', 17);

insert into person(id, name, company_id) values (42, 'Нелли', 18);

insert into person(id, name, company_id) values (43, 'Надежда', 19);

insert into person(id, name, company_id) values (44, 'Нора', 20);

insert into person(id, name, company_id) values (45, 'Тамила', 21);

insert into person(id, name, company_id) values (46, 'Ника', 22);

insert into person(id, name, company_id) values (47, 'Полина', 23);

insert into person(id, name, company_id) values (48, 'Нелли', 24);

insert into person(id, name, company_id) values (49, 'Злата', 24);

insert into person(id, name, company_id) values (50, 'Лара', 24);

insert into person(id, name, company_id) values (51, 'Сабина', 24);

insert into person(id, name, company_id) values (52, 'Тамара', 24);


SELECT p.name as Сотрудник
FROM person p left join company c on p.company_id = c.id WHERE p.company_id not in(5);

SELECT p.name as Сотрудник, c.name as Компания
FROM person p left join company c on p.company_id = c.id;

SELECT c.name as Компания, count(p.name) as Сотрудник
FROM company c left join person p on p.company_id = c.id
where exists (select max(p.name) from person p) group by c.name, p.name;


SELECT c.name, COUNT(*) AS Сотрудник
FROM company c left join person p on p.company_id = c.id GROUP BY c.name ORDER BY Сотрудник DESC;

SELECT c.name as Компания, count(*) as Сотрудник
FROM company c left join person p on p.company_id = c.id
group by c.name ORDER BY Сотрудник DESC;



