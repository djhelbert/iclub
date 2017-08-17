# iClub
Free Open Source Athletic Club Site (Running, Triathlon, Swim, Hiking, Biking, etc.)

# Features
1. Group Email (Google SMTP)
2. Strava Integration
3. Twitter Feeds
4. Easy Configuration

# Requirements
JDK 1.8

# Usage
java -jar iclub-0.1.0.jar --spring.config.location=C:\Users\djhel\application.properties

# Local Development/Testing Application Properties
```
spring.datasource.url= jdbc:mysql://localhost:3306/iclub
spring.datasource.username=iclub
spring.datasource.password=iclub
spring.jpa.hibernate.ddl-auto=update
logging.level.org.springframework=WARN
logging.level.org.hibernate=WARN
logging.level.org.iclub=DEBUG
spring.freemarker.expose-request-attributes=true
spring.freemarker.expose-spring-macro-helpers=true
server.port=8080
```
