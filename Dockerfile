FROM adoptopenjdk:11-jre-hotspot
MAINTAINER gustav4060esp@gmail.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} moveapp-backend-0.0.1.jar
ENTRYPOINT ["java","-jar","/moveapp-backend-0.0.1.jar"]