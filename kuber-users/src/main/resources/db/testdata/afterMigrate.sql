
set foreign_key_checks = 0;

delete from users;

set foreign_key_checks = 1;

INSERT INTO users (user_id, name, email, password, creation_date, update_date) VALUES
('a0d3e124-f5b8-4c4c-aeb1-d08b3f916c4a', 'John Doe', 'john.doe@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6', '2023-01-01 00:00:00', '2023-01-01 00:00:00'),
('5e8f8b9e-3cf5-4b1f-9d0b-5c4fae5b9c78', 'Jane Smith', 'jane.smith@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6' , '2023-01-02 00:00:00', '2023-01-02 00:00:00'),
('7e2b3c4d-2e5f-4d1c-ae25-6e9f8b7c9d10', 'Alice Johnson', 'alice.johnson@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6', '2023-01-03 00:00:00', '2023-01-03 00:00:00');

