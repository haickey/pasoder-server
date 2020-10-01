create table password_unit
(
    password_unit_id bigint auto_increment primary key,
    ip               varchar(15)  not null default '0.0.0.0',
    name             varchar(50)  not null,
    password         varchar(800) not null,
    description      varchar(120) null,
    create_time      timestamp(6) null     default CURRENT_TIMESTAMP(6),
    update_time      timestamp(6) null     default CURRENT_TIMESTAMP(6) on update CURRENT_TIMESTAMP(6)
);
create index unq_password_unit on password_unit (ip, name);



