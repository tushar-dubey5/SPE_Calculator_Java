# Use OpenJDK 17 as the base image (if you're using OpenJDK 17 locally)
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy all project files into the container
COPY . /app

# Compile Java program
RUN javac Calculator.java

# Run the Java application
CMD ["java", "Calculator"]
