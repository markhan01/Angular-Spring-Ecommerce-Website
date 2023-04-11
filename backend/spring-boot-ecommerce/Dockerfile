FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar /app

EXPOSE 5000

CMD ["java", "-jar", "spring-boot-ecommerce-0.0.1-SNAPSHOT.jar"]