# Burger Box
O Burger Box é uma solução de autoatendimento desenvolvida para restaurantes de fast food. Com sua integração fácil e intuitiva, os estabelecimentos podem oferecer aos clientes a capacidade de fazer pedidos e visualizar de forma rápida e conveniente. Esta solução simplifica o processo de automação, permitindo uma experiência de autoatendimento eficiente e personalizável para clientes e proprietários de restaurantes.

## O que foi utilizado nesse projeto
- Docker
- Minikube
- [Ngrok](https://ngrok.com/)
- Spring Boot
- Java
- Postgres

# Executando o projeto com docker
Subir os container do postgres, api e ngrok

Entre na raiz do projeto e execute o comando

```bash
docker-compose -f docker/app.yml up -d
```

Verifique se os container estão rodando

```bash
docker ps
```

As portas utilizadas
- 7575 -> Postgres
- 9000 -> Api

Volume do postgres:
```bash
/tmp/data/burgerbox.db
```

## Acessando a documentação da api

- [Swagger](http://localhost:9000/swagger-ui/index.html)
- [Redoc](http://localhost:9000/redoc)


## Realizando checkout e pagamento

**Identificar um usuário**

**Curl**

```bash
curl --location 'http://localhost:9000/api/clientes/identificar' \
--header 'Content-Type: application/json' \
--header 'Accept: */*' \
--data '{
  "cpf": "09209780027"
}'
```

**Response body**

```json
{
  "id": 1,
  "nome": null,
  "cpf": "09209780027",
  "email": null
}
```

**Cadastrar um pedido**

**Curl**

```bash
curl --location 'http://localhost:9000/api/pedidos' \
--header 'Content-Type: application/json' \
--header 'Accept: */*' \
--data '{
  "clienteId": "1",
  "produto": [
    {
      "id": "1",
      "quantidade": 1
    }
  ]
}'
```

**Response body**

```bash
{
    "id": 1,
    "qrCodePix": "base64",
    "codigoPix": "00020126580014br.gov.bcb.pix01366e04d3cd-65aa-4644-baa6-a4a62f35b0f552040000530398654040.035802BR5910MAXDELEMOS6009Sao Paulo62240520mpqrinter73854616171630426BC"
}
```

Esse **qrcode** pix foi gerado a partir da integração com o **mercado pago**.

A volor dos produtos então em poucos centavos, caso seja necessário podemos fazer o estorno rsrsr.

E então, depois de pago, podemos listar os pedido.

**Curl**

```bash
curl --location 'http://localhost:9000/api/pedidos' \
--header 'Accept: */*'
```

**Response body**

```json
[
    {
        "id": 1,
        "status": "RECEBIDO",
        "dataAtualizacao": "2024-03-11T17:45:46.403964"
    }
]
``` 

# Executando o projeto com k8s localmente

Comando para excluir a pasta no host do banco de dados caso seja necessário
```bash
sudo rm -rf /tmp/data
```

Subir o minikube

```bash
minikube start
```

Criar o configmap para o postgres

```bash
kubectl create configmap postgres-sql-configmap --from-file=/home/max/Documents/personal/pos/burger-box/src/main/resources/db/init/001_init.sql
```

Subir o postgres

```bash
kubectl apply -f postgres.yml
```

Criar o configmap sendo o hostname-config o IP do cluster que está rodando o banco.
Essa configuração é utilizando no pod da api.

```bash
kubectl create configmap hostname-config --from-literal=postgres_host=$(kubectl get svc postgres -o jsonpath="{.spec.clusterIP}")
```

Subir a aplicação

```bash
kubectl apply -f app.yml
```

Fazer o port-forward para o banco e aplicação
```bash
kubectl port-forward service/postgres 7575:5432

kubectl port-forward service/burguer-box-backend-service 9000:9000
```

**Deletar estrutura**

```bash
kubectl delete cm hostname-config

kubectl delete cm postgres-sql-configmap

kubectl delete -f postgres.yml

kubectl delete -f app.yml
```

## Acessando a documentação da api

- [Swagger](http://localhost:9000/swagger-ui/index.html)
- [Redoc](http://localhost:9000/redoc)

# Executando o projeto em desenvolvimento

Subir o container do postgres

```bash
docker-compose -f docker/postgresql.yml up -d
```

Rodar a aplicação

```bash
./mvnw spring-boot:run
```

# Atualizar imagem no docker hub

```bash
docker build -t burger-box .
docker tag burger-box:latest devvelejar/burger-box:latest
docker push devvelejar/burger-box:latest
```

# +Referências

- https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
- https://www.baeldung.com/spring-boot-clean-architecture
- https://www.youtube.com/watch?v=hit0XHGt4WI
- https://kubernetes.io/docs/tasks/run-application/horizontal-pod-autoscale/