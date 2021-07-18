FROM openjdk:14-alpine
COPY build/libs/jwks-gen-*-all.jar jwks-gen.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "jwks-gen.jar"]