CREATE DATABASE organisational;
\c organisation;

CREATE TABLE users(id serial PRIMARY KEY, name varchar, position varchar, role varchar, departmentid int);

CREATE TABLE news(id serial PRIMARY KEY, title varchar, content varchar, departmentid int);

CREATE TABLE departments(id serial PRIMARY KEY, name varchar, description varchar);

CREATE DATABASE organisational_test WITH TEMPLATE organisational;