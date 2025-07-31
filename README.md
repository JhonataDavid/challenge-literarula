# 📚 Projeto Literalura

Este projeto foi desenvolvido como parte do programa **Oracle Next Education (ONE)** em parceria com a **Alura**, sendo um desafio prático para consolidar os aprendizados em **Java com Spring Boot**.

## 🧠 Objetivo

O Literalura é uma aplicação em terminal que consome dados da API pública [Gutendex](https://gutendex.com/), permitindo ao usuário:

- Buscar e salvar livros e autores em uma base local
- Filtrar autores por idioma ou período de vida
- Visualizar livros ordenados por número de downloads

## ⚙️ Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- MapStruct
- Maven
- Lombok
- Gutendex API

## 🗂️ Organização do projeto

O projeto segue uma arquitetura em camadas:

- `model`: entidades JPA
- `repository`: interfaces para persistência
- `dto`: objetos de transferência de dados (internos e externos)
- `mapper`: mapeamento entre entidades e DTOs com MapStruct
- `service`: regras de negócio
- `view`: interação com o usuário via terminal
- `client`: consumo da API externa
