create database book_library;

update mysql.user set host = '%' where user = 'root' and host = 'localhost';
flush privileges;