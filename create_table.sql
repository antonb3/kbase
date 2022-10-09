create table kbase.item
(
    id         serial not null
        constraint item_pk
            primary key,
    title      varchar(255),
    text       varchar(1000),
    lastupdate timestamp
);

alter table kbase.item
    owner to postgres;

create unique index item_id_uindex
    on kbase.item (id);

create table kbase.tag
(
    id  serial not null
        constraint tag_pk
            primary key,
    tag varchar(255)
);

alter table kbase.tag
    owner to postgres;

create unique index tag_id_uindex
    on kbase.tag (id);

create table kbase.item_tag
(
    id      serial not null
        constraint item_tag_pk
            primary key,
    item_id integer,
    tag_id  integer
);

alter table kbase.item_tag
    owner to postgres;

create unique index item_tag_id_uindex
    on kbase.item_tag (id);

create table kbase."user"
(
    id       serial not null
        constraint user_pk
            primary key,
    username varchar(255),
    password varchar(255)
);

alter table kbase."user"
    owner to postgres;

create unique index user_id_uindex
    on kbase."user" (id);

