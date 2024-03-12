# Executando o projeto com docker
Subir os container do postgres, api e ngrok

Entre na raiz do projeto e execute o comando

```bash
$ docker-compose -f docker/app.yml up -d
```

Verifique se os container estão rodando

```bash
$ docker ps
```

As portas utilizadas
- 7575 -> Postgres
- 9000 -> Api

Volume do postgres:
```bash
/tmp/data/burgerbox.db
```

## Acessando a documentação da api

- [Collection](../collection/collection.json)
- [Swagger](http://localhost:9000/swagger-ui/index.html)
