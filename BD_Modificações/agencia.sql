CREATE DATABASE agencia;
USE agencia;

CREATE TABLE Clientes 
( 
 nome VARCHAR(50) NOT NULL,  
 telefone CHAR(15),  
 cidade_reside VARCHAR(50),  
 id_cliente INT PRIMARY KEY AUTO_INCREMENT,  
 uf_reside VARCHAR(50),  
 email VARCHAR(50) NOT NULL,  
 país_reside VARCHAR(50),  
 id_pacote INT 
); 

CREATE TABLE Destinos 
( 
 id_destino INT PRIMARY KEY AUTO_INCREMENT,  
 cidade VARCHAR(50),  
 estado VARCHAR(50),  
 país VARCHAR(50),  
 id_pacote INT  
); 

CREATE TABLE Pacotes 
( 
 id_pacote INT PRIMARY KEY AUTO_INCREMENT,  
 num_acompanhantes INT,  
 hospedagem_sim_nao CHAR(10),  
 preco CHAR(20),  
 data_ida VARCHAR(50),  
 data_volta VARCHAR(50),  
 nome_pacote VARCHAR(50),  
 id_cliente INT,  
 id_destino INT  
); 

ALTER TABLE Clientes ADD FOREIGN KEY(id_pacote) REFERENCES Pacotes (id_pacote);
ALTER TABLE Destinos ADD FOREIGN KEY(id_pacote) REFERENCES Pacotes (id_pacote);
ALTER TABLE Pacotes ADD FOREIGN KEY(id_cliente) REFERENCES Clientes (id_cliente);
ALTER TABLE Pacotes ADD FOREIGN KEY(id_destino) REFERENCES Destinos (id_destino);
