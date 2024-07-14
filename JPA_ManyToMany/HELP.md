# Spring Boot Many-to-Many Relationship Example

This project demonstrates a JPA (Java Persistence API) implementation of a many-to-many relationship between two entities: **Student** and **Course**. The application allows for creating, retrieving, updating, and deleting these entities using Spring JPA.

## Getting Started

### Prerequisites

- JDK 8 or higher
- MySQL Server
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)

### Database Setup

1. Create a MySQL database named `school_management`:
    ```sql
    CREATE DATABASE school_management;
    ```

2. Configure the database connection in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/school_management
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>
    spring.jpa.hibernate.ddl-auto=update
    ```

### API Endpoints

#### Student Endpoints

| HTTP Method | Endpoint        | Description                     |
|-------------|-----------------|---------------------------------|
| GET         | `/students`     | Retrieve a list of all students.|
| POST        | `/students`     | Save a new student.             |
| PUT         | `/students/{id}`| Update a student by ID.         |
| DELETE      | `/students/{id}`| Delete a student by ID.         |

#### Course Endpoints

| HTTP Method | Endpoint        | Description                     |
|------------|-----------------|---------------------------------|
| GET        | `/courses`      | Retrieve a list of all courses. |
| POST       | `/courses`      | Save a new course.              |
| PUT        | `/courses/{id}` | Update a course by ID.          |
| DELETE     | `/courses/{id}` | Delete a course by ID.          |

### Example Data

#### Sample JSON Data for Creating a Student with Courses

**POST Request to `/students`**

```json
{
    "name": "John Doe",
    "courses": [
        {
            "id": 1,
            "name": "Math"
        },
        {
            "id": 2,
            "name": "Science"
        }
    ]
}
