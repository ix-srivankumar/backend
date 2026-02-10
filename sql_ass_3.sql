----------------------------------------TASK-1--------------------------------------------------------------------------

create table customers ( 
id int identity(1,1) primary key,
name varchar (100) not null,
email varchar (200) not null unique,
phone varchar(15),
created_at datetime default getdate(),
is_active bit default 1

)

select * from customers;


create table orders ( 
order_id int identity(1001,1) primary key,
customer_id int not null,
order_date date not null,
order_status varchar(50) default 'PENDING',
payment_mode varchar(50) ,
amount decimal(10,2) not null,
created_at date default getdate(),

constraint fk_orders_customers foreign key (customer_id) references customers(id)
);




insert into customers (name,email,phone,is_active) 
values('sathwik reddy','sathwik12@gmail.com','+91 8639828321',1),
('Ravi Kumar', 'ravi@gmail.com', '9876543210',1),
('Anita Sharma', 'anita@gmail.com', '9123456789',1);


insert into customers (name,email,phone,is_active)
values('ananya sharma','ananya.sharma@gmail.com','+91 9876543210',1);

insert into customers (name,email,phone,is_active)
values('rahul verma','rahul.verma@yahoo.com','+91 9123456789',0);

insert into customers (name,email,phone,is_active)
values('priya singh','priya.singh@hotmail.com','+91 9988776655',1);

insert into customers (name,email,phone,is_active)
values('arjun mehta','arjun.mehta@gmail.com','+91 9765432109',1);

insert into customers (name,email,phone,is_active)
values('neha kapoor','neha.kapoor@outlook.com','+91 9345678901',0);


insert into orders (customer_id,order_date,order_status,payment_mode,amount) values(1,'2026-02-05','ACCEPTED','UPI',290000.78);

INSERT INTO orders (customer_id, order_date, payment_mode, amount)
VALUES
(1, '2024-02-01', 'UPI', 2500.00),
(2, '2024-02-02', 'CARD', 1800.00);


CREATE TABLE students(
student_id int identity(2001,1) primary key,
student_name varchar(100) not null,
email varchar(150) unique,
department varchar(100),
admission_year int,
is_active bit default 1
);




create table courses ( 
course_id int identity(3001,1) primary key,
course_name varchar(100) not null,
credits int,
duration_months int,
course_fee decimal(10,2),
is_available bit default 1
);




 
create table students_courses(
enrollment_id int identity(4001,1) primary key,
student_id int not null,
course_id int not null,
enrolled_date date default getdate(),
grade varchar(5),

constraint fk_stcr_std foreign key (student_id) references students(student_id),
constraint fk_stcr_crs foreign key (course_id)  references courses(course_id),
constraint uq_stcr unique (student_id,course_id)
);




INSERT INTO students (student_name, email, department, admission_year)
VALUES
('Rahul', 'rahul@gmail.com', 'CSE', 2022),
('Sneha', 'sneha@gmail.com', 'IT', 2023);

INSERT INTO courses (course_name, credits, duration_months, course_fee)
VALUES
('DBMS', 4, 6, 15000),
('Operating Systems', 4, 6, 16000);




INSERT INTO students_courses (student_id, course_id, grade)
VALUES
(2001, 3001, 'A'),
(2002, 3002, 'B');




ALTER TABLE customers
ADD city VARCHAR(100);




----------------------------------------TASK-2--------------------------------------------------------------------------



CREATE TABLE departments (
    dept_id INT IDENTITY(5000,1) PRIMARY KEY,
    dept_name VARCHAR(100) NOT NULL UNIQUE,
    location VARCHAR(100),
    created_at DATETIME DEFAULT GETDATE(),
    is_active BIT DEFAULT 1
);

CREATE TABLE employees (
    emp_id INT IDENTITY(6000,1) PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(15),
    dept_id INT NOT NULL,
    designation VARCHAR(50),
    salary DECIMAL(10,2),
    hire_date DATE DEFAULT GETDATE(),
    is_active BIT DEFAULT 1,

    CONSTRAINT fk_emp_dept
    FOREIGN KEY (dept_id)
    REFERENCES departments(dept_id)
);


CREATE TABLE products (
    product_id INT IDENTITY(7000,1) PRIMARY KEY,
    product_name VARCHAR(150) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT DEFAULT 0,
    is_active BIT DEFAULT 1,
    created_at DATETIME DEFAULT GETDATE()
);


CREATE TABLE order_items (
    item_id INT IDENTITY(8000,1) PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    price_at_order DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_oi_order
    FOREIGN KEY (order_id)
    REFERENCES orders(order_id),

    CONSTRAINT fk_oi_product
    FOREIGN KEY (product_id)
    REFERENCES products(product_id),

    CONSTRAINT uq_order_product
    UNIQUE (order_id, product_id)
);








INSERT INTO departments (dept_name, location)
VALUES
('IT', 'Hyderabad'),
('HR', 'Bangalore'),
('Finance', 'Mumbai'),
('Marketing', 'Delhi'),
('Operations', 'Chennai');

INSERT INTO employees (emp_name, email, phone, dept_id, designation, salary)
VALUES
('Ravi Kumar', 'ravi.kumar@example.com', '9876543210', 5001, 'Software Engineer', 60000.00),
('Anita Sharma', 'anita.sharma@example.com', '9123456780', 5002, 'HR Manager', 55000.00),
('Suresh Reddy', 'suresh.reddy@example.com', '9988776655', 5003, 'Accountant', 50000.00),
('Priya Mehta', 'priya.mehta@example.com', '9112233445', 5004, 'Marketing Executive', 45000.00),
('Arjun Singh', 'arjun.singh@example.com', '9001122334', 5000, 'Operations Analyst', 48000.00);

INSERT INTO products (product_name, category, price, stock_quantity)
VALUES
('Laptop', 'Electronics', 55000.00, 10),
('Smartphone', 'Electronics', 25000.00, 25),
('Office Chair', 'Furniture', 7000.00, 15),
('Desk Lamp', 'Home Decor', 1200.00, 50),
('Headphones', 'Accessories', 3000.00, 30);


INSERT INTO order_items (order_id, product_id, quantity, price_at_order)
VALUES
(1001, 7001, 1, 55000.00),   -- Order 1: Laptop
(1002, 7002, 2, 25000.00),   -- Order 2: Smartphones
(1003, 7003, 1, 7000.00),    -- Order 3: Office Chair
(1001, 7004, 3, 1200.00),    -- Order 4: Desk Lamps
(1002, 7000, 2, 3000.00);    -- Order 5: Headphones




SELECT C.*,O.* FROM customers C  inner join orders O on C.id = O.customer_id;


select C.name,C.city from orders O inner join customers C on O.customer_id=C.id;


select e.*, d.* from employees e inner join departments d on e.dept_id = d.dept_id;


select o.order_id,p.product_id,p.product_name,oi.quantity as ordered_quantity,o.order_status,o.payment_mode,
oi.price_at_order as product_price_as_qty,o.amount as total_amount from orders o inner join 
order_items oi on o.order_id = oi.order_id inner join products p on oi.product_id=p.product_id;


SELECT
    c.name,
    c.city,
    o.order_id,
    o.order_date,
    o.amount,
    o.order_status,
	o.payment_mode,
	o.created_at
FROM customers c
INNER JOIN orders o
    ON c.id = o.customer_id;


select c.id as customer_id,o.order_id,c.name,c.city,o.order_status,o.payment_mode,o.order_date,o.order_date, o.amount
 from customers c inner join orders o on c.id=o.customer_id where o.amount>10000; 


select c.id as customer_id,o.order_id,c.name,c.city,o.order_status,o.payment_mode,o.order_date,o.order_date, o.amount
 from customers c inner join orders o on c.id=o.customer_id where c.city like '%hyd%'; 









 ----------------------------------------TASK-3------------------------------------------------------



select c.*,o.* from customers c left join orders o on c.id=o.customer_id;

select c.*,o.* from customers c left join orders o on c.id=o.customer_id where o.order_id IS NULL;

select d.*,e.* from departments d left join employees e on d.dept_id=e.dept_id;

select d.*,e.* from departments d left join employees e on d.dept_id=e.dept_id where e.emp_id IS NULL;

SELECT p.product_id,p.product_name FROM products p LEFT JOIN order_items oi ON p.product_id = oi.product_id WHERE oi.product_id IS NULL;

select c.id as customer_id,o.order_id,c.name,c.city,o.order_status,o.payment_mode,o.order_date,o.order_date, o.amount
 from customers c left join orders o on c.id=o.customer_id and o.amount>10000; 


select c.id as customer_id,o.order_id,c.name,c.city,o.order_status,o.payment_mode,o.order_date,o.order_date, o.amount
 from customers c left join orders o on c.id=o.customer_id and c.city like '%hyd%'; 









 -----------------------------------------------------------TASK-4-------------------------------------------------------------------------------------



select o.order_id,o.customer_id,c.name,c.email,c.phone,o.order_date,o.order_status,o.payment_mode,o.amount,c.created_at from customers c
right join orders o on c.id=o.customer_id;

select o.order_id,o.customer_id,c.name,c.email,c.phone,o.order_date,o.order_status,o.payment_mode,o.amount
FROM customers c RIGHT JOIN orders o ON c.id = o.customer_id WHERE c.id IS NULL;

select d.dept_id, d.dept_name, e.emp_id, e.emp_name, e.designation from employees e right join departments d on e.dept_id=d.dept_id ;


select d.dept_id, d.dept_name, e.emp_id, e.emp_name, e.designation,e.salary from employees e right join departments d on e.dept_id=d.dept_id and e.salary>45000;

SELECT c.id, c.name, COUNT(o.order_id) AS total_orders FROM orders o RIGHT JOIN customers c ON o.customer_id = c.id GROUP BY c.id, c.name;











------------------------------------------------------------TASK-5------------------------------------------------------------------------

SELECT c.id, c.name, o.order_id, o.amount FROM customers c FULL OUTER JOIN orders o ON c.id = o.customer_id;


SELECT c.id, c.name, o.order_id, o.amount FROM customers c LEFT JOIN orders o ON c.id = o.customer_id
UNION
SELECT c.id, c.name, o.order_id, o.amount FROM customers c RIGHT JOIN orders o ON c.id = o.customer_id;


SELECT e.*,d.* from employees e full outer join departments d on e.dept_id=d.dept_id;


SELECT d.dept_id, d.dept_name, e.emp_id, e.emp_name FROM departments d LEFT JOIN employees e ON d.dept_id = e.dept_id
UNION
SELECT d.dept_id, d.dept_name, e.emp_id, e.emp_name FROM departments d RIGHT JOIN employees e ON d.dept_id = e.dept_id;











------------------------------------------------------TASK-6-----------------------------------------------------------


ALTER TABLE employees
ADD manager_id INT NULL;

ALTER TABLE employees
ADD CONSTRAINT fk_employee_manager
FOREIGN KEY (manager_id)
REFERENCES employees(emp_id);



SELECT e.emp_id, e.emp_name AS employee_name, m.emp_name AS manager_name
FROM employees e LEFT JOIN employees m ON e.manager_id = m.emp_id;


SELECT m.emp_name AS manager_name, e.emp_name AS employee_name 
FROM employees e INNER JOIN employees m ON e.manager_id = m.emp_id ORDER BY manager_name;


select m.emp_id, m.emp_name as manager_name from employees e join employees m on e.emp_id = m.manager_id;


SELECT e.emp_name AS employee, m.emp_name AS mentor FROM employees e LEFT JOIN employees m ON e.emp_id = m.manager_id;


select m.emp_name as manager,e.emp_name as employee from employees e join employees m on e.emp_id=m.manager_id ;




	


	


----------------------------------------------------------TASK-7-----------------------------------------------------------


select c.*, p.* from customers c cross join products p;

select e.emp_id,e.emp_name,e.phone,e.dept_id,e.salary,e.hire_date,r.designation from employees e cross join (select distinct designation from employees) r;

select c.*, p.* from students c cross join courses p;






----------------------------------------------------------TASK-8---------------------------------------------------------------


select c.*,o.*,oi.* from customers c join orders o on c.id=o.customer_id join order_items oi on o.order_id=oi.order_id;

select c.*,o.*,oi.* from products c join order_items o on c.product_id=o.product_id join orders oi on o.order_id=oi.order_id;

select c.*,o.* from departments c join employees o on c.dept_id=o.dept_id;

select c.*,o.*,oi.*,p.* from customers c join orders o on c.id=o.customer_id 
join order_items oi on o.order_id=oi.order_id join products p on oi.product_id=p.product_id ;








----------------------------------------------------------TASK-9---------------------------------------------------------------


select c.id, c.name, count(o.order_id) as order_count from
customers c left join orders o on c.id = o.customer_id group by c.id, c.name;

select c.id,c.name,sum(o.amount) as total_amount from 
customers c left join orders o on c.id=o.customer_id group by c.id,c.name;

select d.dept_id, d.dept_name, count(e.emp_id) as total_employees from 
departments d left join employees e on d.dept_id=e.dept_id group by d.dept_id,d.dept_name;

select p.product_id,p.product_name, count(o.item_id) as orderd_times from 
products p left join order_items o on p.product_id=o.product_id group by p.product_id,p.product_name;

select d.dept_id,d.dept_name,sum(e.salary) as dept_salaries from 
departments d left join employees e on d.dept_id =e.dept_id group by d.dept_id,d.dept_name;










----------------------------------------------------------TASK-10---------------------------------------------------------------


select c.id,c.name, count(o.order_id) from customers c join 
orders o on c.id=o.customer_id group by c.id,c.name having count(o.order_id)>3;


select d.dept_id,d.dept_name,count(e.emp_id) from departments d  join employees e on d.dept_id=e.dept_id group by d.dept_id,d.dept_name
 having count(e.emp_id)>5;

select p.product_id,p.product_name, count(o.item_id) as orderd_times from products p 
join order_items o on p.product_id=o.product_id group by p.product_id,p.product_name having count(o.item_id)>10;


select c.id,c.name,count(o.order_id) as total_orders from customers c 
join orders o on c.id=o.customer_id group by c.id,c.name having count(o.order_id)>4;








----------------------------------------------------------TASK-11---------------------------------------------------------------

select c.id, c.name, count(o.order_id) as order_count 
from customers c left join orders o on c.id = o.customer_id group by c.id, c.name;

select d.dept_id, d.dept_name, count(e.emp_id) as employee_count 
from departments d left join employees e on d.dept_id = e.dept_id group by d.dept_id, d.dept_name;

select p.category, count(p.product_id) as product_count 
from products p group by p.category;

select c.city, count(o.order_id) as order_count 
from customers c left join orders o on c.id = o.customer_id group by c.city;






----------------------------------------------------------TASK-12---------------------------------------------------------------



select o.order_id, o.order_date, o.amount, c.name as customer_name, c.city 
from orders o inner join customers c on o.customer_id = c.id where o.order_date > '2024-01-01';

select e.emp_id, e.emp_name, e.salary, d.dept_name 
from employees e inner join departments d on e.dept_id = d.dept_id where d.dept_name = 'IT';

select c.id, c.name, c.city, o.order_id, o.amount 
from customers c inner join orders o on c.id = o.customer_id where c.city = 'Hyderabad';

select p.product_id, p.product_name, p.price, o.order_id, oi.quantity from products p inner join order_items oi
on p.product_id = oi.product_id inner join orders o on oi.order_id = o.order_id where p.price > 5000;








----------------------------------------------------------TASK-13---------------------------------------------------------------


select c.id, c.name, c.city, o.order_id, o.amount 
from customers c inner join orders o on c.id = o.customer_id where c.name like 'R%';

select e.emp_id, e.emp_name, e.salary, d.dept_name 
from employees e inner join departments d on e.dept_id = d.dept_id where e.emp_name like '%ra%';

select p.product_id, p.product_name, p.category, p.price, o.order_id, oi.quantity from products p 
join order_items oi on p.product_id = oi.product_id join orders o on oi.order_id = o.order_id where p.product_name like 'Lap%';








----------------------------------------------------------TASK-14---------------------------------------------------------------

select * from customers
where id in (select customer_id from orders);

select * from customers
where id not in (select customer_id from orders);

select * from products
where product_id not in (select product_id from order_items);

select * from employees
where dept_id not in (select dept_id from departments);

select * from orders
where amount > (select avg(amount) from orders);

select distinct c.id, c.name from customers c
join orders o on c.id = o.customer_id where o.amount > (select avg(amount) from orders);

select e.emp_id, e.emp_name, e.salary, d.dept_name from employees e join departments d 
on e.dept_id = d.dept_id where e.salary > (select avg(e2.salary) from employees e2 where e2.dept_id = e.dept_id);

select * from departments
where dept_id in (select distinct emp_id from employees where is_active = 1);

select * from customers
where id not in (select customer_id from orders where order_status = 'cancelled');

select c.name, o.order_id, o.amount from customers c
join orders o on c.id = o.customer_id and o.amount > (select avg(amount) from orders);

select c.name, avg_orders.avg_amount from customers c join 
(select customer_id, avg(amount) as avg_amount from orders group by customer_id) avg_orders on c.id = avg_orders.customer_id;

select * from customers c
where exists (select 1 from orders o where o.customer_id = c.id);

select * from customers c
where not exists (select 1 from orders o where o.customer_id = c.id);

select e.emp_name, e.salary, d.dept_name from employees e
join departments d on e.dept_id = d.dept_id where e.salary = (select max(e2.salary) from employees e2 where e2.dept_id = e.dept_id);

select p.product_name, sales.total_qty from products p
join (select product_id, sum(quantity) as total_qty from order_items group by product_id) sales on p.product_id = sales.product_id;









----------------------------------------------------------TASK-15-------------------------------------------------------------------

select c.id, c.name, c.city, o.order_id, o.order_date, o.amount, o.order_status from customers c
inner join orders o on c.id = o.customer_id;

select c.name as customer_name, c.city as customer_city, o.order_id as order_number, o.amount as order_value from customers c
join orders o on c.id = o.customer_id;

select c.name, o.order_id, o.amount, (o.amount * 0.10) as tax_amount, (o.amount + (o.amount * 0.10)) as final_amount from customers c
join orders o on c.id = o.customer_id;


select c.name, o.order_id, o.amount, 
case 
when o.amount >= 5000 then 'high value' 
when o.amount >= 2000 then 'medium value' 
else 'low value' 
end as order_category
from customers c
join orders o on c.id = o.customer_id;