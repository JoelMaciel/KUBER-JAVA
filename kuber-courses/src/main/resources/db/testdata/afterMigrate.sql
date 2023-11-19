
set foreign_key_checks = 0;

delete from courses;

set foreign_key_checks = 1;

INSERT INTO courses (id, name, creation_date, update_date) VALUES
(1, 'Introduction to Programming', '2023-01-01 00:00:00', '2023-01-01 00:00:00'),
(2, 'Advanced Database Concepts', '2023-01-02 00:00:00', '2023-01-02 00:00:00'),
(3, 'Web Development Fundamentals', '2023-01-03 00:00:00', '2023-01-03 00:00:00');
