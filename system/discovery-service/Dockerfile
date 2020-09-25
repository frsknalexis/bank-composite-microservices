FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 7075

ADD ./target/discovery-service.jar discovery-service.jar

ENTRYPOINT ["java", "-jar", "/discovery-service.jar"]