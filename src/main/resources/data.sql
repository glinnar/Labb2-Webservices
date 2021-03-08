DROP TABLE IF EXISTS testsnakehouse;

CREATE TABLE testsnakehouse(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (50),
    type VARCHAR (50),
    weight decimal(50),
    gender VARCHAR (50)

);

INSERT INTO testsnakehouse(name,type,weight,gender) VALUES
('Sir väs','Viper','24.00','Male'),
('Kaa','Python','40.00','Male');