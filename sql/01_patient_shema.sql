create sequence patient_seq start with 1000 increment by 1;

create table "patient" (
    id integer,
    first_name varchar(64),
    mid_name varchar(64),
    last_name varchar(64),
    gender_id smallint,
    birthday date,
    phone varchar(24),
    email varchar(32),
    addres varchar(128)
);

alter table "patient" add constraint patient_id_pk primary key (id);
create index patient_pk_idx on "patient"(id);
