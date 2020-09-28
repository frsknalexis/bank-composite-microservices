FROM openjdk:13

MAINTAINER alexisgutierrezf.1997@gmail.com

VOLUME /tmp

EXPOSE 8765

ADD ./target/bank-zuul-proxy.jar bank-zuul-proxy.jar

ENTRYPOINT ["java", "-jar", "/bank-zuul-proxy.jar"]