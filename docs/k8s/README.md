# Executando o projeto com k8s localmente

Comando para excluir a pasta no host do banco de dados caso seja necessário
```bash
$ sudo rm -rf /tmp/data
```

Subir o minikube

```bash
$ minikube start
```

Criar o configmap para o postgres, alterar o `{PATH}` pelo path real da sua maquina

```bash
$ kubectl create configmap postgres-sql-configmap --from-file={PATH}/burger-box/src/main/resources/db/init/001_init.sql
```

Subir o postgres

```bash
$ kubectl apply -f k8s/postgres.yml
```

Criar o configmap sendo o hostname-config o IP do cluster que está rodando o banco.
Essa configuração é utilizando no pod da api.

```bash
$ kubectl create configmap hostname-config --from-literal=postgres_host=$(kubectl get svc postgres -o jsonpath="{.spec.clusterIP}")
```

Subir a aplicação

```bash
$ kubectl apply -f k8s/app.yml
```

Fazer o port-forward para o banco e aplicação
```bash
$ kubectl port-forward service/postgres 7575:5432

$ kubectl port-forward service/burguer-box-backend-service 9000:9000
```

**Deletar estrutura**

```bash
$ kubectl delete cm hostname-config

$ kubectl delete cm postgres-sql-configmap

$ kubectl delete -f k8s/postgres.yml

$ kubectl delete -f k8s/app.yml
```

## Acessando a documentação da api

- [Collection](../collection/collection.json)
- [Swagger](http://localhost:9000/swagger-ui/index.html)
