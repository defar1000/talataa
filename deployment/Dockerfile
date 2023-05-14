FROM amazoncorretto:11-alpine-jdk
VOLUME /tmp
COPY *.jar talataa.jar
ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
USER ubuntu
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar talataa.jar" ]