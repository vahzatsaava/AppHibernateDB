CREATE TABLE if not exists labels
(
    id serial not null,
    name varchar not null,
    primary key (id)
);

CREATE TABLE if not exists writers
(
    id serial not null,
    firstname varchar(250) not null,
    lastname varchar(250) not null,
    primary key (id)
 );

CREATE TABLE IF NOT EXISTS posts
(
    id SERIAL NOT NULL,
    content VARCHAR(50) NOT NULL ,
    created DATE NOT NULL ,
    updated DATE NOT NULL,
    writer_id int not null ,
    FOREIGN KEY(writer_id) REFERENCES writers(id),
    PRIMARY KEY (id)
);

CREATE TABLE if NOT EXISTS post_labels
(
    post_id serial not null,
    label_id serial not null,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (label_id) REFERENCES labels(id),
    UNIQUE (post_id,label_id)
)

