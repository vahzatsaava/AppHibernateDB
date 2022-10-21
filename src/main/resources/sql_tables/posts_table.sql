CREATE TABLE IF NOT EXISTS posts
(
    id SERIAL NOT NULL ,
    content VARCHAR(50) NOT NULL ,
    created DATE NOT NULL ,
    updated DATE NOT NULL,
    writer_id int,
    FOREIGN KEY(writer_id) REFERENCES writers(id),
    PRIMARY KEY (id),
)