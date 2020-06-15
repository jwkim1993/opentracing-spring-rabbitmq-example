FROM openjdk:8

WORKDIR /usr/src/myapp
COPY build/libs/rabbitmq-producer-0.0.1-SNAPSHOT.jar /usr/src/myapp/.

EXPOSE 8081

CMD ["java", "-jar", "rabbitmq-producer-0.0.1-SNAPSHOT.jar"]


