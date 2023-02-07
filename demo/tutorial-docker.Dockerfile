FROM openjdk:19
COPY target/demo-0.0.1-SNAPSHOT.jar /tutorialsapp2.jar
CMD ["java", "-jar", "/tutorialsapp2.jar"]