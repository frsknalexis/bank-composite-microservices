FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 7004

ADD ./target/transfer-service.jar transfer-service.jar

ENTRYPOINT ["java", "-jar", "/transfer-service.jar"]