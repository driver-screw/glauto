FROM maven:3.9-amazoncorretto-17-al2023
LABEL authors="anatoliipiddubnyi"

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve

COPY src ./src
ENTRYPOINT mvn clean test