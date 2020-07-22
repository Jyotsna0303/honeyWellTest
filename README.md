# honeyWellTest
1) Create a database service (MySQL, H2, Oracle, Postgres etc.)

    Create connection to this DB

2) Create an ‘Employee’ table with following columns

    ID(primary key), Name, Age, gender

3) Implement a POST API /employee (POST payload - (ID, Name, Age, Gender)

    This API inserts a new record into the database.
return ID 

4) Implement an API /employees?gender=<>&minage=<>&maxage=<>

return error message/exception (useful to user)
