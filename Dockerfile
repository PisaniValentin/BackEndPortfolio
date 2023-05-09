FROM amazoncorretto:11-alpine-jdk
MAINTAINER PisaniValentin
COPY target/miPortfolio-0.0.1-SNAPSHOT.jar miPortfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/miPortfolio-0.0.1-SNAPSHOT.jar"]
