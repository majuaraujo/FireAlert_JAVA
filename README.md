# FireAlert_JAVA
Sistema desenvolvido com foco na ajuda ao combate otimizado e tecnologico a queimadas no Brasil.

## 👩‍💻 Desenvolvido por

- Maria Julia Araujo Rodrigues  RM 553384
- Projeto Global Solution 2025 – FIAP – Engenharia de Software - 2ESPR

-----

## OBJETIVO

Este sistema simula de forma automática focos de incêndio, emite alertas, notificações de ocorrências e as atribui a agentes ambientais para atendimento (se for o caso).

-----

## 🚀 TECNOLOGIAS USADAS

- Java 17
- Spring Boot
- Spring Data JPA
- SpringDoc OpenAPI (Swagger)
- H2 Database (em memória)
- Maven
- Postman (para testes)

----

## ⚙️ EXECUÇÃO DO PROJETO (siga o passo a passo abaixo):

## REQUISITOS:
- IDE compatível com Java (Ex: Intellij)
- Maven

## ✅ PASSO A PASSO:

1. Clone o repositório  
```bash
git clone https://github.com/majuaraujo/FireAlert_JAVA.git
```

2. 🌐 Acesse a API
Após rodar a aplicação, você pode acessar o Swagger para visualização dos testes que o console irá reproduzir e até mesmo cadastrar manualmente seus próprios sensores.

> Acesse: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

3. 🗄️ Acesse a Banco de Dados (H2)
O banco de dados também ficará disponível (lembrando que ele é in memory)
Utilize o seguinte perfil de acesso:

**Credenciais:**
- JDBC URL: `jdbc:h2:mem:firealertdb`
- Usuário: `sa`
- Senha: *(em branco)*

> Acesse: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

----

## TESTES PRONTOS (POSTMAN):

A importação dos testes de todos os endpoints está disponibilizada no arquivo JSON neste repositório.

### ✅ PASSO A PASSO:
1. Abra o Postman
2. Clique em **Import**
3. Selecione o arquivo:
```
firealert.postman_collection.json
```

## ⚙️ FUNCIONALIDADES DESTA APLICAÇÃO

- 📡 Criação automatizada dos sensores e agentes ambientais
- 🔥 Simulação de ação real ao combate aos focos de incência (com diferentes intensidades)
- 🚁 Respostas a incidentes automatizadas: drone, alerta ou ocorrência
- 🔔 Notificação por gravidade para a tomada de decisão (leve, moderada, crítica)
- 🔍 Filtros por tipo de gravidade e agente de atendimento
- 📊 Interface Swagger interativa
- 🧩 Arquitetura pensada para ser limpa e em camadas (MVC)




