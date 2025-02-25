FROM openjdk:11-slim

WORKDIR /app

COPY target/scientific-calculator-1.0-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
