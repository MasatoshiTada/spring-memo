docker container run \
  --name postgres-memo \
  -p 5433:5432 \
  -d \
  --rm \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_DB=postgres \
  postgres:14.2
