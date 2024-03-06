CREATE TABLE pedido (
  id SERIAL PRIMARY KEY,
  cliente_id integer,
  data_criacao timestamp DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pedido_item (
  id SERIAL PRIMARY KEY,
  pedido_id integer,
  produto_id integer,
  quantidade integer,
  data_criacao timestamp DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cliente (
  id SERIAL PRIMARY KEY,
  nome varchar,
  cpf varchar,
  data_criacao timestamp DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE produto (
  id SERIAL PRIMARY KEY,
  nome varchar(255),
  descricao varchar(255),
  imagem text,
  preco double precision,
  ativo boolean DEFAULT true,
  data_criacao timestamp DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao timestamp DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE pedido_item ADD FOREIGN KEY (pedido_id) REFERENCES pedido (id);
ALTER TABLE pedido_item ADD FOREIGN KEY (produto_id) REFERENCES produto (id);
ALTER TABLE pedido ADD FOREIGN KEY (cliente_id) REFERENCES cliente (id);

CREATE TABLE categoria (
  id SERIAL PRIMARY KEY,
  descricao varchar(255),
  codigo varchar(20)
);

CREATE TABLE produto_categoria (
  id SERIAL PRIMARY KEY,
  produto_id integer,
  categoria_id integer
);

ALTER TABLE produto_categoria ADD FOREIGN KEY (produto_id) REFERENCES produto (id);
ALTER TABLE produto_categoria ADD FOREIGN KEY (categoria_id) REFERENCES categoria (id);

INSERT INTO categoria (id, descricao, codigo) VALUES (1, 'Lanche', 'LANCHE');
INSERT INTO categoria (id, descricao, codigo) VALUES (2, 'Acompanhamento', 'ACOMPANHAMENTO');
INSERT INTO categoria (id, descricao, codigo) VALUES (3, 'Bebida', 'BEBIDA');
INSERT INTO categoria (id, descricao, codigo) VALUES (4, 'Sobremesa', 'SOBREMESA');

-- Inserção de produtos para cada categoria
-- Lanches
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (1, 'Hambúrguer', 'Delicioso hambúrguer com carne, queijo, alface e tomate', 'url_da_imagem', 10.99);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (2, 'Sanduíche de Frango', 'Sanduíche de frango grelhado com alface, tomate e maionese', 'url_da_imagem', 8.99);

-- Acompanhamentos
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (3, 'Batata Frita', 'Porção de batatas fritas crocantes', 'url_da_imagem', 4.99);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (4, 'Onion Rings', 'Anéis de cebola empanados e fritos', 'url_da_imagem', 5.99);

-- Bebidas
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (5, 'Refrigerante', 'Lata de refrigerante de cola 350ml', 'url_da_imagem', 3.49);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (6, 'Suco Natural', 'Suco de laranja natural 300ml', 'url_da_imagem', 4.99);

-- Sobremesas
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (7, 'Sundae', 'Sorvete de baunilha com calda de chocolate e chantilly', 'url_da_imagem', 6.99);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (8, 'Brownie com Sorvete', 'Brownie de chocolate quente servido com sorvete de creme', 'url_da_imagem', 7.99);

INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(1, 1);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(2, 1);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(3, 2);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(4, 2);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(5, 3);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(6, 3);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(7, 4);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(8, 4);

SELECT setval('produto_id_seq', (SELECT MAX(id) FROM produto));

