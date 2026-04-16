FROM eclipse-temurin:21-jdk-alpine

LABEL maintainer="vodacom"
LABEL description="Repo Profile Insights API - Development"

WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Expose port and debug port
EXPOSE 8080 5005

# Development JVM options with remote debugging
ENV JAVA_OPTS="-Xms256m -Xmx512m -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"

# Run with Spring Boot DevTools
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.jvmArguments=\"${JAVA_OPTS}\""]
