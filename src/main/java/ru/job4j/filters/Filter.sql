
create table product(
id serial primary key,
name varchar(2000),
type_id int references type(id),
expired_date timestamp without time zone,
price int);

create table type(
id serial primary key,
name varchar(2000));

insert into product(id, name, type_id, expired_date, price) values (1, 'СЫР', 1, '2018-11-12 06:08:07', 1);

insert into product(id, name, type_id, expired_date, price) values (2, 'конфеты', 2, '2018-01-11 12:13:14', 2);

insert into product(id, name, type_id, expired_date, price) values (3, 'печенье', 3, '2018-04-11 12:13:14', 3);

insert into product(id, name, type_id, expired_date, price) values (4, 'капуста', 4, '2018-11-12 06:08:07', 4);

insert into product(id, name, type_id, expired_date, price) values (5, 'яблоки', 5, '2018-08-11 12:13:14', 5);

insert into product(id, name, type_id, expired_date, price) values (6, 'мед', 6, '2018-09-11 12:13:14', 6);

insert into product(id, name, type_id, expired_date, price) values (7, 'редиска', 7, '2018-11-12 06:08:07', 7);

insert into product(id, name, type_id, expired_date, price) values (8, 'мороженое', 8, '2018-04-11 12:13:14', 8);

insert into product(id, name, type_id, expired_date, price) values (9, 'МОЛОКО', 9, '2018-01-11 12:13:14', 9);

insert into product(id, name, type_id, expired_date, price) values (10, 'абрикосы', 10, '2018-11-12 06:08:07', 10);

insert into product(id, name, type_id, expired_date, price) values (11, 'груши', 11, '2018-11-11 12:13:14', 11);

insert into product(id, name, type_id, expired_date, price) values (12, 'ягоды', 12, '2018-12-11 12:13:14', 12);

insert into product(id, name, type_id, expired_date, price) values (13, 'картофель', 13, '2018-11-12 06:08:07', 13);

insert into product(id, name, type_id, expired_date, price) values (14, 'газировка', 14, '2018-09-11 12:13:14', 14);

insert into product(id, name, type_id, expired_date, price) values (15, 'рыба', 15, '2018-08-11 12:13:14', 15);

insert into product(id, name, type_id, expired_date, price) values (16, 'апельсины', 16, '2018-11-12 06:08:07', 16);

insert into product(id, name, type_id, expired_date, price) values (17, 'арбуз', 17, '2018-05-11 12:13:14', 17);

insert into product(id, name, type_id, expired_date, price) values (18, 'дыня', 18, '2018-05-11 12:13:14', 18);

insert into product(id, name, type_id, expired_date, price) values (19, 'мясо', 19, '2018-11-12 06:08:07', 19);

insert into product(id, name, type_id, expired_date, price) values (20, 'пирожные', 20, '2018-01-11 12:13:14', 20);

insert into product(id, name, type_id, expired_date, price) values (21, 'хлеб', 21, '2018-03-11 12:13:14', 21);

insert into product(id, name, type_id, expired_date, price) values (22, 'лук', 22, '2018-11-12 06:08:07', 22);

insert into product(id, name, type_id, expired_date, price) values (23, 'чеснок', 23, '2018-07-11 12:13:14', 23);

insert into product(id, name, type_id, expired_date, price) values (24, 'кефир', 24, '2018-11-11 12:13:14', 24);





insert into type(id, name) values (1, 'СЫР');

insert into type(id, name) values (2, 'конфеты');

insert into type(id, name) values (3, 'печенье');

insert into type(id, name) values (4, 'капуста');

insert into type(id, name) values (5, 'яблоки');

insert into type(id, name) values (6, 'СЫР');

insert into type(id, name) values (7, 'редиска');

insert into type(id, name) values (8, 'мороженое');

insert into type(id, name) values (9, 'МОЛОКО');

insert into type(id, name) values (10, 'СЫР');

insert into type(id, name) values (11, 'груши');

insert into type(id, name) values (12, 'ягоды');

insert into type(id, name) values (13, 'картофель');

insert into type(id, name) values (14, 'газировка');

insert into type(id, name) values (15, 'СЫР');

insert into type(id, name) values (16, 'апельсины');

insert into type(id, name) values (17, 'арбуз');

insert into type(id, name) values (18, 'дыня');

insert into type(id, name) values (19, 'мясо');

insert into type(id, name) values (20, 'пирожные');

insert into type(id, name) values (21, 'хлеб');

insert into type(id, name) values (22, 'лук');

insert into type(id, name) values (23, 'чеснок');

insert into type(id, name) values (24, 'кефир');



select product.id, product.name as product_name, type.name as type_name from product inner join type on product.type_id = type.id where type.name='СЫР';
select * FROM product where name = 'мороженое';
select * FROM product where expired_date = '2020-02-19';
select name, price FROM product where price = (select MAX(price) from product);
select COUNT(type.name) as product_name, type.name as type_name from product inner join type on product.type_id = type.id group by type.name having type.name = 'СЫР';
select * FROM type where name = 'СЫР' union all select name FROM type where name = 'МОЛОКО';
select type.name FROM type group by type.name having COUNT(type.name) < 10;
select product.id, product.name as product_name, type.name as type_name from product inner join type on product.type_id = type.id order by id, type.name;






