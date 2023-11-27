CREATE TABLE courses_users (
    id CHAR(36) NOT NULL PRIMARY KEY,
    course_id CHAR(36) NOT NULL,
    user_id CHAR(36) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
