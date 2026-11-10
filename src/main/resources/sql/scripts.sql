create table users
(
    username varchar(50)  not null primary key,
    password varchar(500) not null,
    enabled  boolean      not null
);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities (username, authority);

insert into users (username, password, enabled) values ('user', '{noop}753357', '1');
insert into authorities (username, authority) values ('user', 'read');

insert into users (username, password, enabled) values ('admin', '{bcrypt}$2a$12$py9GQUK6FsO7lQO9c4Fp6efFfNY4swoFNBpO1H3eIfx3kZa2l.4Ee', '1');
insert into authorities (username, authority) values ('admin', 'admin');