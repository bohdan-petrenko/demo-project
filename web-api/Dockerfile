FROM openjdk:21-jdk-oracle
VOLUME /tmp
COPY target/*.jar simple-bank-web-api.jar
ENTRYPOINT ["java","-jar","/simple-bank-web-api.jar"]
