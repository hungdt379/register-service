# Sử dụng image cơ sở là OpenJDK 17
FROM openjdk:17-jdk-alpine

# Thiet lap thu muc lam viec trong container
WORKDIR /app

# Copy file JAR vao container
COPY target/register-service-0.0.1-SNAPSHOT.jar app.jar

# Mo cong 8080 de ung dung SpringBoot co the lang nghe
EXPOSE 8080

# Chay ung dung SpringBoot khi container khoi dong
ENTRYPOINT ["java", "-jar", "app.jar"]