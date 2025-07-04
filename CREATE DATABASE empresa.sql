CREATE DATABASE empresa;
USE empresa;

CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE funcionario (
    id INT PRIMARY KEY,
    matricula VARCHAR(10) NOT NULL UNIQUE,
    departamento VARCHAR(50),
    FOREIGN KEY (id) REFERENCES pessoa(id)
);

CREATE TABLE projeto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    id_funcionario INT NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);