#  Student CRUD API — Spring Boot

A simple backend API built with Spring Boot while learning backend development.
Includes clean layering, DTOs, and proper exception handling.


## Features
- CRUD for Students
- Controller → Service → Repository architecture
- DTOs (Create, Update, Response)
- Custom `ResourceNotFoundException`
- Global Exception Handler
- Gradle project



## Run the Project

### Windows:
gradlew.bat bootRun

**Server runs at:**

http://localhost:8081



## API Endpoints (Students)

### Create Student
**POST**

http://localhost:8081/api/students

### Get All Students
**GET**

http://localhost:8081/api/students

### Get Student by ID
**GET**

http://localhost:8081/api/students/{id}
Example:

http://localhost:8081/api/students/2

### Update Student
**PUT**

http://localhost:8081/api/students/{id}

### Delete Student
**DELETE**

http://localhost:8081/api/students/{id}



## Project Structure

src/
└── main/java/.../
├── controller
├── service
├── repository
├── model
├── dto
└── exception
└── resources/
└── application.properties
build.gradle
settings.gradle
README.md



## Future Improvements
- Add validation
- Add pagination & sorting
- Add JWT authentication
- Add Swagger docs
- Deploy the API (Render / Railway)