# Help Documentation

## JPA One-to-Many Relationship Example

This project demonstrates a JPA (Java Persistence API) implementation of a one-to-many relationship between two entities: Department and Employee. The application allows for creating, retrieving, updating, and deleting these entities using Spring JPA.

### Getting Started

1. **Prerequisites**
    - Ensure you have the following installed:
        - JDK 8 or higher
        - MySQL Server
        - Maven
        - An IDE (e.g., IntelliJ IDEA, Eclipse)

2. **Database Setup**
    - Create a MySQL database named `company_management`:
      ```sql
      CREATE DATABASE company_management;
      ```

3. **Configuration**
    - Open `src/main/resources/application.properties` and configure the database connection:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/user_management
      spring.datasource.username=<your-username>
      spring.datasource.password=<your-password>
      spring.jpa.hibernate.ddl-auto=update
      ```

### API Endpoints

| HTTP Method | Endpoint        | Description                     |
|-------------|-----------------|---------------------------------|
| GET         | `/department`       | Retrieve a list of all departments. |
| POST        | `/department`       | Save a new department.              |
| put         | `/department/{id}`  | update a departments  by ID.         |
| GET         | `/department/{id}`  | Delete a departments by ID.          |

| HTTP Method | Endpoint           | Description                       |
|-------------|--------------------|-----------------------------------|
| GET         | `/employee`        | Retrieve a list of all employees. |
| POST        | `/employee`      | Save a new employee.              |
| put         | `/employee/{id}` | update a employee  by ID.         |
| GET         | `/employee/{id}` | Delete a employee by ID.          |

### Common Issues

1. **Database Connection Issues**
    - Ensure that MySQL is running and the connection properties in `application.properties` are correct.

### Troubleshooting Steps

- **Check Logs:** Review the application logs for any error messages.
- **Verify Database Records:** Use a MySQL client to check if users and images are correctly stored.
- **Browser Console:** Inspect the browser console for any loading errors related to images or resources.

### Create a Department with Employees
    
```properties
    {
         "name": "Human Resources",
         "employees": [
               {
                  "name": "Alice"
               },
               {
                  "name": "Bob"
               }
         ]
    }   
```