# SimpleOrderingSystem

**Uma API REST para gerenciamento de pedidos, produtos, categorias e usuários. Permite criar, listar, atualizar e deletar entidades do sistema de pedidos.**

<br><br>
## Linguagens e Tecnologias

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Maven
- H2 Database 
- PostgreSQL 


## Práticas Adotadas

- API RESTful
- Consultas e persistência com Spring Data JPA
- Injeção de dependências com Maven
- Testes automatizados
- Estrutura modular (Controllers, Services, Repositories, Entities)
- Configuração para múltiplos ambientes (H2 e PostgreSQL)


## Rodando o Projeto

1. Clone o repositório:
   <br>```git clone git@github.com:aa-abnerandrade/simpleorderingsystem.git```
2. Abra o diretório na sua IDE. No terminal integrado, execute:
   <br>```mvn clean package```
3. Execute a aplicação:
   <br>```java -jar target/simpleorderingsystem-0.0.1-SNAPSHOT.jar```
4. Acesse a API:
   <br>**_localhost:8080_**


## Endpoints Exemplos

- Criar Pedido
```cURL
curl --location 'localhost:8080/orders' \
--header 'Content-Type: application/json' \
--data '{
    "userId": 1,
    "items": [
        {"productId": 2, "quantity": 3}
    ]
}'
```

- Listar Produtos
```cURL
curl --location 'localhost:8080/products'
```

- Atualizar Categoria
```cURL
curl --location --request PUT 'localhost:8080/categories/1' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Nova Categoria"
}'
```

- Deletar Usuário
```cURL
curl --location --request DELETE 'localhost:8080/users/1'
```

## Autoria

### Autoria

Abner Andrade

<div style="display: flex;">
    <a href = "https://www.linkedin.com/in/abnerandrade/"><img src="https://img.icons8.com/color/64/null/linkedin-2--v1.png" target="_blank"></a>
    <a href = "https://api.whatsapp.com/send?phone=5521973257039&text=Oi,%20Abner.%20Curti%20teu%20GitHub.%20%20Vamos%20trabalhar%20juntos?"><img src="https://img.icons8.com/color/64/null/whatsapp--v1.png" target="_blank"></a>
    <a href = "mailto:aa.abnerandrade@outlook.com"><img src="https://img.icons8.com/fluency/64/null/microsoft-outlook-2019.png" target="_blank"></a>
</div>