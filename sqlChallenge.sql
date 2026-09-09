--1. SELECT * FROM customer
--2. SELECT * FROM customer WHERE state ='AZ'
--3. SELECT * FROM invoice WHERE invoice_date < NOW() -INTERVAL '6 months'
--4. UPDATE customer SET phone = NULL WHERE phone !~ '^\+1 \(\d{3}\) \d{3}-\d{4}$'
--5. SELECT name FROM track WHERE milliseconds > 180000
--6. UPDATE customer SET address = NULL, city = NULL, state = NULL, country='USA' WHERE country != 'USA'
/* 7.
CREATE OR REPLACE FUNCTION find_total(a INT) RETURNS NUMERIC AS $$
BEGIN
    RETURN (
    SELECT SUM(total) AS total_spending
    FROM invoice
    WHERE a = customer_id
    );
END;
$$ LANGUAGE plpgsql;

SELECT find_total(1);
*/ /* 8.
CREATE PROCEDURE new_manager(employee_id_old int,manager_id int) LANGUAGE plpgsql AS $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM employee WHERE employee_id = manager_id)
    THEN
        RAISE EXCEPTION 'Manager % does not exist', manager_id;
    END IF;
    IF employee_id_old = manager_id
    THEN
        RAISE EXCEPTION 'An employee cannot report to themselves (id %)', employee_id_old;
    END IF;
    IF EXISTS (
        SELECT 1 FROM employee
        WHERE employee_id =manager_id AND reports_to = employee_id_old
    ) THEN
        RAISE EXCEPTION 'Circular: % already reports to %', manager_id, employee_id_old;
    END IF;
    UPDATE employee SET reports_to = manager_id
    WHERE employee_id = employee_id_old;
END;
$$;

CALL new_manager(5,4)
*/ /* 9.
CREATE SCHEMA pets;
CREATE TABLE pets.Customer(
    Customer_id INT PRIMARY KEY,
    Email TEXT NOT NULL UNIQUE,
    First_Name TEXT NOT NULL,
    Last_Name TEXT NOT NULL
);

CREATE TABLE pets.Pets(
    Pet_id INT PRIMARY KEY,
    Customer_id INT NOT NULL REFERENCES pets.Customer(Customer_id)
);

INSERT INTO pets.Customer (Customer_id, Email, First_Name, Last_Name)
VALUES
    (1, 'Sohan@x.com',   'Sohan',   'Shrestha'),
    (2, 'John@x.com',  'John',  'Doe'),
    (3, 'Janeace@x.com', 'Jane', 'Doe');
SELECT * FROM customer

INSERT INTO pets.Pets (Pet_id, Customer_id)
VALUES
    (100,1),
    (150,2),
    (3,3),
    (200,1);
SELECT * FROM Pets
*/