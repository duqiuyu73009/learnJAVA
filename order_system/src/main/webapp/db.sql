drop database if exists order_system;
create database order_system;
use order_system;

drop table if exists dishes;
create table dishes(
    dishId int primary key auto_increment,
    name varchar(50),
    price int --以分作为单位，使用int表示
);

drop table if exists user;
create table user(
    userId int primary key auto_increment,
    name varchar(50) unique,
    password varchar(50),
    isAdmin int --1表示管理员，0表示不是管理员
);

drop table if exists order_user;
create table order_user(
    orderId int primary key auto_increment,
    userId int, --这个用户id需要和user表中的userId具有关联关系
    time datetime,--下单时间
    isDone int, --1表示订单完成，0表示订单未完成
    foreign key(userId) references user(userId)
);


drop table if exists order_dish;
create table order_dish(
   orderId int, --orderId也和order_user 表中的orderId字段有外键关联关系
   dishId int,--dishId也和dishes表中的dishId存在外键关系
   foreign key(orderId) references order_user(orderId),
   foreign key(dishId) references dishes(dishId)
);


