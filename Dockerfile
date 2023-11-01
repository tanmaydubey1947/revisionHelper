FROM openjdk:11
COPY helper-0.0.1-SNAPSHOT.jar helper-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/helper-0.0.1-SNAPSHOT.jar"]