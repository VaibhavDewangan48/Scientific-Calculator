FROM openjdk:21-jdk-slim
WORKDIR /app
#COPY target/scientific-calculator-1.0-SNAPSHOT.jar app.jar
COPY target/Scientific-Calculator-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
