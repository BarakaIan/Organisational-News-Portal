# Organisational Api
#### Java Application for creating a function api for departments, users and news, December 14 2020
#### By **Kamana Izere Emile**
## Description
Organisational api is an application that uses restful routing to create an api that provides access to our apps' users, departments, and news posts. you are able to get and post new information but there is no front end provided and everything is in JSON format.
## Setup/Installation Requirements
* Internet connection
* access to a browser
* fork from https://github.com/emile067/oraganisational-news-portal
## In PSQL:
* CREATE DATABASE organisational;
* \c organisational;
* CREATE TABLE users(id serial PRIMARY KEY, name varchar, bio varchar, position varchar, role varchar, departmentid int);
* CREATE TABLE news(id serial PRIMARY KEY, title varchar, content varchar, departmentid int);
* CREATE TABLE departments(id serial PRIMARY KEY, name varchar, bio varchar);
* CREATE DATABASE organisational_test WITH TEMPLATE organisational;
## Known Bugs
None so far.
## Technologies Used
* IntelliJ IDEA
* Java
* Spark
* PostgreSql
## Support and contact details
If you have any questions reach out to me on [emileizere@gmail.com]
### License
Licensed by MIT
Copyright (c) 2020 **Kamana Izere Emile**