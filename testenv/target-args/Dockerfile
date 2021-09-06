
FROM docker-registry.hyscale-test:5000/redisqa:1-0_1 AS dev
ARG args
RUN echo $args
FROM docker-registry.hyscale-test:5000/javatomcatjmetersanity:1.0_1 AS test
RUN echo "test"
FROM docker-registry.hyscale-test:5000/redisqa:1-0_1 AS stage
RUN echo "stage"
