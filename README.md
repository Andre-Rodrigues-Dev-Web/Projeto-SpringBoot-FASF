# FASF-API - Gestão de Alunos (Arquitetura Avançada)

Este projeto é uma API RESTful de nível profissional para gestão de alunos, desenvolvida com **Spring Boot 3.2** e Java 17, seguindo as melhores práticas de Engenharia de Software.

## 🚀 Tecnologias e Padrões Aplicados

- **Spring Boot 3.2**: Core do framework.
- **Spring Data JPA**: Abstração da camada de persistência.
- **H2 Database**: Banco de dados em memória para testes rápidos.
- **Lombok**: Redução de código boilerplate.
- **Springdoc OpenAPI (Swagger)**: Documentação e console de testes.
- **DTO (Data Transfer Objects)**: Desacoplamento do contrato da API das entidades do banco.
- **Global Exception Handling**: Tratamento centralizado de erros com respostas padronizadas.
- **Bean Validation**: Validação rigorosa de inputs.
- **Auditing**: Timestamps automáticos de criação e modificação.

---

## 🛠️ Passo a Passo para Executar o Projeto

Siga estas instruções para rodar o projeto em seu ambiente local:

### 1. Pré-requisitos
- **Java JDK 17** ou superior.
- **Maven 3.6+** (se não quiser usar o wrapper).
- Git (opcional, para clonar).

### 2. Preparação
Abra o seu terminal e navegue até a pasta do projeto:
```bash
cd /Users/andrelaurentinorodrigues/Documents/GitHub/Projeto-SpringBoot-FASF
```

### 3. Compilação e Instalação
Compile o projeto para baixar as dependências e verificar erros:
```bash
chmod +x mvnw
./mvnw clean install
```

### 4. Execução da API
Inicie o servidor utilizando o Wrapper do Maven:
```bash
./mvnw spring-boot:run
```
Aguarde o log mostrar: `Started FasfApiApplication in ... seconds`.
A API estará disponível em: **`http://localhost:8080`**

---

## 🍎 Configuração e Execução no MacOS

Se você está utilizando um Mac, siga estes passos específicos para garantir que o ambiente esteja correto:

### 1. Verificar Versão do Java
O projeto requer **Java 17** ou superior. No terminal, verifique sua versão:
```bash
java -version
```
*Se a versão for inferior a 17, você precisará atualizar o JDK.*

### 2. Permissões de Execução
O MacOS pode bloquear a execução do script `mvnw` por questões de segurança ou permissão. Para corrigir, execute *uma única vez* na pasta do projeto:
```bash
chmod +x mvnw
```

### 3. Executando o Projeto
Para iniciar a aplicação, utilize o wrapper do Maven (não é necessário ter Maven instalado globalmente):
```bash
./mvnw spring-boot:run
```

### 4. Solução de Problemas Comuns
*   **Erro "Permission denied"**: Refaça o passo 2 (`chmod +x mvnw`).
*   **Erro "Java version warning"**: Certifique-se de que sua variável `JAVA_HOME` aponta para o JDK 17+.
*   **Erro de Porta (8080 em uso)**: Libere a porta ou altere a configuração no `application.properties`.

---

## 📖 Testando a API com Swagger UI

O Swagger oferece uma interface visual completa para testar todos os endpoints. 

> [!IMPORTANT]
> Se você receber um erro de 404 ao acessar o Swagger, verifique se a aplicação iniciou corretamente no terminal.

### Como acessar:
1. Com a aplicação rodando, abra seu navegador.
2. Acesse: **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**
   * (A URL padrão é redirecionada para `/swagger-ui/index.html`)

### Como testar:
1. Na lista de "Student Management", escolha um endpoint (Ex: `POST /api/students`).
2. Clique em **"Try it out"**.
3. No corpo do JSON, preencha os dados (nome, email, data de matrícula).
4. Clique em **"Execute"**.
5. O Swagger mostrará a resposta (201 Created) e o aluno cadastrado.

---

## 📌 Endpoints Disponíveis

- `GET /api/students`: Listagem paginada (use `page` e `size` como parâmetros).
- `GET /api/students/all`: Listagem completa sem paginação.
- `GET /api/students/{id}`: Busca detalhada por ID.
- `POST /api/students`: Cadastro de novo aluno (Requer Validação).
- `PUT /api/students/{id}`: Atualização de dados.
- `DELETE /api/students/{id}`: Remoção física do registro.

---

## 🗄️ Console do Banco de Dados (H2)

Para visualizar os dados reais salvos na memória:
- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:fasfdb`
- **User**: `sa` | **Password**: `password`

---

Developed for FASF-SpringBoot Project by Antigravity.

