FROM java:8-jdk-alpine

COPY ./target/ci-cd-spring-project*.jar /usr/app/ci-cd-spring-project.jar

WORKDIR /usr/app

RUN sh -c 'touch ci-cd-spring-project.jar'

ENTRYPOINT ["java","-jar","ci-cd-spring-project.jar"]