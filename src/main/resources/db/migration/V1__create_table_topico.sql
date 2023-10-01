create table topico
(
    id       bigint       not null auto_increment,
    titulo       varchar(150) not null,
    mensaje        varchar(800) not null,
    fecha    varchar(50)  not null,
    autor varchar(150) not null,
    curso varchar(150) not null,

    primary key (id)
);