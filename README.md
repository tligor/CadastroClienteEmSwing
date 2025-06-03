📝 Cadastro de Clientes em Java Swing
📌 Descrição

Este projeto é um sistema de cadastro de clientes desenvolvido em Java utilizando Swing para a interface gráfica. Ele permite:

    Cadastrar novos clientes

    Listar clientes existentes

    Atualizar informações de clientes

    Excluir clientes do sistema

🛠️ Tecnologias Utilizadas

    Java (linguagem principal)

    Swing (para interface gráfica)

    MySQL (banco de dados)

    JDBC (conexão com o banco de dados)

⚙️ Configuração do Ambiente
Pré-requisitos

    Java JDK 8 ou superior

    MySQL Server instalado

    IDE de sua preferência (Eclipse, NetBeans, IntelliJ)

Configuração do Banco de Dados

    Crie um banco de dados chamado cadastro_clientes

    Execute o seguinte script SQL para criar a tabela:

sql

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(15),
    endereco VARCHAR(200),
    data_nascimento DATE,
    sexo VARCHAR(10)
);

Configuração da Aplicação

    Clone o repositório:
    bash

git clone https://github.com/tligor/CadastroClienteEmSwing.git

Importe o projeto em sua IDE

Configure as informações de conexão com o banco de dados no arquivo ClienteDAO.java:
java

    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_clientes";
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

🖥️ Funcionalidades

    Cadastro de Clientes:

        Validação de CPF

        Campos obrigatórios

        Impedimento de duplicação de CPF

    Gerenciamento de Clientes:

        Visualização em tabela

        Atualização de informações (exceto CPF)

        Exclusão de registros

🚀 Como Executar

    Certifique-se que o MySQL está rodando

    Execute a classe Principal.java

    A interface gráfica será aberta e você poderá começar a usar o sistema

📝 Observações Importantes

    O CPF é um campo único e imutável após o cadastro

    Para "alterar" um CPF, é necessário excluir o cliente e cadastrar novamente

    O sistema inclui validações básicas para evitar erros de entrada

🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para:

    Reportar issues

    Sugerir melhorias

    Enviar pull requests

📄 Licença

Este projeto está sob a licença MIT - veja o arquivo LICENSE para detalhes.
