# Pull base image.
FROM ubuntu:latest

sudo yum install java

ADD ./build/libs/person-0.0.1-SNAPSHOT.jar test.jar

EXPOSE 8080

CMD java -jar test.jar