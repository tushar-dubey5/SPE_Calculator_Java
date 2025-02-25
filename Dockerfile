FROM openjdk:11-slim

WORKDIR /app

COPY target/scientific-calculator-1.0-SNAPSHOT.jar /app/scientific-calculator.jar

CMD ["java", "-jar", "app.jar"]
