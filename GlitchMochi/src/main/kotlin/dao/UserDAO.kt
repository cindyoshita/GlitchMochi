package dao

import ENUMs.CARGO
import models.User

class UserDAO : GenericDAO {
    override fun getOne(id: Int): User {
        var user : User? = null
        var connection : ConnectionDAO? = null
        try {
            // Criar uma conexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM User WHERE userID = ${id};")
            // Intera pelo resultado obtido
            while(resultSet?.next()!!){
                user = User(
                    resultSet.getString(("userName")),
                    resultSet.getString("password"),
                    resultSet.getString("avatar"),
                    CARGO.valueOf(resultSet.getString("cargo")),
                    resultSet.getInt("userID")
                )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return user!!
    }
}