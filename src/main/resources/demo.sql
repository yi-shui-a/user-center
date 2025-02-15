
-- ###################
-- 创建仓库
-- ###################
DROP DATABASE IF EXISTS user_center;
CREATE DATABASE user_center
    DEFAULT CHARACTER SET = utf8mb4
    DEFAULT COLLATE = utf8mb4_unicode_ci;
USE user_center;

-- ###################
-- 创建表
-- ###################
DROP TABLE IF EXISTS `user`;

create table user (
    id bigint auto_increment primary key,
    username varchar(256) null comment '用户昵称',
    userAccount varchar(256) null comment '账号',
    avatarUrl varchar(1024) null comment'用户头像',
    gender tinyint null comment'性别',
    userPassword varchar(512) not null comment'密码',
    email varchar(512) null comment '邮箱',
    userStatus int default 0 not null comment '状态 0-正常',
    phone varchar(128) null comment '电话',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete tinyint default 0  not null comment '是否删除'
) comment'用户表';


-- ###################
-- 插入数据
-- ###################
-- 删除表中的所有记录
# DELETE FROM `user` WHERE *;

# INSERT INTO `user` (id, name, age, email) VALUES
#                   (1, 'Jone', 18, 'test1@baomidou.com'),
#                   (2, 'Jack', 20, 'test2@baomidou.com'),
#                   (3, 'Tom', 28, 'test3@baomidou.com'),
#                   (4, 'Sandy', 21, 'test4@baomidou.com'),
#                   (5, 'Billie', 24, 'test5@baomidou.com');

