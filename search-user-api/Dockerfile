FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
ADD /target/search-user-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

