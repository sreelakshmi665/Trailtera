
FROM maven:3.5.4-jdk-8-alpine as maven
WORKDIR /tmp/docker
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn dependency:go-offline -B

RUN mvn clean package -Dmaven.test.skip=true
FROM openjdk:8u171-jre-alpine

EXPOSE 9090
COPY  --from=maven target/codingChallenge--0.0.1-SNAPSHOT.jar codingChallenge.jar
CMD ["java", "-jar", "codingChallenge.jar"]