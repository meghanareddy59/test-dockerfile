FROM  docker-registry.hyscale-test:5000/maven-test:1.0_1
COPY  selenium_docker/  /usr/src/mymaven
WORKDIR /usr/src/mymaven
