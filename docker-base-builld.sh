#docker run --rm -v gradle-cache:/home/gradle/.gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle:7.6.1-jdk8 gradle build

docker volume create --name gradle-cache
docker run --rm -v gradle-cache:/home/gradle/.gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle gradle build
ls -ltrh ./build/libs

#docker pull gradle:6.9.4-jdk17-focal
#docker pull gradle:8.0.2-jdk19-alpine