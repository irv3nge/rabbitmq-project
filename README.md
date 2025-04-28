# 🐇📦 RabbitMQ + Spring Boot + PostgreSQL - Sistema de Processamento de Pedidos

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen?logo=spring-boot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.12-orange?logo=rabbitmq)
![License](https://img.shields.io/badge/license-MIT-green)

> Sistema Java Spring Boot que utiliza RabbitMQ e PostgreSQL para o processamento assíncrono de pedidos, com Dead Letter Queue configurada.

---

## 🚀 Tecnologias Utilizadas
- Java 17
- Spring Boot 3
- RabbitMQ (mensageria)
- PostgreSQL (persistência)
- Docker e Docker Compose (infraestrutura local)
- Maven (gerenciamento de dependências)
- Lombok (facilitador de código)

---

## 📋 Funcionalidades
- 📩 Criar pedidos via API REST
- 🛫 Publicar pedidos na fila RabbitMQ
- 🛬 Consumir e processar pedidos da fila
- ⚠️ Redirecionar pedidos inválidos para Dead Letter Queue
- 🔄 Retry automático em mensagens com erro (opcional)

---

## 🗂️ Estrutura de Pastas

```
src/main/java
└── com.exemplo.pedidos
    ├── config          # Configurações do RabbitMQ
    ├── controller      # API REST para criar pedidos
    ├── consumer        # Consumidor das mensagens
    ├── model           # Entidades JPA
    ├── publisher       # Publicador de mensagens
    └── repository      # Repositórios JPA
```

---

## 🐳 Como Rodar o Projeto (Docker + Spring Boot)

1. Clone o repositório:
   ```bash
   git clone https://github.com/irv3nge/rabbitmq-project.git
   cd rabbitmq-project
   ```

2. Crie o arquivo `.env`:
   ```bash
   cp .env.example .env
   ```

3. Suba o RabbitMQ e o Postgres:
   ```bash
   docker-compose up -d
   ```

4. Rode o projeto Spring Boot:
   ```bash
   ./mvnw spring-boot:run
   ```


---

## 📬 Endpoints Disponíveis

| Método | Endpoint | Descrição |
|:------|:---------|:---------|
| POST | `/pedidos` | Cria e envia um novo pedido |

**Exemplo de requisição:**

```json
POST http://localhost:8080/pedidos
Content-Type: application/json

{
    "descricao": "Pedido de notebook",
    "valor": 4500.00
}
```

---

## 📈 Acesso ao RabbitMQ Dashboard

- URL: http://localhost:15672
- Usuário: `guest`
- Senha: `guest`

➡️ Monitorar filas:
- `pedidos.novos` (fila principal)
- `pedidos.novos.dlq` (fila de erros)

---

## 🛡️ Boas Práticas aplicadas
- Separação de responsabilidades (API, Publisher, Consumer)
- Configuração de Dead Letter Queue para resiliência
- Docker Compose para orquestração de serviços
- Uso de variáveis de ambiente para segurança

---

## 👨‍💻 Autor
- **Pedro Jorge**
- Projeto acadêmico e prático de mensageria com Java e Spring Boot.



# ⚡
