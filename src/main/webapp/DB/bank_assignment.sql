CREATE DATABASE IF NOT EXISTS assignment0704;
USE assignment0704;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS seating_chart;

CREATE TABLE seating_chart(
	floor_seat_seq VARCHAR(10) GENERATED ALWAYS AS (CONCAT(floor_no,'-',seat_no)) STORED,
    floor_no INT,
    seat_no INT,
    CONSTRAINT seating_chart_primary_key PRIMARY KEY (floor_seat_seq)
);

INSERT INTO seating_chart (floor_no, seat_no) VALUES (1,1);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (1,2);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (1,3);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (1,4);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (2,1);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (2,2);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (2,3);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (2,4);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (3,1);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (3,2);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (3,3);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (3,4);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (4,1);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (4,2);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (4,3);
INSERT INTO seating_chart (floor_no, seat_no) VALUES (4,4);

DROP PROCEDURE IF EXISTS get_all_seat;
DELIMITER //
CREATE PROCEDURE get_all_seat()
BEGIN
    SELECT * FROM seating_chart ORDER BY floor_no ASC, seat_no ASC;
END //
DELIMITER ;



CREATE TABLE employee(
	emp_id INT,
    name VARCHAR(50),
    email VARCHAR(254),
    floor_seat_seq VARCHAR(10) UNIQUE,
    CONSTRAINT employee_primary_key PRIMARY KEY (emp_id),
    CONSTRAINT employee_id_six_digit CHECK (emp_id BETWEEN 9999 AND 100000),
    FOREIGN KEY (floor_seat_seq) REFERENCES seating_chart (floor_seat_seq)
);

INSERT INTO employee (emp_id,floor_seat_seq) VALUES (12006,'1-3');
INSERT INTO employee (emp_id,floor_seat_seq) VALUES (16142,'2-3');
INSERT INTO employee (emp_id,floor_seat_seq) VALUES (13040,'3-1');
INSERT INTO employee (emp_id,floor_seat_seq) VALUES (17081,'3-2');
INSERT INTO employee (emp_id,floor_seat_seq) VALUES (11221,'3-4');
INSERT INTO employee (emp_id,floor_seat_seq) VALUES (16722,'4-3');

DROP PROCEDURE IF EXISTS get_all_employee;
DELIMITER //
CREATE PROCEDURE get_all_employee()
BEGIN
    SELECT * FROM employee ORDER BY emp_id ASC;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS remove_employee_seat;
DELIMITER //
CREATE PROCEDURE remove_employee_seat(IN floorseatseq VARCHAR(10))
BEGIN
    UPDATE employee SET floor_seat_seq = null WHERE floor_seat_seq = floorseatseq;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS set_employee_seat;
DELIMITER //
CREATE PROCEDURE set_employee_seat(IN empid INT, IN floorseatseq VARCHAR(10))
BEGIN
    UPDATE employee SET floor_seat_seq = floorseatseq WHERE emp_id = empid;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS clean_seat_if_occupied;
DELIMITER //
CREATE PROCEDURE clean_seat_if_occupied(IN floorseatseq VARCHAR(10))
BEGIN
    UPDATE employee SET floor_seat_seq = null WHERE floor_seat_seq = floorseatseq;
END //
DELIMITER ;

SELECT * FROM employee;
SELECT * FROM seating_chart;
