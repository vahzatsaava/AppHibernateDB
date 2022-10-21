CREATE TABLE if not exists labels
(
    id serial not null,
    name varchar not null,
    post_id int,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    primary key (id),
)