CREATE DATABASE quizpro_bd;

USE quizpro_bd;

CREATE TABLE questions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  question TEXT NOT NULL
);

CREATE TABLE answers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  answer TEXT NOT NULL,
  is_correct BOOLEAN NOT NULL,
  question_id INT NOT NULL,
  FOREIGN KEY (question_id) REFERENCES questions(id)
);

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  dni VARCHAR(255) NOT NULL,
  user VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  password VARCHAR(255) NOT NULL
);

CREATE TABLE results (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  question_id INT NOT NULL,
  answer_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (question_id) REFERENCES questions(id),
  FOREIGN KEY (answer_id) REFERENCES answers(id)
);
 




