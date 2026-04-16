# Repo Profile Service

Repo Profile Service is a Spring Boot application that provides insights into GitHub user profiles. it calculates the user's most used language by repository count and sorts repos by popularity.

## 🛠 Running the Application

### Local Development
Run the application using Maven:
```bash
./mvnw spring-boot:run
```
Docker Execution
The project includes remote debugging support on port 5005.
# Build
docker build -t repo-profile-service .

# Run
docker run -p 8080:8080 -p 5005:5005 repo-profile-service

📊 Database & API
H2 Console: http://localhost:8080/api/h2-console

JDBC URL: jdbc:h2:mem:repoprofile_db

Endpoint: POST http://localhost:8080/api/profiles/{username}

Note: If multiple languages share the same highest repository count, frequent_language will return "Unknown".
