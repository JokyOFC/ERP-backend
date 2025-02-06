FROM openjdk:17-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN chmod +x ./mvnw && chown -R spring:spring /app

ENV DB_URL=jdbc:postgresql://192.168.1.13:5432/modular_erp
ENV DB_USER=postgres
ENV DB_PASS=admin

#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar

USER spring:spring

EXPOSE 8080/tcp

RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

#ENTRYPOINT ["java","-jar","/app.jar"]