# Spring CRUD - Sistema de Cadastro de Usuários

Este projeto é uma API REST desenvolvida em Java com Spring Boot, conectada a um banco de dados PostgreSQL. Ela permite operações completas de CRUD (Create, Read, Update, Delete) sobre uma entidade de usuários, utilizando boas práticas de estruturação e organização de código.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- BeanUtils (para mapeamento entre DTO e Model)
- Validação com @Valid
- UUID como identificador único
- Insomnia (para testes de requisição)
- DBeaver (gerenciamento do banco)

## Funcionalidades da API

| Método | Endpoint               | Descrição                      |
|--------|------------------------|--------------------------------|
| GET    | /usuarios              | Lista todos os usuários        |
| GET    | /usuarios/{id}         | Retorna um usuário por ID      |
| POST   | /usuarios              | Cadastra um novo usuário       |
| PUT    | /usuarios/{id}         | Atualiza os dados de um usuário|
| DELETE | /usuarios/{id}         | Remove um usuário do sistema   |

A API retorna status HTTP apropriados (200, 201, 404) e respostas em JSON.

## Estrutura do projeto

src
└── main
└── java
└── com.dia312.springcrud
├── controller -> UsersController.java
├── dto -> UsersRecordDto.java
├── model -> UsersModel.java
└── repository -> Interface de persistência
└── resources
└── application.properties -> Configuração do banco


## Banco de dados

A aplicação utiliza PostgreSQL com a base de dados `dia312`, contendo a tabela `users`, com os seguintes campos:

- id (UUID)
- nome
- email
- senha

As consultas e manipulações no banco foram realizadas com o auxílio do DBeaver.

## Testes de requisição

As requisições foram testadas utilizando o Insomnia, com visualização clara dos retornos e validações por status code, incluindo:

- 200 OK
- 201 Created
- 404 Not Found

## Possíveis melhorias futuras

- Implementar criptografia de senha com BCrypt
- Adicionar validações mais robustas para entrada de dados
- Documentação da API com Swagger
- Implementar paginação e ordenação de resultados
- Publicar a API em ambiente cloud (Render, Heroku)
- Criar testes unitários e de integração com JUnit/Mockito
- Tratar exceções globalmente com @ControllerAdvice
- Criar frontend com React ou outra tecnologia para consumo da API

## Autor

Gabriel de Souza Brasil  
GitHub: [@souzagabs](https://github.com/souzagabs)

Projeto desenvolvido como prática de backend com Java e Spring Boot, para fins educacionais e composição de portfólio profissional.
