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

