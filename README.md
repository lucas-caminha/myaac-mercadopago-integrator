# 🛠️ MyAac X MercadoPago Integrator

Um projeto Spring Boot para integração do MyAac com MercadoPago, focado em geração de pagamentos Pix e consulta de pagamentos.

## 🚀 Funcionalidades

- Integração com MercadoPago para geração de QRCODE e pagamentos Pix.
- Integração com Mercado pago para verificação de pagamento e atualização de valores dentro do MyAac.

## 💻 Tecnologias Usadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MariaDB**
- **Jakarta Persistence API**
- **Dotenv** 

## ⚙️ Pré-requisitos

- Java 17+
- Maven 3.6+
- MariaDB Server

## 📦 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/lucas-caminha/myaac-mercadopago-integrator.git
```

2. Acesse a pasta do projeto:
```bash
cd myaac-mercadopago-integrator
```

3. Crie um arquivo `.env` na raiz do projeto e configure:
```plaintext
DB_URL=JDBC_URL_CONNECTION
DB_USERNAME=USUARIO
DB_PASSWORD=SENHA
DB_DRIVER=org.mariadb.jdbc.Driver
INTEGRATOR_ACCESS_TOKEN=MERCADO_PAGO_ACCESS_TOKEN
```

4. Instale as dependências:
```bash
mvn clean install
```

5. Execute o script SQL para criar a tabela `MPPLAYERPAYMENT`:
```bash
mysql -u USUARIO -p < src/main/resources/schema.sql
```

6. Inicie o projeto:
```bash
mvn spring-boot:run
```

## 🛠️ Estrutura do Projeto
```
/src
|-- main
|   |-- java
|   |   |-- br.com.mercadopago.integrator
|   |       |-- controller
|   |       |-- entity
|   |       |-- repository
|   |       |-- service
|   |       |-- config
|-- resources
|   |-- application.properties
|   |-- schema.sql
|-- .env
|-- pom.xml
```

## 📚 Uso

- Acesse a aplicação via:
```
http://localhost:8080
```
- Consulte a documentação da API, se disponível, pelo Swagger:
```
http://localhost:8080/swagger-ui
```

**Desenvolvido por [CAMINHA]**

Caso tenha alguma dúvida, entre em contato!

**Contato:** [Discord](rulex.exe) | [GitHub](https://github.com/lucas-caminha)

