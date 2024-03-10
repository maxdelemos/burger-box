FROM jelastic/maven:3.9.5-temurinjdk-21

WORKDIR /app

COPY ./ /app

RUN ./mvnw clean package -DskipTests

RUN cp target/burger-box-0.0.1-SNAPSHOT.jar /app/burger-box-0.0.1-SNAPSHOT.jar

EXPOSE 9000

CMD ["java", "-Dspring.profiles.active=prd", "-jar", "burger-box-0.0.1-SNAPSHOT.jar"]