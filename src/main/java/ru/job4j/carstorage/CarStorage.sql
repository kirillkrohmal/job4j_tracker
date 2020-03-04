create table Машина (
id serial primary key,
name varchar(200),
кузов_id INTEGER REFERENCES Кузов(id),
двигатель_id INTEGER REFERENCES Двигатель(id),
коробка_передач_id INTEGER REFERENCES Коробка_передач(id)
);


create table Кузов (
id serial primary key,
name varchar(200)
);

create table Двигатель (
id serial primary key,
name varchar(200)
);

create table Коробка_передач (
id serial primary key,
name varchar(200)
);



insert into Машина(id, name, кузов_id, двигатель_id, коробка_передач_id) values (1, 'Mersedes', 1, 1, 1);

insert into Кузов(id, name) values (1, 'универсал');

insert into Двигатель(id, name) values (1, 'b-26');

insert into Коробка_передач(id, name) values (1, 'ZF');

insert into Машина(id, name, кузов_id, двигатель_id, коробка_передач_id) values (2, 'BMW', 2, 2, 2);

insert into Кузов(id, name) values (2, 'купе');

insert into Двигатель(id, name) values (2, 'm252');

insert into Коробка_передач(id, name) values (2, 'ZF');

insert into Машина(id, name, кузов_id, двигатель_id, коробка_передач_id) values (3, 'Opel', 3, 3, 3);

insert into Кузов(id, name) values (3, 'универсал');

insert into Двигатель(id, name) values (3, 'D53');

insert into Коробка_передач(id, name) values (3, 'F17');

insert into Машина(id, name, кузов_id, двигатель_id, коробка_передач_id) values (4, 'Chevrolet', 4, 4, 4);

insert into Кузов(id, name) values (4, 'седан');

insert into Двигатель(id, name) values (4, 'G54');

insert into Коробка_передач(id, name) values (4, 'F14D3');

insert into Машина(id, name, кузов_id, двигатель_id, коробка_передач_id) values (5, 'Audi', 5, 5, 5);

insert into Кузов(id, name) values (5, 'купе');

insert into Двигатель(id, name) values (5, 'b-26');

insert into Коробка_передач(id, name) values (5, 'ZF');

insert into Машина(id, name, кузов_id, двигатель_id, коробка_передач_id) values (6, 'Lada', 6, 6, 6);

insert into Кузов(id, name) values (6, 'седан');

insert into Двигатель(id, name) values (6, 'Mt424');

insert into Коробка_передач(id, name) values (6, 'АМТ');


select Машина.name as Машина_name, Кузов.name as кузов_name, Двигатель.name as двигатель_name, Коробка_передач.name as коробка_передач_name from Машина
left join Кузов on Машина.id = Кузов.id
left join Двигатель on Машина.id = Двигатель.id
left join Коробка_передач on Машина.id = Коробка_передач.id;


select Машина.name as Машина_name, Кузов.name as кузов_name, Двигатель.name as двигатель_name, Коробка_передач.name as коробка_передач_name from Машина
left join Кузов on Машина.id = Кузов.id and not exists (select * from Машина)
left join Двигатель on Машина.id = Двигатель.id and not exists (select * from Машина)
left join Коробка_передач on Машина.id = Коробка_передач.id and not exists (select * from Машина)

