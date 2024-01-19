FROM postgres:latest

ENV POSTGRES_USER=root \
    POSTGRES_DB=supplies \
    POSTGRES_PASSWORD=StrongPassword123! \
    POSTGRES_DEFAULT_SCHEMA=supplies

VOLUME ["/docker-entrypoint-initdb.d"]
