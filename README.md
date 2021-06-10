## Spring MVC Note Keeping CRUD App

Description - A server side rendered application to create, list, update and delete your notes. 

---

#### Technologies Used - 
- Maven 
- Spring Core
- Spring MVC
- Hibernate ORM
- JDBC
- MySQL Database
- Java Server Pages ( JSP )
- JSTL ( JSP Standard Tag Library )
- HTML / CSS / Bootstrap


#### Steps to Use: 

1. Clone the project

2. Import as a Maven project in your favorite IDE.

3. Create a ```note``` Table in your MySQL Database

```sql
CREATE TABLE `notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(350) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
);
```

4. Create a file ```database.properties``` under ```src/main/resources/```.

5. Fill up the database.properties file

```sql
#
# MySQL JDBC Properties - Used by Hibernate to connect to MySQL Database
#
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/MYSQL_DATABASE_NAME?useSSL=false
jdbc.user=MYSQL_DATABASE_USER
jdbc.password=MYSQL_DATABASE_PASSWORD

#
# Hibernate Properties
#
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.show_sql=true
hibernate.packagesToScan=com.sayandas.firstproject.entity
```

Set any other Hibernate properties you want to use here and add them in the
```sessionFactory()``` method in the ```AppMvcConfig.java``` class

6. Run the Application on a Server [ Such as Tomcat ]

### **Star the Repository if you like the contents : )**

----------
