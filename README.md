# Sistema de Gestão de Atividades Acadêmicas 💻🖱️🧑‍🎓

### Informações Gerais ✨

O presente projeto busca simular um **sistema de gestão de atividades acadêmicas** de uma universidade. O objetivo é aplicar os conceitos de **Orientação à Objetos** que foram lecionados na disciplina de Projeto de Software, da Universidade Federal de Alagoas. A linguagem que escolhi para esse projeto foi _Java_ ☕ (versão 17.0.4 LTS), já que é a mesma utilizada nos exemplos da classe e que eu tinha bastante interesse em me aprofundar. 

Idioma da aplicação: Inglês 

## Como executar o projeto: 👩🏻‍💻

Para a execução do projeto, tenha certeza que o Java está instalado em sua máquina. Caso não esteja, faça a instalação da versão [Java 17.0.4](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) de acordo com o seu sistema operacional. Em seguida, faça o download da pasta _src_ desse repositório abra em um editor de código de sua preferência, como o Visual Studio Code, por exemplo. Por fim,  **execute** o arquivo _Program.java_ e utilize-o. 

### Para realizar o login, use as seguintes credenciais ⚠️ 

* Login: admin
* Senha: 1234

Mas, caso queira recuperar o seu acesso, basta seguir o passo a passo para criar outro usuário e senha no sistema. ✅


### Importante: ‼️

- ⚠️ *OBS:* Tratamento da maioria das Exceções adicionado ✅
- 👃🏻💨 *Code Smells:* É possível identificar _Bloaters_, já que o código está grande e consome responsabilidade de outras classes; _Change Preventers_, visto que alguns pontos podem atingir outros, se houver alterações; e _Couplers_, já que algumas classes dependem de outras.  

## Funcionalidades Implementadas 

1. Criar um novo projeto: ✅
 - É possível criar um projeto de acordo com os seus atributos (nome, data inicial, data final, coordenador, agência de financiamento, descrição do projeto, valor da bolsa e colaboradores).
2. Iniciar um projeto: ✅
  - Encontrar um projeto de acordo com o seu nome e iniciá-lo, caso esteja previamente cadastrado.
3. Encerrar um projeto: ✅
  - Encontrar um projeto e encerrá-lo, caso esteja previamente cadastrado.
4. Alocar um colaborador a um projeto: ✅
  - Cadastrar um colaborador para participar de um projeto. Caso o projeto já esteja em andamento, não é possível alocar o colaborador (de acordo com sua função: Professor, estudante graduação, estudante mestrado, estudante doutorado, pesquisador, técnico, analista, testador ou desenvolvedor) e o mesmo não pode participar de dois projetos ao mesmo tempo. 
5. Criar uma publicação de um projeto: ✅
  - É possível criar uma publicação de um projeto desenvolvido, de acordo com os seus atributos. 
6. Orientação e Gerenciamento de Atividades: ✅
  - É possivel realizar o gerenciamento de atividades e orientações que cada professor pode realizar. Não é possível realizar atividades sem orientação e um professor deve estar alocado a um projeto para realizar a orientação. 
7. Realizar consulta de colaborador: ✅
  - É possível pesquisar sobre um colaborador e o sistema retornará as informações associadas a ele, caso ele esteja cadastrado. 
8. Realizar consulta de projetos: ✅
  - O sistema permite a consulta de projetos e seus atributos, caso esteja previamente cadastrado. 
9. Gerar relatório geral: ✅
  - O sistema é capaz de gerar um relatório geral acerca dos projetos que foram iniciados, finalizados e em andamento, bem como os seus atributos de articipante, valor da bolsa, etc. 
10. Undo/redo ❌
 - Funcionalidade que permite desfazer ou refazer o que foi digitado. Tentar implementar no final, caso sobre tempo. 
 
 
 
 
