USE college_db;
GO

SELECT * FROM STUDENTS
WHERE age > 21;

SELECT * FROM STUDENTS
WHERE active_flag = 1;

SELECT * FROM COURSES
WHERE fees BETWEEN 1000 AND 5000;

SELECT * FROM STUDENTS
WHERE age IN (20, 22, 25);

SELECT * FROM STUDENTS
WHERE age > 20 AND active_flag = 1;

SELECT * FROM STUDENTS
WHERE age < 20 OR active_flag = 0;

SELECT * FROM COURSES
WHERE fees > 2000
  AND course_name LIKE '%Data%';

SELECT * FROM STUDENTS
WHERE email LIKE '%gmail.com';

SELECT * FROM COURSES
WHERE course_name LIKE 'Data%';


INSERT INTO STUDENTS (student_id, name, email, age, join_date, active_flag)
VALUES (14, 'Rakesh Malhotra', 'rakesh.m@gmail.com', NULL, '2023-11-01', 1);

SELECT * FROM STUDENTS
WHERE age IS NULL;

SELECT * FROM STUDENTS
WHERE age IS NOT NULL;
GO
