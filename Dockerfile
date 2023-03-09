##docker pull gradle:8.0-jdk19-alpine
#FROM gradle:8.0.1-jdk19-jammy
#
#WORKDIR /app
#
#COPY . .
#
#RUN gradle build --no-daemon

FROM openjdk:19

COPY build/libs/blog-spot-0.0.1-SNAPSHOT.jar blog-spot-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "blog-spot-0.0.1-SNAPSHOT.jar"]