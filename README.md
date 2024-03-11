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

---

```
# Comando para excluir a pasta no host
sudo rm -rf /tmp/data

docker build -t burger-box .
docker tag burger-box:latest devvelejar/burger-box:latest
docker push devvelejar/burger-box:latest

minikube start

kubectl create configmap postgres-sql-configmap --from-file=/home/max/Documents/personal/pos/burger-box/src/main/resources/db/init/001_init.sql

kubectl apply -f postgres.yml

kubectl create configmap hostname-config --from-literal=postgres_host=$(kubectl get svc postgres -o jsonpath="{.spec.clusterIP}")

kubectl apply -f app.yml

kubectl port-forward service/postgres 7575:5432

kubectl port-forward service/burguer-box-backend-service 9000:9000

kubectl delete cm hostname-config

kubectl delete cm postgres-sql-configmap

kubectl delete -f postgres.yml

kubectl delete -f app.yml

```