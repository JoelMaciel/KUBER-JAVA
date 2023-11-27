
set foreign_key_checks = 0;

delete from courses;
delete from users;
delete from courses_users ;

set foreign_key_checks = 1;

INSERT INTO courses (course_id, name, creation_date, update_date) VALUES
('ba538ee6-b7fb-45e4-8308-7799c4205008', 'Introduction to Programming', '2023-01-01 00:00:00', '2023-02-18 05:15:40'),
('c6baa326-e9ee-4a82-83cc-39d7f41e7777', 'Advanced Database Concepts', '2023-01-02 00:00:00', '2023-05-15 22:20:15'),
('8e895fb5-472d-4eeb-9d98-f3de711646ea', 'Web Development Fundamentals', '2023-01-03 00:00:00', '2023-10-24 09:10:35');


INSERT INTO users (user_id, name, email, password) VALUES
('a0d3e124-f5b8-4c4c-aeb1-d08b3f916c4a', 'Alice Johnson', 'alice.johnson@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6'),
('5e8f8b9e-3cf5-4b1f-9d0b-5c4fae5b9c78', 'Bob Smith', 'bob.smith@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6'),
('7e2b3c4d-2e5f-4d1c-ae25-6e9f8b7c9d10', 'Carol Williams', 'carol.williams@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6');
