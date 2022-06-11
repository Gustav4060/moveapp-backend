FROM amazoncorretto:11-alpine-jdk
MAINTAINER gustav4060esp@gmail.com
COPY target/moveapp-backend-0.0.1.jar moveapp-backend-0.0.1.jar
ENTRYPOINT ["java","-jar","/moveapp-backend-0.0.1.jar"]