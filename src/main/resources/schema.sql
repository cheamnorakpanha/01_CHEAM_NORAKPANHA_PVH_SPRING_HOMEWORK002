CREATE TABLE IF NOT EXISTS students (
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS instructors
(
    instructor_id   SERIAL PRIMARY KEY,
    instructor_name VARCHAR(100) NOT NULL,
    email           VARCHAR(100) NOT NULL UNIQUE
);