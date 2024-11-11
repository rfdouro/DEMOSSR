FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

RUN mkdir data

EXPOSE 8081

DATASOURCE_URL='jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres'

COPY --from=build /target/demossr.war app.war

ENTRYPOINT [ "java", "-jar", "app.war" ]