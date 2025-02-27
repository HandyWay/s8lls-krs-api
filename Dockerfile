FROM maven:3.8.6-openjdk-17 AS builder

WORKDIR /src

COPY pom.xml ./
RUN mvn dependency:go-offline --no-transfer-progress

COPY src ./src
RUN mvn clean package -DskipTests --no-transfer-progress

FROM openjdk:17-jre-slim

RUN apt-get update && apt-get install -y --no-install-recommends curl ca-certificates bash && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY --from=builder /src/target/KrsMicroserviceApplication.jar /app/KrsMicroserviceApplication.jar

RUN curl -sL https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh -o /wait-for-it.sh && \
    chmod +x /wait-for-it.sh

EXPOSE 8000

CMD ["/wait-for-it.sh", "postgres:5432", "--", "java", "-jar", "/app/KrsMicroserviceApplication.jar"]