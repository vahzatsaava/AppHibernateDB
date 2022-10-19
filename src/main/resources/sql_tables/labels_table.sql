CREATE TABLE if not exists labels
(
    id serial not null,
    name varchar not null,
    post_id int not null,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    primary key (id),
    unique (post_id)

)