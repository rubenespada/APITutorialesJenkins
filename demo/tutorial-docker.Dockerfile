FROM openjdk:19
COPY target/demo-0.0.1-SNAPSHOT.jar /personsapp.jar
CMD ["java", "-jar", "/personsapp.jar"]