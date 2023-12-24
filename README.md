# Projeto Pet Store - Guice

## Visão Geral

Este projeto implementa uma aplicação Pet Store usando Java 17, Maven e Google Guice. A Pet Store permite aos usuários gerenciar cadastros e serviços de animais de estimação, adicionar serviços como banhos e tosas, e visualizar os pets mais bem-sucedidos com base na receita gerada.

## Tecnologias Utilizadas

- Java 17
- Maven
- Google Guice

## Estrutura do Projeto

O projeto está organizado em pacotes:

- `model`: Contém as classes Pet e TipoDeServico representando animais de estimação e serviços.
- `decorator`: Implementa o padrão decorator para serviços, incluindo Banho e Tosa.
- `builder`: Fornece construtores para criar instâncias de Pet e TipoDeServico.
- `service`: Define a classe PetService para gerenciar animais de estimação e serviços.
- `app`: Contém a classe Main para executar a aplicação Pet Store.
- `test`: Inclui testes JUnit para a classe PetService.

## Como Utilizar

1. Clone o repositório:

```bash
git clone <repository-url>
cd pet-store-project
```

2. Compile o projeto usando o Maven:

```bash
mvn clean install
```

3. Execute a Aplicação:

````bash
java -jar target/pet-store-project.jar
`````

4. Visualize a saída da aplicação no console, demonstrando várias funcionalidades, como adição de pets, aplicação de serviços e recuperação de informações.

## Exemplos de Uso:

```java
// Criando um Pet
PetConstrutor pb = injector.getInstance(PetConstrutor.class);
Pet goku = pb.comId(1)
        .comNome("Goku")
        .comRaca("Labrador")
        .comIdade(1).criar();

// Adicionando um Pet ao PetService
ps.addPet(goku);

// Aplicando serviços a um Pet
Banho banhoSecoComPerfume = new BanhoSeco(new BanhoPerfumado(new BanhoSimples()));
ps.comBanho(1, banhoSecoComPerfume);

// Recuperando informações
System.out.println("Informações do Pet: " + ps.pesquisarPetPorId(1).orElse(null));
System.out.println("Histórico de Serviços: " + ps.tipoDeServicoList(1));

// Funcionalidades adicionais
// ...

```

## Testes Unitários:

O projeto inclui testes JUnit para garantir a correção da classe PetService. Execute os testes usando:

```bash
mvn test
```

Sinta-se à vontade para explorar mais funcionalidades e casos de uso conforme necessário.