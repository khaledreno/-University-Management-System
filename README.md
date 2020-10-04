 University Management System
Backend application build using 

1- Java programming langugue 
2- MySQL
3- Spring Boot 
4- Restful API / only possible to intialize values to entity classes not making a relationship
5- JPA Repository


The system allows you to create a teacher , student and a course 

Type of relationships :

Student --- Teacher 
the relation is Many-to-One
because one teacher can supervise on multple student but not the other way 

Teacher --- Course
the relation is Many-to-Many
because in modern days one one more than one teacher can teache the course to the students 
so the course can be teached to the student by multple teacher 



Course --- Student
the relation is Many-to-Many
because multple student can enroll in multple Courses  
and Courses can be enrolled in by multple student
