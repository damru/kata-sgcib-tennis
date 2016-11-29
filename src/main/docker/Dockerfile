FROM frolvlad/alpine-oraclejdk8
ADD kata-tennis-1.1.jar tennis.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /tennis.jar" ]