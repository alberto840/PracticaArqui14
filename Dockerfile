
FROM adoptopenjdk/openjdk17:alpine-jre

RUN apk update && apk add --no-cache nodejs npm

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

RUN npm install
RUN ./gradlew build

CMD ["java", "-jar", "/app.jar"]
