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
- **MySQL**
- **Jakarta Persistence API**
- **Dotenv** 

## ⚙️ Pré-requisitos

- Java 17+
- Maven 3.6+
- MySQL Server

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
DB_DRIVER=com.mysql.cj.jdbc.Driver
INTEGRATOR_ACCESS_TOKEN=MERCADO_PAGO_ACCESS_TOKEN
```

4. Instale as dependências:
```bash
mvn clean install
```

5. Inicie o projeto:
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

## 🤝 Contribuição

1. Faça um Fork do projeto.
2. Crie uma branch com sua funcionalidade:
```bash
git checkout -b minha-feature
```
3. Commit suas alterações:
```bash
git commit -m 'Minha nova feature'
```
4. Faça um Push:
```bash
git push origin minha-feature
```
5. Abra um Pull Request.

## 📝 Licença

Este projeto está sob a licença MIT.

---

**Desenvolvido com ❤️ por [CAMINHA]**

Caso tenha alguma dúvida, entre em contato!

**Contato:** [Discord](rulex.exe) | [GitHub](https://github.com/lucas-caminha)

