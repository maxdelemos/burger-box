CREATE TABLE pedido (
  id SERIAL PRIMARY KEY,
  cliente_id integer,
  status varchar,
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

CREATE TABLE pedido_pagamento (
  id SERIAL PRIMARY KEY,
  pedido_id integer,
  pagamento_id BIGINT,
  status varchar(50),
  data_criacao timestamp DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cliente (
  id SERIAL PRIMARY KEY,
  nome varchar,
  email varchar,
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
ALTER TABLE pedido_pagamento ADD FOREIGN KEY (pedido_id) REFERENCES pedido (id);

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
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (1, 'Hambúrguer', 'Delicioso hambúrguer com carne, queijo, alface e tomate', 'https://tse1.mm.bing.net/th/id/OIG2.kShMvPSvECE4IgcA9WqO?pid=ImgGn', 0.01);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (2, 'Sanduíche de Frango', 'Sanduíche de frango grelhado com alface, tomate e maionese', 'https://tse4.mm.bing.net/th/id/OIG4.SZSyuFiHtPAyOODoIwH.?pid=ImgGn', 0.02);

-- Acompanhamentos
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (3, 'Batata Frita', 'Porção de batatas fritas crocantes', 'https://tse3.mm.bing.net/th/id/OIG4.BO6omYQw9eCDAzZofMDO?pid=ImgGn', 0.03);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (4, 'Onion Rings', 'Anéis de cebola empanados e fritos', 'https://tse1.mm.bing.net/th/id/OIG2.7uVdoMazEhg1TyaiYRcr?pid=ImgGn', 0.04);

-- Bebidas
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (5, 'Refrigerante', 'Lata de refrigerante de cola 350ml', 'https://tse1.mm.bing.net/th/id/OIG2.DKmwwZO9VUyDRG3n7aXK?pid=ImgGn', 0.05);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (6, 'Suco Natural', 'Suco de laranja natural 300ml', 'https://tse1.mm.bing.net/th/id/OIG3.t188eRGyzlc7_ZH1XTFR?pid=ImgGn', 0.06);

-- Sobremesas
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (7, 'Sundae', 'Sorvete de baunilha com calda de chocolate e chantilly', 'https://tse3.mm.bing.net/th/id/OIG4.ZdXKsVSdVuqylnFYe4if?pid=ImgGn', 0.07);
INSERT INTO produto (id, nome, descricao, imagem, preco) VALUES (8, 'Brownie com Sorvete', 'Brownie de chocolate quente servido com sorvete de creme', 'https://tse1.mm.bing.net/th/id/OIG4.u7mIGkbpZa4ux6H4bOr.?pid=ImgGn', 0.08);

INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(1, 1);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(2, 1);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(3, 2);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(4, 2);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(5, 3);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(6, 3);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(7, 4);
INSERT INTO produto_categoria (produto_id, categoria_id) VALUES(8, 4);

SELECT setval('produto_id_seq', (SELECT MAX(id) FROM produto));

