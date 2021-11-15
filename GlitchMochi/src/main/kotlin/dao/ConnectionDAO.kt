package dao

import shared.SharedPaths
import java.sql.*

// Essa classe faz a conexao entre o Kotlin com o banco de dados
class ConnectionDAO {

    val connection : Connection
    var statement : Statement?
    var resultSet : ResultSet?
    var preparedStatement : PreparedStatement?

    // Inicialmente conecta com o banco e atribui null para statement, resulSet e preparedStatement
    init {
        this.connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        this.statement = null
        this.resultSet = null
        this.preparedStatement = null
    }

    // a acao executeQuery faz os comandos pedidos no banco de dados e retorna o seu valor dentro do ResultSet
    fun executeQuery(sqlString : String) : ResultSet?{
        this.statement = this.connection.createStatement() // Cria o Statement do banco de dados
        this.resultSet = this.statement?.executeQuery(sqlString) // Atribui o resultado desse Statement dentro do resultSet
        return this.resultSet
    }

    // Fecha tudo que abriu dentro do banco de dados
    fun close() {
        this.resultSet?.close()
        this.statement?.close()
        this.preparedStatement?.close()
        this.connection.close()
    }
}