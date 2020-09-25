FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 7002

ADD ./target/account-service.jar account-service.jar

ENTRYPOINT ["java", "-jar", "/account-service.jar"]