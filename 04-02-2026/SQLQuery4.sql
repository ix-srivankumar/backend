USE college_db;
GO

SELECT COUNT(*) AS total_students FROM STUDENTS;

SELECT COUNT(*) AS active_students
FROM STUDENTS
WHERE active_flag = 1;

SELECT SUM(fees) AS total_course_fees FROM COURSES;

SELECT AVG(fees) AS average_course_fee FROM COURSES;

SELECT SUM(fees) AS sum_fees_above_2000
FROM COURSES
WHERE fees > 2000;

SELECT MIN(age) AS minimum_student_age FROM STUDENTS;

SELECT MAX(fees) AS maximum_course_fee FROM COURSES;

SELECT MAX(registration_date) AS latest_join_date FROM STUDENTS;

SELECT MIN(registration_date) AS oldest_join_date FROM STUDENTS;

SELECT active_flag, COUNT(*) AS student_count
FROM STUDENTS
GROUP BY active_flag;

SELECT age, COUNT(*) AS student_count
FROM STUDENTS
GROUP BY age;

SELECT c.course_name, SUM(c.fees) AS total_fees
FROM COURSES c
GROUP BY c.course_name;

SELECT course_id, COUNT(*) AS enroll_count
FROM ENROLLMENTS
GROUP BY course_id
HAVING COUNT(*) > 3;

SELECT age
FROM STUDENTS
GROUP BY age
HAVING AVG(age) > 21;

SELECT course_id, COUNT(*) AS total_enrollments
FROM ENROLLMENTS
GROUP BY course_id
HAVING COUNT(*) > 2;
GO
