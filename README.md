# Board DIO - Desafio Java com Gradle

## 📄 Sobre o Projeto

O **Board DIO** é um projeto desenvolvido como parte de um desafio prático da Digital Innovation One (DIO). Ele simula a gestão de quadros e colunas de um sistema estilo *Kanban*, com funcionalidades que envolvem criação, leitura e manipulação de dados relacionados a colunas, quadros e cartões.

O projeto foi estruturado em **Java 21** com **Gradle** como gerenciador de dependências e build, adotando boas práticas de organização em camadas:

* **DTOs (Data Transfer Objects)**: Transferência de dados entre as camadas.
* **Exceptions**: Tratamento de erros específicos.
* **Persistence**: Configuração de conexão, DAOs e entidades.
* **Services**: Lógica de negócio.
* **Main**: Ponto de entrada da aplicação.

---

## 💡 Tecnologias Utilizadas

* **Java 21**
* **Gradle**
* **JDBC**
* **Liquibase** (migrações de banco de dados)

---

## 🔗 Estrutura de Pastas

```
src/main/java/br/com/dio/
├️ Main.java
├️ dto/
├️ exception/
├️ persistence/
└️ service/
```

---

## 🔧 Como Executar o Projeto

### Requisitos

* Java 21 instalado
* Gradle instalado (ou usar o wrapper incluso no projeto)
* Banco de dados configurado conforme `application.properties` ou `application.yml`

### Passos

```bash
# Clonar o repositório
git clone <url-do-repositorio>

# Acessar a pasta do projeto
cd board_dio

# Compilar e rodar com Gradle
./gradlew run
```

---

## 🌟 Melhorias Implementadas

**Tratamento Global de Exceções**

Foi adicionada a classe `GlobalExceptionHandler` para capturar e tratar qualquer exceção não tratada em tempo de execução.

### Como funciona

```java
public class GlobalExceptionHandler {
    public static void register() {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println(String.format("Ocorreu um erro inesperado: %s", throwable.getMessage()));
            System.err.println("Por favor, verifique os logs para mais detalhes.");
        });
    }
}
```

E no `Main.java`:

```java
public static void main(String[] args) {
    GlobalExceptionHandler.register();
    // restante do código
}
```

> **Nota:** O uso de `String.format()` em vez de concatenação com `+` foi adotado para seguir um padrão mais profissional e legível, especialmente em mensagens formatadas, reforçando boas práticas de código.

### Por que essa melhoria é importante?

* Evita a exposição de *stack traces* completos para o usuário final.
* Melhora a experiência de uso, exibindo mensagens mais claras.
* Facilita o debug e a manutenção, centralizando o tratamento de erros.
* Boa prática em aplicações de qualquer porte.

---

## 📊 Possíveis Evoluções Futuras

* Adicionar testes unitários e de integração.
* Criar uma camada REST para exposição via API.
* Implementar logs com biblioteca como **SLF4J** ou **Log4j**.
* Criar interface gráfica ou integração web.

---

💼 **Autor**: Desenvolvido para o desafio da [DIO](https://web.dio.me)
