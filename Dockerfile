
FROM docker-registry.hyscale-test:5000/javatomcatjmeter352:1.0_1 AS dev
RUN echo "dev"

FROM docker-registry.hyscale-test:5000/javatomcatjmeter352:1.0_1 AS test
RUN echo "test"

FROM docker-registry.hyscale-test:5000/javatomcatjmeter352:1.0_1 AS stage
RUN echo "stage"

