    FROM openjdk:17


    WORKDIR /NotesMService


    COPY .mvn/ ./.mvn
    COPY pom.xml ./
    COPY src ./src
    COPY mvnw ./mvnw

    ENV security.username=username \
        security.password=password

    RUN ./mvnw dependency:resolve

    EXPOSE 9003

    CMD ["./mvnw", "spring-boot:run"]

