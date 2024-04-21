FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/guitar-inventory-management-0.0.1-SNAPSHOT.jar guitars2
ENTRYPOINT ["java","-jar","guitars2"]
