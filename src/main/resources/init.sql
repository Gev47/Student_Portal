DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS homework;
DROP TABLE IF EXISTS teacher CASCADE;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS subject CASCADE;

CREATE TABLE IF NOT EXISTS student (
    id SERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS teacher (
    id SERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    phoneNumber TEXT,
    department TEXT
);

CREATE TABLE IF NOT EXISTS subject (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    credits INTEGER
);

CREATE TABLE IF NOT EXISTS homework (
    id SERIAL PRIMARY KEY,
    subject_id INTEGER REFERENCES subject(id),
    title TEXT NOT NULL,
    description TEXT,
    due_date TIMESTAMP NOT NULL,
    assigned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS schedule (

    id SERIAL PRIMARY KEY,
    start_time TIME NOT NULL,
    day_of_week TEXT CHECK (day_of_week IN ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday')),
    subject_id INTEGER REFERENCES subject(id),
    room TEXT,
    end_time TIME NOT NULL
);

INSERT INTO student (firstName, lastName, email, password) VALUES
    ('Alice', 'Johnson', 'alice@example.com', 'pass123'),
    ('Bob', 'Smith', 'bob@example.com', 'secret456'),
    ('Charlie', 'Kim', 'charlie@example.com', 'mypassword');

INSERT INTO teacher (firstName, lastName, email, phoneNumber, department) VALUES
    ('Emily', 'Stone', 'estone@school.edu', '123-456-7890', 'Mathematics'),
    ('David', 'Lee', 'dlee@school.edu', '234-567-8901', 'Computer Science'),
    ('Laura', 'Brown', 'lbrown@school.edu', '345-678-9012', 'Literature');


INSERT INTO subject (name, credits) VALUES
     ('Algebra I', 3),
     ('Java Programming', 4),
     ('English Literature', 2);

INSERT INTO schedule (subject_id, room, day_of_week, start_time, end_time) VALUES
     (1, 'Room 101', 'Monday', '09:00', '10:30'),
     (2, 'Room 202', 'Tuesday', '11:00', '12:30'),
     (3, 'Room 303', 'Wednesday', '13:00', '14:30'),
     (2, 'Room 202', 'Thursday', '11:00', '12:30');

INSERT INTO homework (subject_id, title, description, due_date) VALUES
     (1, 'Algebra Worksheet 1', 'Solve 20 problems from chapter 2', '2025-04-10 23:59'),
     (2, 'Java Project', 'Create a simple console-based banking app', '2025-04-12 23:59');

