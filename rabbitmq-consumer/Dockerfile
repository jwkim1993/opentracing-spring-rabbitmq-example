FROM openjdk:8

WORKDIR /usr/src/myapp
COPY build/libs/rabbitmq-consumer-0.0.1-SNAPSHOT.jar /usr/src/myapp/.

EXPOSE 8082

CMD ["java", "-jar", "rabbitmq-consumer-0.0.1-SNAPSHOT.jar"]


