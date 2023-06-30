### Stage 1: A minimal docker image with command to run the app
FROM openjdk:11

# The application's jar file
ARG JAR_FILE=build/libs/planflight.jar

# Add the application's jar to the container
ADD ${JAR_FILE} planflight.jar

EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "planflight.jar"]