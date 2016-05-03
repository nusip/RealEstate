insert into roles values(1, 'ROOT', 'Супер роль');
select setval('role_seq', 1);

insert into users values (1, 'DBB1C112A931EEB16299D9DE1F30161D', 'root', 'Системный пользователь', null, null);
select setval('user_seq', 1);

insert into users_roles values(1, 1);