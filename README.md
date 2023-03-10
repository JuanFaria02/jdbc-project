# jdbc-project

O projeto foi criado para relatar meus aprendizados conectando à um banco de dados usando Java e a API do JDBC. Nesse projeto eu usarei mySQL. 

Os primeiros passos nesse projeto foram: 

* Criar um arquivo properties com as propriedades do banco de dados 
* Realizar a conexão com o banco de dados usando uma classe própria para isso com métodos estáticos 
* Testar essa conexão na classe principal 

------

## Recuperação de dados 

Com a conexão estabelecida, primeiro de tudo eu aprendi a recuperar dados usando o Statement e ResultSet. 

O Statement é uma interface que executa as consultas SQL no SGBD. Ao usar o Statement e realizar a consulta é feito logo em seguida a recuperação desses dados com o ResultSet é possível acessar esses dados. O cursor aponta para o primeiro registro e usando o .next() é possível percorrer os registros. 

-----
## Inserção, atualização e exclusão de dados 

A inserção, atualização e exclusão são feitas por meio do PreparedStatement que também executa consultas SQL mas é possível parametrizar as consultas enquanto no Statement elas já devem estar "prontas", ou seja, com os valores embutidos. 

-------
## Transação 

Para uma transação ocorrer ela não pode ser feita pela metade, por exemplo, ao transferir dinheiro de uma conta para a outra não pode ocorrer um erro que faça o dinheiro ser debutado de uma conta mas não ser creditado na outra. Portanto, deve ser garantido a operação do início ao fim para que não haja problemas e essa garantia é estabelecida pela API do jdbc por meio dos métodos **setAutoCommit**, **commit** e **rollback**. 

* setAutoCommit: É passado como parâmentro o valor false e então a operação não é feita até que toda transação seja feita.
* commit: O commit é como se "mudasse" o valor do parâmetro para true pois assim que o commit é feito a transação ocorre no banco de dados 
* rollback: Restaura o banco de dados se houver algum erro. 


----------
## Data Access Object (DAO) 

Após entender mais sobre as conexões e os métodos principais da API do JDBC então é hora de entender sobre o padão de acesso a dados chamado DAO.

O DAO é um padrão de projetos em que o objeto provê uma interface que realiza uma abstração do acesso a dados, lê e grava a partir de uma origem de dados além de encapsular o acesso de forma em que as demais classes não "sabem" sobre esse acesso. Esse padrão surge a partir do momento em que se precisa separar a lógica de negócios com a lógica de acesso a dados, as Classes DAO ficam encarregadas de trocar informações com o SGBD e fornecer as operações CRUD e pesquisas, elas precisam ser capazes de buscar dados no banco e transformar os dados em objetos ou lista de objetos.

#### Arquitetura 
Em uma aplicação web seguindo o modelo MVC, as classes DAO ficam junto com o Model realizando o suporte, integrando a fonte de dados ao modelo de objetos do sistema.
#### Responsabilidade

O DAO deve seguir o princípio de responsabilidade única e ser responsável apenas pelo acesso a dados. Portanto, cada método do DAO deve fazer uma única leitura ou gravação no banco de dados e não deve controlar transações ou realizar operações adicionais, como por exemplo realizar alterações nos dados recebidos da camada de serviço.  
