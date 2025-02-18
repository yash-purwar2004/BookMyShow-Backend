FROM openjdk:21

WORKDIR /app
COPY target/Book_My_show_Backend-0.0.1-SNAPSHOT.jar /app/Book_My_show_Backend-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "Book_My_show_Backend-0.0.1-SNAPSHOT.jar"]