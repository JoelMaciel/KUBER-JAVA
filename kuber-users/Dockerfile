FROM openjdk:17-alpine as builder

WORKDIR /app/msvc-users

COPY ./pom.xml /app
COPY ./kuber-users/.mvn ./.mvn
COPY ./kuber-users/mvnw .
COPY ./kuber-users/pom.xml .

RUN chmod +x ./mvnw

RUN ./mvnw clean package -Dmaven.test.skip=true -Dmaven.main.skip=true -Dspring-boot.repackage.skip=true -e -X
RUN rm -r ./target/

COPY ./kuber-users/src ./src

RUN ./mvnw clean package -DskipTests
RUN ls -la ./target/

FROM openjdk:17-alpine

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/msvc-users/target/msvc-users-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

CMD ["java", "-jar", "msvc-users-0.0.1-SNAPSHOT.jar"]
