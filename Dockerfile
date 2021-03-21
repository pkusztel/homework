FROM openjdk:11
ADD target/homework-0.0.1-SNAPSHOT.jar homework-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "homework-0.0.1-SNAPSHOT.jar"]