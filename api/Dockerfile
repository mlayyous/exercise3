FROM openjdk:8u212-jre-alpine
EXPOSE 8080
# api file is added by the gradle docker plugin into the build context
COPY api-*.jar /api.jar
ENTRYPOINT ["java", "-jar", "api.jar"]