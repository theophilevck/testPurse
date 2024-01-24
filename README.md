OpenAPI Specification
All endpoints are listed in OpenAPI 3 format and documented here:

src -> main -> resources -> static -> v3 -> api-docs

Java version
17

Database configuration
Microservice uses PostgreSQL as a main database. You should provide a running instance before start of application and fill environment variables:

to implement for now in application.yml

DB_CONNECTION jdbc:postgresql://localhost:5432/postgres
DB_USERNAME postgres
DB_PASSWORD 123456
for now the database is in a docker container on the port 5432 so you need to start a docker container with the following docker-compose

version: '3.9'

services:
postgres:
image: postgres:15-alpine
ports:
- 5432:5432
volumes:
- ~/apps/postgres:/var/lib/postgresql/data
environment:
- POSTGRES_PASSWORD=123456
- POSTGRES_USER=postgres
- POSTGRES_DB=postgres
Database migrations rollout
The application uses Liquibase for applying DB migrations which happens during the startup.

http://localhost:8080/webjars/swagger-ui/index.html