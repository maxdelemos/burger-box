CREATE TABLE pedido (
  id SERIAL PRIMARY KEY,
  cliente_id integer,
  data_criacao timestamp,
  data_atualizacao timestamp
);

CREATE TABLE pedido_item (
  id SERIAL PRIMARY KEY,
  pedido_id integer,
  produto_id integer,
  quantidade integer,
  data_criacao timestamp,
  data_atualizacao timestamp
);

CREATE TABLE cliente (
  id SERIAL PRIMARY KEY,
  nome varchar,
  data_criacao timestamp,
  data_atualizacao timestamp
);

CREATE TABLE produto (
  id SERIAL PRIMARY KEY,
  nome varchar,
  valor double precision,
  data_criacao timestamp,
  data_atualizacao timestamp
);

ALTER TABLE pedido_item ADD FOREIGN KEY (pedido_id) REFERENCES pedido (id);
ALTER TABLE pedido_item ADD FOREIGN KEY (produto_id) REFERENCES produto (id);
ALTER TABLE pedido ADD FOREIGN KEY (cliente_id) REFERENCES cliente (id);
