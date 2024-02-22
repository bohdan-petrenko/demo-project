FROM openjdk:21-jdk-oracle
VOLUME /tmp
# todo rename app.jar to ...web-api.jar
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
