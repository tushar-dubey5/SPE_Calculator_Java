FROM openjdk:11-slim

WORKDIR /app

# Update the COPY command with the correct JAR file name
COPY target/Calculator_java-1.0-SNAPSHOT.jar /app/scientific-calculator.jar

CMD ["java", "-jar", "/app/scientific-calculator.jar"]
