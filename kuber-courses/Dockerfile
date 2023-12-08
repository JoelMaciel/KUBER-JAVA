FROM openjdk:17-alpine as builder

WORKDIR /app/kuber-courses

COPY ./pom.xml /app
COPY ./kuber-courses/.mvn ./.mvn
COPY ./kuber-courses/mvnw .
COPY ./kuber-courses/pom.xml .

RUN chmod +x ./mvnw

RUN ./mvnw clean package -Dmaven.test.skip=true -Dmaven.main.skip=true -Dspring-boot.repackage.skip=true -e -X
RUN rm -r ./target/

COPY ./kuber-courses/src ./src

RUN ./mvnw clean package -DskipTests
RUN ls -la ./target/

FROM openjdk:17-alpine

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/kuber-courses/target/kuber-courses-0.0.1-SNAPSHOT.jar .

EXPOSE 8002

CMD ["java", "-jar", "kuber-courses-0.0.1-SNAPSHOT.jar"]
