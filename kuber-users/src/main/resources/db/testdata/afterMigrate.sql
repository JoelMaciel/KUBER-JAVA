
set foreign_key_checks = 0;

delete from users;

set foreign_key_checks = 1;

INSERT INTO users (id, name, email, password, creation_date, update_date) VALUES
(1, 'John Doe', 'john.doe@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6', '2023-01-01 00:00:00', '2023-01-01 00:00:00'),
(2, 'Jane Smith', 'jane.smith@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6' , '2023-01-02 00:00:00', '2023-01-02 00:00:00'),
(3, 'Alice Johnson', 'alice.johnson@example.com', '$2a$10$Jt2h4fCKeBnHnQG1/Ofeb.zXA.Vw/AUmf74JaXprovKa6Nl7t2Mz6', '2023-01-03 00:00:00', '2023-01-03 00:00:00');

