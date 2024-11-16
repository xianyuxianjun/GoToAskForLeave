create table sys_classes
(
    class_id   varchar(30) not null comment '班号'
        primary key,
    class_name varchar(50) null comment '班级名称',
    dep_id     varchar(30) null comment '学院编号',
    major      varchar(30) null comment '专业',
    grade      varchar(10) null comment '年级',
    inst_id    varchar(30) null comment '辅导员id',
    constraint class_id
        unique (class_id)
)
    comment '班级表';

create table sys_course
(
    course_id   varchar(30)                not null comment '课程编号'
        primary key,
    class_id    varchar(30)                null comment '班号',
    course_name varchar(255) default '50'  null comment '课程名称',
    year        varchar(30)                null comment '学年',
    term        varchar(255) default '150' null comment '学期',
    hour        int                        null comment '学时',
    constraint course_id
        unique (course_id)
)
    comment '班级课程表';

create table sys_department
(
    dep_id   varchar(255) not null comment '二级学院编号'
        primary key,
    dep_name varchar(50)  null comment '二级学院名称',
    constraint dep_id
        unique (dep_id)
)
    comment '二级学院表';

create table sys_instructor
(
    inst_id   varchar(30)               not null comment '辅导员ID'
        primary key,
    inst_name varchar(50)               null comment '辅导员名字',
    dep_id    varchar(50)               null comment '二级学院ID',
    telephone varchar(255) default '11' null comment '联系电话',
    role      varchar(255)              null,
    password  varchar(255)              null,
    email     varchar(255)              null,
    constraint inst_id
        unique (inst_id)
)
    comment '辅导员表';

create table sys_leave
(
    leave_id  varchar(30)  not null comment '请假编号'
        primary key,
    course_id varchar(30)  null comment '课程编号',
    reason    varchar(255) null comment '请假事由',
    daynum    int          null,
    status    varchar(3)   null comment '状态',
    audittime date         null comment '审核时间',
    opinion   varchar(255) null comment '审核意见',
    stu_id    varchar(30)  null,
    inst_id   varchar(30)  null,
    constraint leave_id
        unique (leave_id)
)
    comment '请假申请表';

create table sys_student
(
    stu_id      varchar(30)  not null comment '学号'
        primary key,
    class_id    varchar(30)  null comment '班号',
    stu_name    varchar(50)  null comment '姓名',
    sex         varchar(3)   null comment '性别',
    address     varchar(150) null comment '地址',
    stu_tel     varchar(11)  null comment '电话',
    contact     varchar(30)  null comment '联系人',
    contact_tel varchar(11)  null comment '联系人电话',
    password    varchar(255) null,
    role        varchar(20)  null,
    email       varchar(255) null,
    constraint stu_id
        unique (stu_id)
)
    comment '学生表';

create table sys_user
(
    userid    varchar(30)  not null
        primary key,
    fullname  varchar(50)  null comment '姓名',
    password  varchar(50)  null comment '密码',
    telephone varchar(11)  null comment '手机号',
    emali     varchar(255) not null comment '邮箱',
    role      varchar(25)  null,
    constraint userid
        unique (userid)
)
    comment '管理员表';

