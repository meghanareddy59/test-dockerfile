FROM hyscale.platform.host:5000/redis:alpine_1 AS build
RUN echo "dev"

FROM hyscale.platform.host:5000/redis:alpine_1 AS test
ARG var
RUN echo $var

FROM hyscale.platform.host:5000/redis:alpine_1 AS stage
RUN echo "stage"
