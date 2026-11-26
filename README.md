# 🏋️ AcademiaFitLife — Sistema de Gestão de Academia

Projeto de portfólio desenvolvido com o objetivo de praticar e aprimorar meus conhecimentos em desenvolvimento de software, utilizando Java e tecnologias modernas para construção de aplicações web.

A proposta é desenvolver um sistema para academia, com interface web e uma API REST responsável pelo gerenciamento de alunos e agendamentos.

## 🚀 Sobre o projeto

O FitLife Academia foi desenvolvido para simular uma aplicação utilizada no dia a dia de uma academia, permitindo o cadastro de alunos e o gerenciamento de agendamentos de atividades.

Durante o desenvolvimento, trabalhei com integração entre Front-end e Back-end, organização de código, persistência de dados e criação de endpoints REST.

## ✨ Funcionalidades

- Cadastro de alunos.
- Consulta de alunos cadastrados.
- Atualização e exclusão de cadastros.
- Agendamento de atividades.
- Validação dos dados enviados à API.
- Verificação de cadastro antes de permitir agendamentos.
- Prevenção de conflitos de horários entre agendamentos confirmados.

## 🛠️ Tecnologias utilizadas

**Back-end**
- Java 21
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL

**Front-end**
- HTML5
- CSS3
- JavaScript

**Ferramentas**
- Git e GitHub
- Docker
- Visual Studio Code

## 📂 Estrutura do projeto

```text
Academia-FitLife/
├── index.html
├── style.css
├── script.js
├── images/
│   └── foto.png
│
└── backend/
    ├── pom.xml
    ├── docker-compose.yml
    └── src/
        └── main/
            └── java/
                └── com/fitlife/academia/
```

## 💻 Como executar o projeto

### Pré-requisitos

- JDK 21
- Maven 3.9 ou superior
- Docker Desktop
- Visual Studio Code ou IntelliJ IDEA

### Executando o banco de dados

Dentro da pasta `backend`, execute:

```bash
docker compose up -d
```

### Executando a API

Ainda na pasta `backend`, execute:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

Para verificar se está funcionando:

```text
http://localhost:8080/api/health
```

### Executando o Front-end

Na pasta principal do projeto, abra o arquivo `index.html` utilizando a extensão Live Server do Visual Studio Code.

## 🔗 Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/health` | Verifica o funcionamento da API |
| GET | `/api/clientes` | Lista os alunos |
| GET | `/api/clientes/{id}` | Consulta um aluno |
| POST | `/api/clientes` | Cadastra um aluno |
| PUT | `/api/clientes/{id}` | Atualiza um aluno |
| DELETE | `/api/clientes/{id}` | Exclui um aluno |
| GET | `/api/agendamentos` | Lista os agendamentos |
| POST | `/api/agendamentos` | Cria um agendamento |

## 📌 Regras implementadas

- Os dados são validados pelo Back-end.
- O aluno precisa estar cadastrado para realizar um agendamento.
- O sistema impede dois agendamentos confirmados no mesmo horário.

## 🎯 Objetivo do projeto

Este projeto faz parte do meu portfólio e representa minha evolução na área de desenvolvimento de software.

Meu objetivo é colocar em prática conhecimentos em Java, Spring Boot, banco de dados, APIs REST e integração entre aplicações, desenvolvendo soluções e evoluindo continuamente como desenvolvedor.

---

**Projeto desenvolvido por mim para fins de aprendizado e portfólio profissional.**