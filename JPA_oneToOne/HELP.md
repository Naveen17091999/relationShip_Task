# Help Documentation

## JPA One-to-One Relationship Example

This project demonstrates a JPA (Java Persistence API) implementation of a one-to-one relationship between two entities: **Person** and **Passport**. The application allows for creating, retrieving, updating, and deleting these entities using Spring JPA.z

### Getting Started

1. **Prerequisites**
    - Ensure you have the following installed:
        - JDK 8 or higher
        - MySQL Server
        - Maven
        - An IDE (e.g., IntelliJ IDEA, Eclipse)

2. **Database Setup**
    - Create a MySQL database named `user_management`:
      ```sql
      CREATE DATABASE user_management;
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
| GET         | `/person`       | Retrieve a list of all persons. |
| POST        | `/person`       | Save a new person.              |
| put         | `/person/{id}`  | update a person  by ID.         |
| GET         | `/person/{id}`  | Delete a person by ID.          |

### Common Issues

1. **Database Connection Issues**
    - Ensure that MySQL is running and the connection properties in `application.properties` are correct.

### Troubleshooting Steps

- **Check Logs:** Review the application logs for any error messages.
- **Verify Database Records:** Use a MySQL client to check if users and images are correctly stored.
- **Browser Console:** Inspect the browser console for any loading errors related to images or resources.

### Create a Person with Passport
    
```properties
    {
        "name": "John Doe",
        "passport": {
            "passportNumber": "A12345678"
        }
    }        
```