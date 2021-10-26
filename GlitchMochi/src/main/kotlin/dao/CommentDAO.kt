package dao

import ENUMs.TYPE
import models.Comments
import shared.SharedPaths
import java.sql.DriverManager

class CommentDAO : GenericDAO {
    override fun getOne(id: Int): Any {
        // Criar uma comexão com o banco
        val connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        // Criar um caminho para realizar queries no banco jdbc:mariadb://192.168.56.101:3306/DB?user=root&password=myPassword
        val sqlStatement = connection.createStatement()
        // Executa uma querie de busca
        val resultSet = sqlStatement.executeQuery("SELECT * FROM Comment WHERE id == ${id};")
        // Intera pelo resultado obtido
        var comment : Comments? = null
        while(resultSet.next()){
            comment = Comments(
                resultSet.getString(("owner")),
                resultSet.getString("text"),
                resultSet.getInt("likes"),
                resultSet.getInt("commentID"),
                resultSet.getInt("gameRecommendationID"),
                resultSet.getInt("mangaRecommendationID")
            )

            println("Comentarios encontrados: ${comment}")
        }
        resultSet.close()
        sqlStatement.close()
        connection.close()
        return comment!!
    }

    override fun getAll(): List<Any> {
        val comments = mutableListOf<Comments>()
        var connection : ConnectionDAO? = null
        try {
            // Criar uma comexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM Comment")
            // Intera pelo resultado obtido
            while (resultSet?.next()!!) {
                comments.add(
                    Comments(
                        resultSet.getString(("owner")),
                        resultSet.getString("text"),
                        resultSet.getInt("likes"),
                        resultSet.getInt("commentID"),
                        resultSet.getInt("gameRecommendationID"),
                        resultSet.getInt("mangaRecommendationID")
                    )
                )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return comments

    }

    override fun insertOne(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO Comment  
            (owner,text,likes,gameRecommendationID,mangaRecommendationID)
            VALUES (?,?,?,?,?);
            """.trimMargin())
        val comment = objeto as Comments
        preparedStatement?.setString(1, comment.owner)
        preparedStatement?.setString(2, comment.text)
        preparedStatement?.setInt(3, comment.likes)
        preparedStatement?.setInt(4, comment.gameRecommendationID)
        preparedStatement?.setInt(5, comment.mangaRecommendationID)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun insertAll(lista: List<Any>) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO Comment  
            (owner,text,likes,gameRecommendationID,mangaRecommendationID)
            VALUES (?,?,?,?,?);
            """.trimMargin())
        for (objeto in lista) {
            val comment = objeto as Comments
            preparedStatement?.setString(1, comment.owner)
            preparedStatement?.setString(2, comment.text)
            preparedStatement?.setInt(3, comment.likes)
            preparedStatement?.setInt(4, comment.gameRecommendationID)
            preparedStatement?.setInt(5, comment.mangaRecommendationID)
            preparedStatement?.executeUpdate()
            // Banco ja esta em auto commit
            //connectiondao.commit()
        }
        connectiondao.close()
    }

    override fun update(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            UPDATE Comment  
            SET owner = ?, text = ?, likes = ?, gameRecommendationID = ?, mangaRecommendationID = ?
            WHERE commentID = ?;
            """.trimMargin())
        val comment = objeto as Comments
        preparedStatement?.setString(1, comment.owner)
        preparedStatement?.setString(2, comment.text)
        preparedStatement?.setInt(3, comment.likes)
        preparedStatement?.setInt(4, comment.commentID)
        preparedStatement?.setInt(5, comment.gameRecommendationID)
        preparedStatement?.setInt(6, comment.mangaRecommendationID)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun delete(id: Int) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            DELETE FROM Comment
            WHERE commentID = ?;
            """.trimMargin())
        preparedStatement?.setInt(1, id)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }
}