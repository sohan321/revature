/* 1.
SELECT i.invoice_id, c.first_name, c.last_name, i.total
FROM invoice i
INNER JOIN customer c
ON i.customer_id = c.customer_id
*/ /* 2.
SELECT i.invoice_id, c.first_name, i.total
FROM invoice i
INNER JOIN customer c
ON i.customer_id = c.customer_id
WHERE total > 30
*/ /* 3.
WITH us_customers AS (
    SELECT customer_id
    FROM customer
    WHERE country ='USA'
)
SELECT *
FROM invoice
WHERE invoice_date > NOW() -INTERVAL '6 months' AND customer_id IN  (SELECT customer_id FROM us_customers)
*/