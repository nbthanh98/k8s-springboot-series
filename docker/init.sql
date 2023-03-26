CREATE USER 'students'@'%' IDENTIFIED BY 'VNTechies2023';
CREATE DATABASE students CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON students.* TO 'students'@'%';

CREATE USER 'courses'@'%' IDENTIFIED BY 'VNTechies2023';
CREATE DATABASE courses CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON courses.* TO 'courses'@'%';
flush privileges;