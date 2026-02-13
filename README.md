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

### Windows — Pré-requisitos e Configuração
Siga estes passos no Windows para preparar e executar o projeto:

- **Instalar JDK (recomendado):** instale o **Java 17 (LTS)** para máxima compatibilidade com Spring Boot 3.x. O projeto foi testado localmente com **Java 24.0.2**, mas para CI/produção recomendamos JDK 17.
   - Baixe o OpenJDK ou Oracle JDK e instale normalmente.
   - Configure `JAVA_HOME` apontando para a pasta do JDK (ex.: `C:\Program Files\Java\jdk-17`).
   - Adicione `%JAVA_HOME%\bin` ao `PATH`.

- **Verificar Java instalado:** no PowerShell execute:
   ```powershell
   java -version
   echo $env:JAVA_HOME
   ```

- **Usar o Maven Wrapper que acompanha o projeto:** o repositório contém um helper `mvnw.cmd` para Windows. Para garantir permissões e execução correta, rode os comandos no PowerShell a partir da raiz do projeto:
   ```powershell
   # Compilar e executar testes
   .\mvnw.cmd clean install

   # Rodar apenas os testes
   .\mvnw.cmd test

   # Executar a aplicação
   .\run-wrapper.bat spring-boot:run
   ```

- **Portas e URLs**
   - Aplicação: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui/index.html`
   - H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:fasfdb`, user: `sa`, senha: `password`)

- **Se ocorrer erro relacionado ao Actuator ou endpoints de gerenciamento:** adicione `spring-boot-starter-actuator` e habilite endpoints no `application.properties` (opção opcional — veja seção de diagnóstico abaixo).

Observação: se preferir usar uma instalação do Maven em vez do wrapper, instale Maven e use `mvn clean install` normalmente.

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

