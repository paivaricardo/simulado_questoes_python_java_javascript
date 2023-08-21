"""
O candidato deve elaborar um código que conecte ao banco de dados MySQL. Após a conexão deve ser criar a tabela dados com os seguintes campos:
Id
Nome
Idade
Onde, id será a chave primária e corresponde a um inteiro.
"""

from mysql import connector

# Variáveis de conexão com o banco de dados
connection_args_dict = {
    "database": "root",
    "user": "root",
    "password": "root",
    "host": "localhost",
    "port": 3306
}

connection = None

try:
    connection = connector.connect(**connection_args_dict)

    cursor = connection.cursor()

    query_inserir_dados_tabela_mysql = """
        CREATE TABLE IF NOT EXISTS dados (
            Id  INTEGER PRIMARY KEY AUTO_INCREMENT,
            Nome VARCHAR(255) NOT NULL,
            Idade INTEGER NOT NULL
        );
    """

    cursor.execute(query_inserir_dados_tabela_mysql)

    connection.commit()

    cursor.close()

except Exception as e:
    print("Houve um erro ao tentar conectar com o banco de dados MySQL")