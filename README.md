# 🎫 Event Management System (Spring Boot)

A Spring Boot app to manage events and registrations. Supports CRUD operations on events and attendee registration via RESTful APIs with JPA and H2/MySQL.

## 🚀 Features
- Create, read, update, delete events  
- Register participants to events  
- View registrants by event ID  

## 🧱 Tech Stack
- Backend: Spring Boot (REST API)
- Database: PostgreSql  
- JPA / Hibernate for ORM  
- Lombok for boilerplate reduction  
- Maven for build and dependency management  
- java 21

## 📥 Getting Started

1. **Clone repo**  
   ```bash
   git clone https://github.com/chandan043/Spring-Boot.git
   cd Spring-Boot

2. **Configure the Database**
Update src/main/resources/application.properties with your PostgreSQL credentials:
Properties
```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/eventdb
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
```

3. **Build and Run the Application**
```bash
mvn clean install
mvn spring-boot:run
```
The application will start on http://localhost:8080.

## 🧪 API Endpoints**

**📘 EventController**
Method	Endpoint	Description
- GET	/api/events	Retrieve all events
- GET	/api/events/{eventId}	Get a specific event by ID
- GET	/api/events/register	List all event registrations
- DELETE	/api/events/delete/{eventId}	Delete an event by ID

**🧍RegistrationController**
Method	Endpoint	Description
- POST	/api/registration	Register a user to an event
- GET	/api/registration/{eventId}/register-status/{regId}	Get registration status for a user
- DELETE	/api/registration/{eventId}/delete-register/{regId}	Delete a specific registration entry

**🖼️ Screenshots**
Swagger UI

![Image](https://github.com/user-attachments/assets/7d19d30a-cfc1-4015-9749-3fd99b197640)

![Image](https://github.com/user-attachments/assets/0b5f0a37-55b2-42b7-9114-9831f22d7b00)

**📄 License**
This project is licensed under the MIT License.
Feel free to fork, contribute, and use it in your own applications!

**👤 Author**
Chandan Kolloju
GitHub Profile


