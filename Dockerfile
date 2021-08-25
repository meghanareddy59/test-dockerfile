
FROM drfcgvbnj AS build
RUN echo ‘Random sample text’ > test4.txt

FROM docker-registry.hyscale-test:5000/importhrmsfrontendforqa:8.5_1
COPY --from=build test4.txt /usr/local/tomcat/webapps
RUN cat /usr/local/tomcat/webapps/test4.txt
