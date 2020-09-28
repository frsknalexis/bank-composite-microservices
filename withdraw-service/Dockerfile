FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 7005

ADD ./target/withdraw-service.jar withdraw-service.jar

ENTRYPOINT ["java", "-jar", "/withdraw-service.jar"]