#pull base image
FROM openjdk:8-jdk-alpine

#maintainer
MAINTAINER Self

#expose port 8080
EXPOSE 8080

#copy hello world to docker image
ADD ./target/spring-webflux-reactive-0.0.1-SNAPSHOT.jar spring-webflux-reactive-0.0.1-SNAPSHOT.jar

#default command
CMD java -jar spring-webflux-reactive-0.0.1-SNAPSHOT.jar