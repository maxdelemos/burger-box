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

A volor dos produtos estão em poucos centavos, caso seja necessário podemos fazer o estorno rsrsr.

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