# Exercício - Sistema de Cadastro de Pessoas para Desktop em Banco MySQL utilizando DAO para a IDE NetBeans.

## Contextualização

 - O projeto foi desenvolvido no NetBeans deve ser chamado exercicio_cadastropessoa_desktop_bd_dao_netbeans.<br>
 - Programa desenvolvido no Java Development Kit 1.8.<br>
 - Utiliza o Apache Maven para a automatização da construção.<br>
 - Este programa possui diversas classes organizada nos pacotes: principal, visao, modelo e dao.<br>
 - Utiliza o Data Acess Object (DAO) para abstrair o bancos de dados MySQL.<br>
 - Toda iteração com banco de dados é tratada diretamente pelo DAO.<br>
 - Os dados de configuração(Servidor, Database, Usuario, Senha) da integração do java com o banco de dados estão no arquivo src/dao/DadosBanco.java.<br>
 - Dependência do Driver JDBC foi especificada no arquivo pom.xml.<br>
 - O Driver de conexão com o MySQL e espeficado na classe Conexao.java.<br>
 - Crie o banco de dados antes de executar o programa, as especificações da tabela estão no arquivo banco.sql.<br>
 - A pasta src contêm os fontes do projeto.<br>
 - A interface gráfica foi construída **com** o auxílio da IDE NetBeans.<br>

## Arquivos

- banco.sql - Script do banco de dados.
- pom.xml - Arquivo de configuração da ferramenta de automação Maven.

## Enunciado do problema

### Questão 1

Desenvolva um sistema desktop em Java para cadastrar pessoas em um banco de dados. As informações que cada pessoa deve preencher são as seguintes: Nome, Idade, Data Nascimento, Cidade e Estado Civil. Para o campo estado civil deve ser usado um botão de radio para as opções casado, solteiro e viúvo.  A tabela e o banco de dados têm o nome “pessoa”. A tabela tem a seguinte estrutura:

CREATE TABLE Pessoa (
	pessoaID        INTEGER NOT NULL AUTO_INCREMENT,    	 
	nome            VARCHAR(50) NOT NULL,     
	idade           INTEGER,	
	dataNascimento  Date,
	cidade          VARCHAR(25),
	estadoCivil     VARCHAR(20),	
	PRIMARY KEY(pessoaID)    
);

O layout do formulário é apresentado abaixo:

![tela1](tela1.png)  

Este interface gráfica, além dos campos, possui seis botões. O botão com o nome "Sair" fecha a janela e sai do sistema. O botão com o nome “Limpar” limpa as caixas de texto da janela. Quando for clicado, o botão “Salvar” enviará as informações ao banco de dados. A caixa de texto para o nome da pessoa deve ter o seu preenchimento obrigatório, faça a validação. As funcionalidades dos outros botões serão implementadas posteriormente.

Desenvolva uma interface gráfica baseada em JFrame do pacote Swing para o cadastro de pessoas, contendo as informações acima. Utilize o banco de dados de sua preferência. Ao final do processamento deve ser exibida uma mensagem informando se o usuário conseguiu ou não realizar a inclusão dos dados.

Você deve apresentar todo o código fonte utilizado para desenvolver a interface e a inclusão no banco de dados. Outras interfaces gráficas podem ser criadas para integrar as funcionalidades do sistema se for necessário.

### Questão 2

Você já realizou a inclusão dos dados de pessoas no banco de dados na questão 1. Agora é necessário listar os dados das pessoas que estão armazenados no banco de dados. A chamada desta funcionalidade será através do botão chamado “Listar” da questão anterior. As informações e o layout dos dados a serem exibidos são apresentados na figura abaixo:

![tela2](tela2.png) 

Desenvolva uma interface gráfica baseada em JFrame que contêm um componente JTable para exibir os dados das pessoas armazenadas.  Utilize o mesmo banco e tabela da questão 1. Ao se clicar no botão “Fechar” deve se retornar a janela anterior.

Você deve apresentar todo o código fonte utilizado para desenvolver o cadastro. Outras interfaces gráficas podem ser criadas para integrar as funcionalidades do sistema.

### Questão 3

Após realizar a listagem dos dados na questão 2, é necessário disponibilizar uma interface gráfica para a alteração dos dados das pessoas que estão armazenados no banco de dados. Para localizar a pessoa cujos dados devem ser alterados é necessário ser informado um o id da pessoa. A interface deve ter o seguinte formato:

![tela3](tela3.png)  

Esta interface gráfica deve ser chamada pelo botão “Alterar” da interface gráfica da questão 1.

Logo após a digitação do id os dados da pessoa devem ser exibidos na interface gráfica desenvolvida na questão 1 para que sejam alterados. Se o id da pessoa não existir, deve ser exibida uma mensagem ao usuário. O botão “Cadastrar” altera os dados da pessoa. Utilize o mesmo banco e tabela da questão 1. 

Você deve apresentar todo o código fonte utilizado para desenvolver o cadastro. Outras interfaces gráficas podem ser criadas para integrar as funcionalidades do sistema.


### Questão 4

Com as funcionalidades de inclusão, listagem e alteração dos dados das pessoas prontas, agora é necessário disponibilizar a interface gráfica para a exclusão dos dados de pessoas que estão armazenados no banco de dados. Para localizar a pessoa a ser excluído do banco de dados é necessário ser informado um id da pessoa. A interface gráfica deve ter o seguinte formato:

![tela4](tela4.png)  

Esta interface gráfica deve ser chamada pelo botão “Excluir” da interface gráfica da questão 1.

Logo após a digitação do id, todos os dados da pessoa que foi localizado deve ser exibido na interface gráfica desenvolvida na questão 1 e logo após é exigido a confirmação da exclusão com a interface a seguir:

![tela5](tela5.png)   

Se o id da pessoa não existir, deve ser exibida uma mensagem ao usuário. Utilize o mesmo banco e tabela da questão 1. 

Você deve apresentar todo o código fonte utilizado para desenvolver o cadastro. Outras páginas podem ser criadas para integrar as funcionalidades do sistema. 

