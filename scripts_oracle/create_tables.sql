drop table departamentos;
drop sequence departamentos_seq;

create sequence departamentos_seq;

create table departamentos(
codigo number default departamentos_seq.nextval,
nome varchar2(50) not null,
local varchar2(30) not null,
cidade varchar2(50) not null,
estado char(2) not null,
diretoria char(11) not null
);

alter table departamentos add constraint departamentos_pk primary key (codigo);


