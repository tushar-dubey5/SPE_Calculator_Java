# Use OpenJDK 17 as the base image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy all project files into the container
COPY src /app/src

# Compile the Java program (adjust path based on actual location)
RUN javac /app/src/Calculator.java

# Run the Java application
CMD ["java", "-cp", "/app/src", "Calculator"]
