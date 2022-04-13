FROM openjdk:8
ADD target/cloud.academy-0.0.1-SNAPSHOT.jar cloud.academy-0.0.1-SNAPSHOT.jar
EXPOSE 8080
EXPOSE 3306
ENTRYPOINT ["java", "-jar", "cloud.academy-0.0.1-SNAPSHOT.jar"]
