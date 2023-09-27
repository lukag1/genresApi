#
# Build source code
#
FROM docker.io/maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Deployment
#
FROM docker.io/openjdk:11-jre-slim

RUN mkdir /opt/app

COPY --from=build /home/app/target/onboarding-genres.jar /opt/app/japp.jar

EXPOSE 8080

USER 1001

CMD ["java", "-jar", "/opt/app/japp.jar"]


