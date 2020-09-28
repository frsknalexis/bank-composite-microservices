FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 7003

ADD ./target/deposit-service.jar deposit-service.jar

ENTRYPOINT ["java", "-jar", "/deposit-service.jar"]