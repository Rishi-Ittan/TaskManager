FROM eclipse-temurin:21
COPY ./build/libs/task-manager-0.0.1-SNAPSHOT.jar TaskManager.jar
ENTRYPOINT ["java","-jar","/TaskManager.jar"]
