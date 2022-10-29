#SEED DO BANCO

INSERT INTO tb_roles(id_role, NOME_ROLE) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tb_roles(id_role, NOME_ROLE) VALUES (2, 'ROLE_CLIENTE');


INSERT INTO tb_PRODUTOS(id_produto,produto,valor,descricao_tecnica) VALUES (1, 'celular LG',3000, 'meio capenga mas dá pro gasto');
INSERT INTO tb_PRODUTOS(id_produto, produto,valor,descricao_tecnica) VALUES (2, 'Computador Positivo',10000.00, 'dá nem pra baixar o google');
INSERT INTO tb_PRODUTOS(id_produto, produto,valor,descricao_tecnica) VALUES (3, 'geladeira que congela',2000.00, 'dá pra gelar a carne');
INSERT INTO tb_PRODUTOS(id_produto, produto,valor,descricao_tecnica) VALUES (4, 'Caneca',20.00, 'dá pra tomar café');


INSERT INTO tb_categorias(id_categoria, nome) VALUES (1, 'eletrodomésticos');
INSERT INTO tb_categorias(id_categoria, nome) VALUES (2, 'roupas');
INSERT INTO tb_categorias(id_categoria, nome) VALUES (3, 'masculinos');
INSERT INTO tb_categorias(id_categoria, nome) VALUES (4, 'femininos');
INSERT INTO tb_categorias(id_categoria, nome) VALUES (5, 'informática');


INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (1, 'https://criticalhits.com.br/wp-content/uploads/2021/07/jotaro_kujo3.jpeg', 1);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (2, 'https://sm.ign.com/ign_br/tv/o/one-piece-/one-piece-2_1xby.jpg', 1);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (3, 'https://sucodemanga.com.br/wp-content/uploads/2021/04/jojos-bizarre-adventure-image.jpg', 1);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (4, 'https://img.olhardigital.com.br/wp-content/uploads/2021/09/one-piece-scaled.jpg', 2);
INSERT INTO tb_imagens(id_imagem, imagem, id_produto) VALUES (5, 'https://cdn.ome.lt/AGtMp6IIvx6K2iRVZTZ9xjY6rbg=/770x0/smart/uploads/conteudo/fotos/Jojos_Bizarre_Adventure.jpg', 2);

INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (1, 'singed@gmail.com', 'Singed', '12345', '(11)91234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (2, 'grongos@gmail.com', 'Gragas', '12345', '(11)92234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (3, 'zedao@gmail.com', 'Zed', '12345', '(11)93234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (4, 'tristana@gmail.com', 'Tristana', '12345', '(11)94234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (5, 'caitlyn@gmail.com', 'caitlyn', '12345', '(11)95234-5678');
INSERT INTO tb_clientes(ID_USUARIO, EMAIL, NOME, PASSWORD, TELEFONE) VALUES (6, 'lux@gmail.com', 'Lux', '12345', '(11)96234-5678');

INSERT INTO tb_pessoa_fisica(CPF, ID_USUARIO) VALUES ('123.456.789-11', 1);
INSERT INTO tb_pessoa_fisica(CPF, ID_USUARIO) VALUES ('123.456.789-12', 2);
INSERT INTO tb_pessoa_fisica(CPF, ID_USUARIO) VALUES ('123.456.789-22', 3);

INSERT INTO tb_pessoa_juridica(RAZAO_SOCIAL, CNPJ, ID_USUARIO) VALUES ('empresa1','31.406.344/0001-29', 4);
INSERT INTO tb_pessoa_juridica(RAZAO_SOCIAL, CNPJ, ID_USUARIO) VALUES ('empresa2','77.343.787/0001-19', 5);
INSERT INTO tb_pessoa_juridica(RAZAO_SOCIAL, CNPJ, ID_USUARIO) VALUES ('empresa3','00.162.796/0001-89', 6);

INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(7, 'adm1@gmail.com', 'admin1', '12345');
INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(8, 'adm1@gmail.com', 'admin1', '12345');
INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(9, 'adm1@gmail.com', 'admin1', '12345');
INSERT INTO tb_administradores(ID_USUARIO, EMAIL, NOME, PASSWORD) VALUES(10, 'adm1@gmail.com', 'admin1', '12345');