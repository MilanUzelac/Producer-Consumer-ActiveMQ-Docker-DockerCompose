FROM openjdk:8
ADD target/activemq-sender.jar activemq-sender.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "activemq-sender.jar"]