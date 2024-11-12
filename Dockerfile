FROM ubuntu:latest AS build

#ENV SUPABASE_DATASOURCE_URL=$SUPABASE_DATASOURCE_URL
#ENV SUPABASE_PASSWORD=$SUPABASE_PASSWORD
#ENV SUPABASE_USER=$SUPABASE_USER

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

RUN mkdir data

EXPOSE 8081

COPY --from=build /target/demossr.war app.war

ENTRYPOINT [ "sh", "-c", "echo $SUPABASE_DATASOURCE_URL" ]
#ENTRYPOINT [ "java", "-jar", "app.war" ]