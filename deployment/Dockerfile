FROM openjdk:11
VOLUME /tmp
COPY *.jar talataa.jar
#ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
# USER ubuntu
CMD ["dir"]
ENTRYPOINT ["java","-jar","/talataa.jar" ]