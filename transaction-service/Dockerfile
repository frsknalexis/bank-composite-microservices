FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 7001

ADD ./target/transaction-service.jar transaction-service.jar

ENTRYPOINT ["java", "-jar", "/transaction-service.jar"]