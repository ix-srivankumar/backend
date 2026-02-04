CREATE DATABASE college_db;


USE college_db;


CREATE TABLE STUDENTS (
    student_id BIGINT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(150) UNIQUE,
    age INT,
    join_date DATE,
    active_flag BIT DEFAULT 1
);
GO


CREATE TABLE COURSES (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    fees DECIMAL(10,2)
);
GO

CREATE TABLE ENROLLMENTS (
    enroll_id BIGINT PRIMARY KEY,
    student_id BIGINT,
    course_id INT,
    enroll_timestamp DATETIME2,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES STUDENTS(student_id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES COURSES(course_id)
);
GO


