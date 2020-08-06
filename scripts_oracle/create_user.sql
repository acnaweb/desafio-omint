-- ROLE app
create role c##app;
grant connect, resource to c##app;
grant create session, create table, create view, create sequence, create procedure to c##app;

-- USER omni
create user c##omni identified by pwd123;
grant unlimited tablespace to c##omni;
grant c##app to c##omni;

