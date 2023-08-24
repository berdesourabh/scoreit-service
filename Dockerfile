FROM maven:3.9.3 as maven

WORKDIR /usr/src/app
COPY . /usr/src/app

RUN mvn clean package -DskipTests

FROM openjdk:17
EXPOSE 8080

ARG JAR_FILE=/usr/src/app/target/*.jar

COPY --from=maven ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]