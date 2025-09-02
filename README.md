# accountService
testing spring boot rest  services

# How to Run
Build: ./gradlew build
-Dspring.profiles.active=local
Run: ./gradlew bootRun
Test: curl http://localhost:8080/api/accounts/1/balance

# API Endpoints

GET /api/accounts/{accountId}/balance - Get account balance
GET /h2-console - H2 Database console

# Testing the API:
bash# Test existing account
curl http://localhost:8080/api/accounts/1/balance

# Test non-existing account (returns 404)
curl http://localhost:8080/api/accounts/999/balance

# Access H2 Console
http://localhost:8080/h2-console

# Once your application is running, open your web browser and navigate to:
http://localhost:8080/swagger-ui.html (or whatever springdoc.swagger-ui.path you configured).