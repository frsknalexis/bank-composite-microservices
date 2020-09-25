FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 8085

ADD ./target/configuration-server.jar configuration-server.jar

ENTRYPOINT ["java", "-jar", "/configuration-server.jar"]