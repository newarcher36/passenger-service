FROM openjdk:11
COPY target/passenger-service-1.0.jar /usr/app/passenger-service-1.0.jar
ENTRYPOINT ["java","-jar","/usr/app/miniproject-1.0.jar"]