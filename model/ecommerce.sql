reate database ecommerce;

create table usuario(
    id int AUTO_INCREMENT PRIMARY KEY,
    nome char(60) not null,
    email char(60) unique,
    endereco char(60),
    senha char(60) not null
);


create table categoria(
    id int AUTO_INCREMENT PRIMARY KEY,
    descricao char(60) not null
);
 
create table compra(
    id int AUTO_INCREMENT PRIMARY KEY,
    idUsuario int,
    dataHora timestamp not null,
    FOREIGN KEY (idUsuario) REFERENCES usuario(id)
);

create table produto(
    id int AUTO_INCREMENT PRIMARY KEY,
    descricao char(60) unique not null,
    preco  float(5,2),
    quantidade int not null,
    foto char(60) unique
);

create table item(
    id int AUTO_INCREMENT PRIMARY KEY,
    idProduto int not null,
    idCompra int not null,
    preco  decimal(5,2),
    quantidade int not null,
    FOREIGN KEY (idProduto) REFERENCES produto (id),
    FOREIGN KEY (idCompra) REFERENCES compra(id)
);