# 📦 API de Vendas - Spring Boot

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-orange)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-Messaging-ff6600)
![Database](https://img.shields.io/badge/Database-H2%2FMySQL-lightgrey)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

---

## 📌 Sobre o projeto

API REST desenvolvida com Spring Boot para gerenciamento de vendedores e vendas, incluindo consultas por período e integração com mensageria via RabbitMQ.

---

## 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database (ou MySQL)
* RabbitMQ
* Docker
* Lombok
* Maven

---

## ⚙️ Funcionalidades

### 👤 Vendedores

* Criar vendedor

### 💰 Vendas

* Registrar vendas por vendedor

### 📊 Consultas

* Buscar vendas por período
* Calcular média de vendas

### 📩 Mensageria

* Integração com RabbitMQ para processamento assíncrono

---

## 📂 Estrutura do projeto

```text id="proj1"
com.ampedro.vendas
├── controller
├── service
├── repository
├── model
│   ├── entity
│   └── dto
├── config
└── VendasApplication.java
```

---

## ⚙️ Como executar o projeto

### 1. Clonar o repositório

```bash id="cmd1"
git clone https://github.com/AmaralPedro1981/vendas-api
```

---

### 2. Subir RabbitMQ (Docker)

```bash id="cmd2"
docker run -d --hostname rabbit-host --name rabbitmq \
-p 5672:5672 \
-p 15672:15672 \
rabbitmq:3-management
```

Acesse:

```text id="url1"
http://localhost:15672
```

Login:

```text id="login1"
guest / guest
```

---

### 3. Executar aplicação

```bash id="cmd3"
mvn spring-boot:run
```

---

## 🔗 Endpoints principais

### Vendedores

```http id="ep1"
POST /vendedor
```

### Vendas

```http id="ep2"
POST /vendas
```

### Consultas

```http id="ep3"
POST /consultas/vendas
POST /consultas/vendas/media
```

---

## 📌 Exemplo de request

```json id="req1"
{
  "idVendedor": 1,
  "dataInicial": "2026-05-01",
  "dataFinal": "2026-05-31"
}
```

---

## 🧠 Conceitos aplicados

* API REST
* Arquitetura em camadas
* DTO pattern
* Validação com Bean Validation
* Mensageria com RabbitMQ
* Docker
* Injeção de dependência
* Tratamento de HTTP status

---

## 👨‍💻 Autor

Pedro Amaral
GitHub: https://github.com/AmaralPedro1981

---

## 📌 Observação

Projeto desenvolvido para fins de estudo de backend Java com foco em arquitetura e integração de sistemas.
