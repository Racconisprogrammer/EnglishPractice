--liquibase formatted sql

--changeset Farkhod:1
--comment first migration

create table users
(
    id bigint auto_increment primary key,
    email      varchar(255) null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    password   varchar(255) null
);

INSERT INTO users (email, first_name, last_name, password)
VALUES ('rashidullo@gmail.com', 'Rashidullo', 'Abdullayev', '587595');
create table user_roles
(
    user_id bigint not null,
    roles enum ('ROLE_USER', 'ROLE_ADMIN') null,
    foreign key (user_id) references users (id),
    UNIQUE (user_id)
);

insert into user_roles (user_id, roles)
values (1, 'ROLE_USER');

create table en_words
(
    id bigint auto_increment primary key,
    meaning varchar(255) null
);
insert into en_words (id, meaning)
values (1, 'Hello');

create table ru_words
(
    id bigint auto_increment primary key,
    meaning varchar(255) null
);

create table cards
(
    id bigint auto_increment primary key,
    rating bigint null,
    en_word_id bigint null,
    ru_word_id bigint null,
    foreign key (en_word_id) references en_words (id),
    foreign key (ru_word_id) references ru_words (id),
    UNIQUE (ru_word_id),
    UNIQUE (en_word_id)
);
