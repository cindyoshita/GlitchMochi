//package dao
//
//import models.Comments
//import models.User
//import shared.SharedPaths
//import java.sql.DriverManager
//
//class UserDAO : GenericDAO {
//    override fun getOne(id: Int): Any {
//        // Criar uma comexão com o banco
//        val connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
//        // Criar um caminho para realizar queries no banco jdbc:mariadb://192.168.56.101:3306/DB?user=root&password=myPassword
//        val sqlStatement = connection.createStatement()
//        // Executa uma querie de busca
//        val resultSet = sqlStatement.executeQuery("SELECT * FROM User WHERE id == ${id};")
//        // Intera pelo resultado obtido
//        var user : User? = null
//        while(resultSet.next()){
//            user = User(
//                resultSet.getString(("userName")),
//                resultSet.getString("password"),
//                resultSet.getString("avatar"),
//                resultSet.getInt("cargo"),
//                resultSet.getInt("userID")
//            )
//
//            println("User encontrados: ${user}")
//        }
//        resultSet.close()
//        sqlStatement.close()
//        connection.close()
//        return user!!
//    }
//
//    override fun getAll(): List<Any> {
//        val users = mutableListOf<User>()
//        var connection : ConnectionDAO? = null
//        try {
//            // Criar uma comexão com o banco
//            connection = ConnectionDAO()
//            // Executa uma querie de busca
//            val resultSet = connection.executeQuery("SELECT * FROM User")
//            // Intera pelo resultado obtido
//            while (resultSet?.next()!!) {
//                users.add(
//                    User(
//                        resultSet.getString(("userName")),
//                        resultSet.getString("password"),
//                        resultSet.getString("avatar"),
//                        resultSet.getInt("cargo"),
//                        resultSet.getInt("userID")
//                    )
//                )
//            }
//        } catch (exception: Exception) {
//            exception.printStackTrace()
//        }
//        finally {
//            connection?.close()
//        }
//        return users
//
//    }
//
//    override fun insertOne(objeto: Any) {
//        val connectiondao = ConnectionDAO()
//        val preparedStatement = connectiondao.getPreparedStatement("""
//            INSERT INTO User
//            (userName,password,avatar,cargo)
//            VALUES (?,?,?,?,?);
//            """.trimMargin())
//        val user = objeto as User
//        preparedStatement?.setString(1, user.userName)
//        preparedStatement?.setString(2, user.password)
//        preparedStatement?.setString(2, user.avatar)
//        preparedStatement?.setInt(3, user.cargo)
//        preparedStatement?.executeUpdate()
//        // Banco ja esta em auto commit
//        //connectiondao.commit()
//        connectiondao.close()
//    }
//
//    override fun insertAll(lista: List<Any>) {
//        val connectiondao = ConnectionDAO()
//        val preparedStatement = connectiondao.getPreparedStatement("""
//            INSERT INTO User
//            (userName,password,avatar,cargo,userID)
//            VALUES (?,?,?,?,?);
//            """.trimMargin())
//        for (objeto in lista) {
//            val user = objeto as User
//            preparedStatement?.setString(1, user.userName)
//            preparedStatement?.setString(2, user.password)
//            preparedStatement?.setString(2, user.avatar)
//            preparedStatement?.setInt(3, user.cargo)
//            preparedStatement?.executeUpdate()
//            // Banco ja esta em auto commit
//            //connectiondao.commit()
//        }
//        connectiondao.close()
//    }
//
//    override fun update(objeto: Any) {
//        val connectiondao = ConnectionDAO()
//        val preparedStatement = connectiondao.getPreparedStatement("""
//            UPDATE User
//            SET userName = ?, password = ?, avatar = ?, cargo = ?
//            WHERE UserID = ?;
//            """.trimMargin())
//        val user = objeto as User
//        preparedStatement?.setString(1, user.userName)
//        preparedStatement?.setString(2, user.password)
//        preparedStatement?.setString(2, user.avatar)
//        preparedStatement?.setInt(3, user.cargo)
//        preparedStatement?.setInt(3, user.userID)
//        preparedStatement?.executeUpdate()
//        // Banco ja esta em auto commit
//        //connectiondao.commit()
//        connectiondao.close()
//    }
//
//    override fun delete(id: Int) {
//        val connectiondao = ConnectionDAO()
//        val preparedStatement = connectiondao.getPreparedStatement("""
//            DELETE FROM User
//            WHERE UserID = ?;
//            """.trimMargin())
//        preparedStatement?.setInt(1, id)
//        preparedStatement?.executeUpdate()
//        // Banco ja esta em auto commit
//        //connectiondao.commit()
//        connectiondao.close()
//    }
//}