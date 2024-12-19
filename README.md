# Screenmatch

O **Screenmatch** é um sistema desenvolvido em **Java** utilizando o framework **Spring Boot** para realizar buscas e exibir informações detalhadas sobre séries de TV. O projeto se conecta à **OMDb API** para obter dados atualizados sobre séries, como títulos, avaliações, gêneros, atores, entre outros. Além disso, as informações são persistidas em um banco de dados **PostgreSQL** utilizando **JPA (Java Persistence API)**, o que facilita a gestão e consulta das séries buscadas.

## Funcionalidades

- **Busca de Séries**: Realiza consultas à OMDb API para buscar informações detalhadas sobre as séries.
- **Exibição de Detalhes**: Exibe informações como título, avaliação, atores, sinopse e mais.
- **Persistência em Banco de Dados**: As séries buscadas são salvas no banco de dados PostgreSQL para facilitar o acesso e consultas futuras.
- **Tradução de Sinopses**: Utiliza as APIs **MyMemory** e **OpenAI** (desativada no código, mas disponível para ativação) para traduzir as sinopses das séries.

## Tecnologias Utilizadas

- **Java**: Linguagem principal utilizada para o desenvolvimento do sistema.
- **Spring Boot**: Framework utilizado para construção de APIs e gerenciamento de dependências.
- **JPA/Hibernate**: Para persistência de dados no banco **PostgreSQL**.
- **OMDb API**: API utilizada para buscar dados sobre séries de TV.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar as informações das séries.
- **MyMemory API** e **ChatGPT**: APIs para tradução das sinopses das séries.

## Como Funciona

1. **Busca de Séries**: O usuário pode buscar uma série pela sua chave, como nome ou título, utilizando a OMDb API.
2. **Armazenamento no Banco de Dados**: As informações da série, incluindo título, avaliação, gênero, e sinopse, são armazenadas no banco de dados PostgreSQL.
3. **Exibição de Episódios**: O sistema também é capaz de listar os episódios de uma série, com a possibilidade de filtrar e ordenar conforme a necessidade.
4. **Tradução**: As sinopses das séries são traduzidas automaticamente utilizando a **MyMemory API**. Também é possível utilizar a **API do OpenAI** para tradução (a funcionalidade está desativada no código, mas pode ser facilmente ativada).

# Em Desenvolvimento

Este projeto ainda está em desenvolvimento. Algumas funcionalidades podem estar em fase de testes ou não estarem totalmente implementadas. Fique à vontade para acompanhar as atualizações e contribuir com sugestões ou melhorias.

Agradecemos sua compreensão e colaboração!
