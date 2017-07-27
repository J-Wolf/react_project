# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table autor (
  autor_id                      bigint auto_increment not null,
  vorname                       varchar(255),
  nachname                      varchar(255),
  geburts_datum                 varchar(255),
  verlag_verlag_id              bigint,
  constraint pk_autor primary key (autor_id)
);

create table buch (
  buch_id                       bigint auto_increment not null,
  titel                         varchar(255),
  untertitel                    varchar(255),
  isbn                          varchar(255),
  seiten_anzahl                 integer,
  autor_autor_id                bigint,
  constraint pk_buch primary key (buch_id)
);

create table leser (
  autor_id                      bigint auto_increment not null,
  vorname                       varchar(255),
  nachname                      varchar(255),
  geburts_datum                 varchar(255),
  constraint pk_leser primary key (autor_id)
);

create table verlag (
  verlag_id                     bigint auto_increment not null,
  bezeichnung                   varchar(255),
  strasse                       varchar(255),
  plz                           varchar(255),
  ort                           varchar(255),
  verlag_verlag_id              bigint,
  constraint pk_verlag primary key (verlag_id)
);

alter table autor add constraint fk_autor_verlag_verlag_id foreign key (verlag_verlag_id) references verlag (verlag_id) on delete restrict on update restrict;
create index ix_autor_verlag_verlag_id on autor (verlag_verlag_id);

alter table buch add constraint fk_buch_autor_autor_id foreign key (autor_autor_id) references autor (autor_id) on delete restrict on update restrict;
create index ix_buch_autor_autor_id on buch (autor_autor_id);

alter table verlag add constraint fk_verlag_verlag_verlag_id foreign key (verlag_verlag_id) references verlag (verlag_id) on delete restrict on update restrict;
create index ix_verlag_verlag_verlag_id on verlag (verlag_verlag_id);


# --- !Downs

alter table autor drop foreign key fk_autor_verlag_verlag_id;
drop index ix_autor_verlag_verlag_id on autor;

alter table buch drop foreign key fk_buch_autor_autor_id;
drop index ix_buch_autor_autor_id on buch;

alter table verlag drop foreign key fk_verlag_verlag_verlag_id;
drop index ix_verlag_verlag_verlag_id on verlag;

drop table if exists autor;

drop table if exists buch;

drop table if exists leser;

drop table if exists verlag;

