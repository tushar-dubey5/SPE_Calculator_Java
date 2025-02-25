FROM openjdk:11-slim

WORKDIR /app

COPY target/Calculator_java-1.0-SNAPSHOT.jar /app/scientific-calculator.jar

CMD ["java", "-jar", "/app/scientific-calculator.jar"]
