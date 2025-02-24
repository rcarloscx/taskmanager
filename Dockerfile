FROM amazoncorretto:17-alpine-jdk

MAINTAINER rcarloscx

COPY build/libs/taskmanager-0.0.1-SNAPSHOT.jar taskmanager-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/taskmanager-0.0.1-SNAPSHOT.jar"]