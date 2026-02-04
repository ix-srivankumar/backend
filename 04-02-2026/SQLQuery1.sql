
use college_db;


create table students (
    student_id numeric primary key,
    name text,
    email text ,
    age text,
    join_date date,
    active_flag bit default 1
);

create table courses (
    course_id numeric primary key,
    course_name text not null,
    fees decimal(10,2)
);

create table enrollments (
    enroll_id numeric primary key,
    student_id numeric,
    course_id numeric,
    enroll_timestamp timestamp,
    foreign key (student_id) references students(student_id),
    foreign key (course_id) references courses(course_id)
);
