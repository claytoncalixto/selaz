# Teste Prático para Desenvolvedor Pleno Back-End em Java e Spring Boot

Este repositório contém o teste prático para a vaga de Desenvolvedor Pleno Back-End em Java e Spring Boot.

## Descrição de download e execução do projeto

Acessar o link do projeto no GitHub:(https://github.com/claytoncalixto/selaz)

1. **Acessar o botão <> Code**:
   - Nesta opção você pode copiar o link e fazer um clone através do comando em um terminal:git clone git@github.com:claytoncalixto/selaz.git 
   - Pode ser feito download do arquivo zip e descompactar em sua pasta de projetos:
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_1.png

2. **Importando o projeto em sua IDE**:
   - Com sua IDE de preferência iniciada, acesse o menu File>Import com a janela aberta navegue até Maven>Existing Maven Projects e clique no botão Next:
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_2.png
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_3.png

   - Na janela Maven Projects no botão Broswer navegue pelo diretorio de pastas até localizar o projeto baixado, selecionando-o, clique no botão Finish:
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_4.png

   - Com projeto importado, o Maven iniciara o download do componentes que levará alguns segundos, após finalizar, clique com botão direito na pasta principal do projeto(Main)>Run As>Srping Boot App para executar a aplicação:
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_5.png

   - Se tudo estiver correto na aba Console mostrará uma tela identica como abaixo e sem erros:
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_6.png

4. **Teste das API's pelo Postman**
   - Se houver o Postman instalado ou qualquer ferramenta de consulta de end point, ou pelo proprio navegador/browser da sua maquina, copoie e cole o link para testar a aplicação, segue os padrões de links para consultas:

   Gerenciamento de Usuário:
   - GET /api/users: Listar todos os usuários: 
     http://localhost:8080/users
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_7.png

   - POST /api/users: Criar um novo usuário: 
     http://localhost:8080/users
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_8.png

   - PUT /api/users/{id}: Atualizar um usuário existente:
     http://localhost:8080/users/3
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_9.png

   - GET /api/users/{id}: Consultar um usuário por id:
     http://localhost:8080/users/1
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_10.png

   - DELETE /api/users/{id}: Deletar um usuário:
     http://localhost:8080/users/7
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_12.png
     

   Gerenciamento de Tarefas:
   - GET /api/tasks: Listar todas as tarefas do usuário autenticado:
     http://localhost:8080/tasks
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_13.png

   - POST /api/tasks: Criar uma nova tarefa:
     http://localhost:8080/tasks
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_14.png

   - PUT /api/tasks/{id}: Atualizar uma tarefa existente:
     http://localhost:8080/tasks/9
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_15.png

   - DELETE /api/tasks/{id}: Deletar uma tarefa:
     http://localhost:8080/tasks/9
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_17.png
      
   - GET /api/tasks/{id}: Consultar uma tarefa por id.
     http://localhost:8080/tasks/10
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_16.png

   - GET /api/tasks?status={status}: Filtrar tarefas por status:
     http://localhost:8080/tasks?status=PENDENTE
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_18.png

   - GET /api/tasks?sort=dueDate: Ordenar tarefas por data de vencimento.

   - GET /api/users/{userId}/tasks: Listar todas as tarefas de um usuário específico:
     https://github.com/claytoncalixto/selaz/blob/main/assets/Screenshot_11.png
   


## Requisitos técnicos aplicados neste projeto

- Java 11 ou superior
- Spring Boot
- Banco de Dados Relacional (H2 para facilitar os teste)
- JPA/Hibernate
- Maven
- Spring Security(desabilitado)
- Spring Data JPA



