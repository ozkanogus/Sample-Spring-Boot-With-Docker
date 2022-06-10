FROM OPENJDK:8
EXPOSE 8085
ADD target/ibm-interview.jar ibm-interview.jar
ENTRYPOINT ["java", "-jar", "/ibm-interview.jar"]
