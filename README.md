# README.md

## Ada User Management System

### Descrição
Este projeto é um sistema de gerenciamento de usuários que permite cadastrar, verificar e buscar usuários. O sistema inclui serviços de envio de e-mail para boas-vindas e verificação de conta.

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   ├── br/com/ada/entity/
│   │   │   └── User.java
│   │   ├── br/com/ada/repository/
│   │   │   └── UserRepository.java
│   │   ├── br/com/ada/service/
│   │   │   ├── UserService.java
│   │   │   └── EmailService.java
├── test/
│   ├── java/
│   │   ├── br/com/ada/service/
│   │   │   └── UserServiceTest.java
```

## Linguagens de Programação

- **Java**: Linguagem principal utilizada para o desenvolvimento do projeto.

## Dependências

- **JUnit**: Para a execução de testes unitários.
- **Mockito**: Para simulação de comportamentos em testes unitários.
- **Spring Framework**: Para injeção de dependências e integração com outros serviços.

### Instruções de Instalação

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/seuusuario/ada-user-management-system.git
    ```

2. **Instale as dependências**:
    Utilize o Maven ou Gradle para instalar as dependências listadas no `pom.xml` ou `build.gradle`.

    ```bash
    mvn install
    # ou
    gradle build
    ```

## Como Rodar o Projeto

1. **Execute a aplicação**:
    ```bash
    mvn spring-boot:run
    # ou
    gradle bootRun
    ```

2. **APIs disponíveis**:
    - **POST /register**: Registra um novo usuário.
    - **GET /user/{email}**: Busca um usuário pelo e-mail.

## Execução de Testes

Execute os testes unitários com o seguinte comando:

```bash
mvn test
# ou
gradle test
```

## Explicação Detalhada dos Arquivos de Código

### `User.java`

#### Funções
- **Classe `User`**: Representa um usuário no sistema.
- **Atributos**:
  - `email`: Endereço de e-mail do usuário.
  - `name`: Nome do usuário.
  - `verified`: Status de verificação do usuário.
- **Métodos**:
  - **Construtor `User(String email, String name)`**: Inicializa um novo usuário.
  - **Getters e Setters**: Métodos de acesso para os atributos.

### `UserServiceTest.java`

#### Funções
- **Classe `UserServiceTest`**: Testes unitários para a classe `UserService`.
- **Testes**:
  - **`deveCadastrarUsuarioComSucesso`**: Testa o cadastro de um novo usuário.
  - **`deveRetornarFalsoSeEmailJaExistir`**: Testa o retorno `false` quando o e-mail já existe.
  - **`deveRetornarFalsoSeEnvioDeEmailFalhar`**: Testa o retorno `false` quando o envio de e-mail falha.
  - **`deveRetornarUsuarioPorEmail`**: Testa a busca de um usuário pelo e-mail.

### `UserRepository.java`

#### Funções
- **Interface `UserRepository`**: Define métodos para operações de banco de dados.
- **Métodos**:
  - `saveUser(User user)`: Salva um usuário no banco de dados.
  - `findByEmail(String email)`: Busca um usuário pelo e-mail.
  - `emailExists(String email)`: Verifica se um e-mail já existe no banco de dados.

### `UserService.java`

#### Funções
- **Classe `UserService`**: Gerencia operações relacionadas a usuários.
- **Métodos**:
  - `registerUser(String email, String name)`: Registra um novo usuário.
  - `getUserByEmail(String email)`: Busca um usuário pelo e-mail.

### `EmailService.java`

#### Funções
- **Interface `EmailService`**: Define métodos para o envio de e-mails.
- **Métodos**:
  - `sendWelcomeEmail(User user)`: Envia um e-mail de boas-vindas.
  - `sendVerificationEmail(String email, String verificationCode)`: Envia um e-mail de verificação.

## Exemplos de Uso

### Registro de Usuário

```java
UserService userService = new UserService(userRepository, emailService);
boolean registrado = userService.registerUser("usuario@example.com", "Nome do Usuário");
```

### Busca de Usuário por E-mail

```java
Optional<User> usuario = userService.getUserByEmail("usuario@example.com");
```

## Boas Práticas e Dicas para Contribuir

1. **Pull Requests**: Antes de enviar um PR, certifique-se de que todos os testes estão passando.
2. **Testes**: Escreva testes unitários para novas funcionalidades.
3. **Documentação**: Mantenha a documentação atualizada.
4. **Padrões de Código**: Siga os padrões de código estabelecidos no projeto.
5. **Branches**: Utilize branches para desenvolvimento de novas funcionalidades ou correções de bugs.

## Contribuindo

1. **Fork** o repositório.
2. Clone o seu fork:
    ```bash
    git clone https://github.com/seuusuario/ada-user-management-system.git
    ```
3. Crie uma branch para sua mudança:
    ```bash
    git checkout -b minha-nova-funcionalidade
    ```
4. Faça commit das suas mudanças:
    ```bash
    git commit -am 'Adiciona minha nova funcionalidade'
    ```
5. Faça push para o branch:
    ```bash
    git push origin minha-nova-funcionalidade
    ```
6. Abra um **Pull Request**.

Para mais detalhes, consulte a [documentação](https://docs.maritaca.ai).