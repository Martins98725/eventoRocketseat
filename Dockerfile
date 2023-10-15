FROM ubuntu:latest AS build

RUN apt-get upadate
RUN apt-get install openjdk-19-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:19-jdk-slim

EXPOSE 8080

COPY --from=build /target/todolist-icaro-0.0.1.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]