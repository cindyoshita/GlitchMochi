package dao

import ENUMs.GENRE
import ENUMs.TYPE
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.util.*
import models.Comments
import models.GameRecommendation
import shared.SharedPaths
import java.sql.DriverManager
import java.sql.ResultSet

class GameRecommendationDAO : GenericDAO {
    override fun getOne(id: Int): GameRecommendation {
        // Criar uma comexão com o banco
        val connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        // Criar um caminho para realizar queries no banco jdbc:mariadb://192.168.56.101:3306/DB?user=root&password=myPassword
        val sqlStatement = connection.createStatement()
        // Executa uma querie de busca
        val resultSet = sqlStatement.executeQuery("SELECT * FROM GameRecommendation WHERE gameRecommendationID = ${id};")
        // Intera pelo resultado obtido
        var gameRecommendation : GameRecommendation? = null
        var comments : Comments? = null
        while(resultSet.next()){
            gameRecommendation = GameRecommendation(
                resultSet.getInt("userID"),
                resultSet.getDouble("score"),
                resultSet.getString("game"),
                GENRE.valueOf(resultSet.getString("genre")),
                resultSet.getString("title"),
                resultSet.getInt(("gameLenght")),
                resultSet.getString("gameStudio"),
                resultSet.getDate("postDate"),
                resultSet.getString("text"),
                resultSet.getInt("gameRecommendationID"),


        )
        }
        resultSet.close()
        sqlStatement.close()
        connection.close()
        return gameRecommendation!!
    }

    override fun getAll(): List<Any> {
        val gamerecommendation = mutableListOf<GameRecommendation>()
        var connection : ConnectionDAO? = null
        try {
            // Criar uma comexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM GameRecommendation")
            // Intera pelo resultado obtido
            while (resultSet?.next()!!) {
                gamerecommendation.add(
                    GameRecommendation(
                        resultSet.getInt("userID"),
                        resultSet.getDouble("score"),
                        resultSet.getString("game"),
                        GENRE.valueOf(resultSet.getString("genre")),
                        resultSet.getString("title"),
                        resultSet.getInt("gameLenght"),
                        resultSet.getString("gameStudio"),
                        resultSet.getDate("postDate"),
                        resultSet.getString("text"),
                        resultSet.getInt("gameRecommendationID"),
                        )
                    )

            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return gamerecommendation

    }

    override fun insertOne(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO GameRecommendation
            (userID,score,game, genre, title, gameLenght,gameStudio,postDate,text)
            VALUES (?,?,?,?,?,?,?,?,?);
            """.trimMargin())
        val gamerecommendation = objeto as GameRecommendation
        preparedStatement?.setInt(1, gamerecommendation.userID)
        preparedStatement?.setDouble(2, gamerecommendation.score)
        preparedStatement?.setString(3, gamerecommendation.game)
        preparedStatement?.setInt(4, gamerecommendation.genre.ordinal)
        preparedStatement?.setString(5, gamerecommendation.title)
        preparedStatement?.setInt(6, gamerecommendation.gameLenght)
        preparedStatement?.setString(7, gamerecommendation.gameStudio)
        preparedStatement?.setDate(8, gamerecommendation.postDate)
        preparedStatement?.setString(9, gamerecommendation.text)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun insertAll(lista: List<Any>) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO GameRecommendation
            (userID,score,game, genre, title, gameLenght,gameStudio,postDate,text)
            VALUES (?,?,?,?,?,?,?,?,?);
            """.trimMargin())
        for (objeto in lista) {
            val gamerecommendation = objeto as GameRecommendation
            preparedStatement?.setInt(1, gamerecommendation.userID)
            preparedStatement?.setDouble(2, gamerecommendation.score)
            preparedStatement?.setString(3, gamerecommendation.game)
            preparedStatement?.setInt(4, gamerecommendation.genre.ordinal)
            preparedStatement?.setString(5, gamerecommendation.title)
            preparedStatement?.setInt(6, gamerecommendation.gameLenght)
            preparedStatement?.setString(7, gamerecommendation.gameStudio)
            preparedStatement?.setDate(8, gamerecommendation.postDate)
            preparedStatement?.setString(9, gamerecommendation.text)

            preparedStatement?.executeUpdate()
            // Banco ja esta em auto commit
            //connectiondao.commit()
        }
        connectiondao.close()
    }

    override fun update(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            UPDATE GameRecommendation
            SET userID = ?, score = ?, game = ?, genre = ?, title = ?, gameLenght = ?, gameStudio = ?, postDate = ?, text = ?
            WHERE gameRecommendationID = ?;
            """.trimMargin())
        val gamerecommendation = objeto as GameRecommendation
        preparedStatement?.setInt(1, gamerecommendation.userID)
        preparedStatement?.setDouble(2, gamerecommendation.score)
        preparedStatement?.setString(3, gamerecommendation.game)
        preparedStatement?.setInt(4, gamerecommendation.genre.ordinal)
        preparedStatement?.setString(5, gamerecommendation.title)
        preparedStatement?.setInt(6, gamerecommendation.gameLenght)
        preparedStatement?.setString(7, gamerecommendation.gameStudio)
        preparedStatement?.setDate(8, gamerecommendation.postDate)
        preparedStatement?.setString(9, gamerecommendation.text)
        preparedStatement?.setInt(10, gamerecommendation.gameRecommendationID)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun delete(id: Int) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            DELETE FROM GameRecommendation
            WHERE gameRecommendationID = ?;
            """.trimMargin())
        preparedStatement?.setInt(1, id)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    fun getImage(id: Int): String {
        val connectiondao = ConnectionDAO()
        val image : String
        val resultSet = connectiondao.executeQuery("""
            SELECT * FROM ImagesURL WHERE gameRecommendationID = ${id};
            """.trimMargin())
        // Banco ja esta em auto commit
        //connectiondao.commit()
        while (resultSet?.next()!!) {
           return resultSet.getString("imageURL")
        }
        return null!!
        connectiondao.close()
    }
}