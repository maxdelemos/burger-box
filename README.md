## Burger Box
O Burger Box é uma solução de autoatendimento desenvolvida para restaurantes de fast food. Com sua integração fácil e intuitiva, os estabelecimentos podem oferecer aos clientes a capacidade de fazer pedidos e visualizar de forma rápida e conveniente. Esta solução simplifica o processo de automação, permitindo uma experiência de autoatendimento eficiente e personalizável para clientes e proprietários de restaurantes.

## Requisitos
- java 21
- Docker

## Executando o projeto

Subir o container do banco de dados
```
docker-compose -f docker/postgresql.yml up -d
```

Rodar a aplicação
```
./mvnw spring-boot:run
```

Acessando a documentação da api

[Swagger](http://localhost:9000/swagger-ui/index.html) ou [Redoc](http://localhost:9000/redoc)
