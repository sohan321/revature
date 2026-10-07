CREATE TABLE record_logs(log_id SERIAL PRIMARY KEY,
                                       record_id INT, field_changed TEXT, last_update TIMESTAMP, old_value TEXT, new_value TEXT);


CREATE OR REPLACE FUNCTION log_customer_changes() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.email IS DISTINCT FROM OLD.email THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'email', NOW(), OLD.email, NEW.email);
    END IF;

    IF NEW.phone IS DISTINCT FROM OLD.phone THEN
        INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
        VALUES (OLD.customer_id, 'phone', NOW(), OLD.phone, NEW.phone);
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER record_change AFTER
UPDATE ON customer
FOR EACH ROW EXECUTE FUNCTION log_customer_changes();


UPDATE customer
SET email = 'newemail@test.com'
WHERE customer_id = 1;


SELECT *
FROM record_logs;