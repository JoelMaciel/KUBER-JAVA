ARG KUBER_NAME=kuber-users

FROM openjdk:17-alpine as builder

ARG KUBER_NAME

WORKDIR /app/$KUBER_NAME

COPY ./pom.xml /app
COPY ./$KUBER_NAME/.mvn ./.mvn
COPY ./$KUBER_NAME/mvnw .
COPY ./$KUBER_NAME/pom.xml .

RUN chmod +x ./mvnw

RUN ./mvnw clean package -Dmaven.test.skip=true -Dmaven.main.skip=true -Dspring-boot.repackage.skip=true -e -X
RUN rm -r ./target/

COPY ./$KUBER_NAME/src ./src

RUN ./mvnw clean package -DskipTests
RUN ls -la ./target/

FROM openjdk:17-alpine

ARG KUBER_NAME

WORKDIR /app
RUN mkdir ./logs
ARG TARGET_FOLDER=/app/$KUBER_NAME/target

COPY --from=builder $TARGET_FOLDER/kuber-users-0.0.1-SNAPSHOT.jar .

ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT

CMD ["java", "-jar", "kuber-users-0.0.1-SNAPSHOT.jar"]
