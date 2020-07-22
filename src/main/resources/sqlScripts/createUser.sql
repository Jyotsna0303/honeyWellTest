CREATE USER 'honeywellDev'@'localhost' IDENTIFIED BY 'honeywellDev';

GRANT ALL PRIVILEGES ON * . * TO 'honeywellDev'@'localhost';

#below command is for default authentication.

ALTER USER 'honeywellDev'@'localhost' IDENTIFIED WITH mysql_native_password BY 'honeywellDev';
