USE student_management; -- Replace with your actual database name

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    PRIMARY KEY(user_id, role_id)
);

-- Insert roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Insert a user
INSERT INTO users (username, password, enabled) VALUES ('admin', '{bcrypt}$2a$10$D9QfW/nFjmK8aP1lo/4EhukPbQdU.5e1Pm5e/MsrMuMiAzOFuc072', TRUE);
-- Password is 'admin123' encoded using bcrypt

-- Assign roles to the user
INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE username='admin'), (SELECT id FROM roles WHERE name='ROLE_ADMIN'));

select * from users;
