FROM openjdk:11
COPY  build/libs/spring-sample-0.0.1-SNAPSHOT.jar /var/myapp/spring-sample.jar
WORKDIR /var/myapp
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-sample.jar"]
