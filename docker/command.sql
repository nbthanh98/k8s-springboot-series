CREATE USER 'students'@'%' IDENTIFIED BY 'VNTechies2023';
CREATE DATABASE students CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON students.* TO 'students'@'%';

CREATE USER 'payment'@'%' IDENTIFIED BY 'VNTechies2023';
CREATE DATABASE payment CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON payment.* TO 'payment'@'%';
flush privileges;