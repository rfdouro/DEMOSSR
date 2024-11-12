FROM ubuntu:latest AS build

#RUN apt-get update
#RUN apt-get install openjdk-17-jdk -y
#COPY . .

#RUN apt-get install maven -y
#RUN mvn clean install

#FROM openjdk:17-jdk-slim

#RUN mkdir data

#EXPOSE 8081

ENV DATASOURCE_URL=$DATASOURCE_URL
ENV SUPABASE_PASSWORD=$SUPABASE_PASSWORD
ENV SUPABASE_USER=$SUPABASE_USER


#COPY --from=build /target/demossr.war app.war

ENTRYPOINT [ "sh", "-c", "echo $DATASOURCE_URL" ]
#ENTRYPOINT [ "java", "-jar", "app.war" ]
#ENTRYPOINT [ "sh", "-c", "java -DSUPABASE_USER=${SUPABASE_USER} -DSUPABASE_PASSWORD=${SUPABASE_PASSWORD} -DDATASOURCE_URL=${DATASOURCE_UR} -jar app.war" ]