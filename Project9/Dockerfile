    FROM openjdk:17

    WORKDIR /Project9


    COPY .mvn ./.mvn
    COPY  pom.xml ./
    COPY mvnw ./mvnw
    COPY src ./src


    ENV security.username=username \
        security.password=password

    RUN ./mvnw dependency:resolve

    EXPOSE 9010

    CMD ["./mvnw", "spring-boot:run"]


