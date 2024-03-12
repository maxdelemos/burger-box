# Executando o projeto em desenvolvimento

Subir o container do postgres

```bash
$ docker-compose -f docker/postgresql.yml up -d
```

Rodar a aplicação

```bash
$ ./mvnw spring-boot:run
```

# Atualizar imagem no docker hub

```bash
$ docker build -t burger-box .
$ docker tag burger-box:latest devvelejar/burger-box:latest
$ docker push devvelejar/burger-box:latest
```