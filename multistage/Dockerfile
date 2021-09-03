FROM hyscale.platform.host:5000/redis:alpine_1 AS build
RUN echo ‘Random sample text’ > test4.txt

FROM hyscale.platform.host:5000/importhrmsfrontendforqa:8.5_1 AS DEV
COPY --from=build test4.txt /usr/local/tomcat/webapps
RUN cat /usr/local/tomcat/webapps/test4.txt
