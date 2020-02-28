FROM openjdk:8
ADD target/activemq-receiver.jar activemq-receiver.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "activemq-receiver.jar"]