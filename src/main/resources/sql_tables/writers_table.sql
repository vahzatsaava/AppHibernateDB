CREATE TABLE if not exists writers
(
    id serial not null,
    firstname varchar(250) not null,
    lastname varchar(250) not null,
    primary key (id)
)