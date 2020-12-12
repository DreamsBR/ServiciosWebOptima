FROM openjdk:8-jre-alpine

WORKDIR /app

COPY /services-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 587/tcp

CMD ["java", "-jar", "/app.jar"]
