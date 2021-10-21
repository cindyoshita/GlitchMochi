package dao

import shared.SharedPaths
import java.sql.*

class ConnectionDAO {

    val connection : Connection
    var statement : Statement?
    var resultSet : ResultSet?
    var preparedStatement : PreparedStatement?

    init {
        this.connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        this.statement = null
        this.resultSet = null
        this.preparedStatement = null
    }
    fun executeQuery(sqlString : String) : ResultSet?{
        this.statement = this.connection.createStatement()
        this.resultSet = this.statement?.executeQuery(sqlString)
        return this.resultSet
    }

    fun close() {
        this.resultSet?.close()
        this.statement?.close()
        this.preparedStatement?.close()
        this.connection.close()
    }

    fun getPreparedStatement(sqlString: String): PreparedStatement? {
        this.preparedStatement = this.connection.prepareStatement(sqlString)
        return this.preparedStatement
    }

    fun commit() {
        this.connection?.commit()
    }
}