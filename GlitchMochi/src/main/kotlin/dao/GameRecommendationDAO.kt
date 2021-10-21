package dao

import ENUMs.GENRE
import models.Comments
import models.GameRecommendation
import shared.SharedPaths
import java.sql.DriverManager

class GameRecommendationDAO : GenericDAO {
    override fun getOne(id: Int): Any {
        // Criar uma comexão com o banco
        val connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        // Criar um caminho para realizar queries no banco jdbc:mariadb://192.168.56.101:3306/DB?user=root&password=myPassword
        val sqlStatement = connection.createStatement()
        // Executa uma querie de busca
        val resultSet = sqlStatement.executeQuery("SELECT * FROM GameRecommendation WHERE id == ${id};")
        // Intera pelo resultado obtido
        var gameRecommendation : GameRecommendation? = null
        while(resultSet.next()){
            gameRecommendation = GameRecommendation(
                resultSet.getInt("userID"),
                resultSet.getDouble("score"),
                resultSet.getString("image"),
                resultSet.getString("game"),
                GENRE.valueOf(resultSet.getString("genre")),
                resultSet.getString("title"),
                resultSet.getInt(("gameLenght")),
                resultSet.getString("gameStudio"),
                resultSet.getDate("postDate"),
                resultSet.getString("text"),
                resultSet.getInt("publicationID"),
                resultSet.getObject("comment",Comments)
            )

            println("GameRecommendation encontrados: ${gameRecommendation}")
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
                        resultSet.getString("image"),
                        resultSet.getString("game"),
                        resultSet.getObject("genre"),
                        resultSet.getString("title"),
                        resultSet.getInt("gameLenght"),
                        resultSet.getString("gameStudio"),
                        resultSet.getDate("postDate"),
                        resultSet.getString("text"),
                        resultSet.getInt("publicationID"),
                        resultSet.getObject("comment",Comments)
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
            (userID,score,image,game, genre, title, gameLenght,gameStudio,postDate,text,comment)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?); INSERT INTO Comment
            (owner,text,like)
            VALUES (?,?,?);
            """.trimMargin())
        val comment = objeto as Comments
        val gamerecommendation = objeto as GameRecommendation
        preparedStatement?.setInt(1, gamerecommendation.userID)
        preparedStatement?.setDouble(2, gamerecommendation.score)
        preparedStatement?.setString(3, gamerecommendation.image)
        preparedStatement?.setString(4, gamerecommendation.game)
        preparedStatement?.setString(5, gamerecommendation.genre)
        preparedStatement?.setString(6, gamerecommendation.title)
        preparedStatement?.setInt(6, gamerecommendation.gameLenght)
        preparedStatement?.setInt(7, gamerecommendation.postDate)
        preparedStatement?.setString(8, gamerecommendation.text)
        preparedStatement?.setString(10, gamerecommendation.comment)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun insertAll(lista: List<Any>) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO GameRecommendation
            (userID,score,image,game, genre, title, gameLenght,gameStudio,postDate,text,comment)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?);
            """.trimMargin())
        for (objeto in lista) {
            val gamerecommendation = objeto as GameRecommendation
            preparedStatement?.setInt(1, gamerecommendation.userID)
            preparedStatement?.setDouble(2, gamerecommendation.score)
            preparedStatement?.setString(3, gamerecommendation.image)
            preparedStatement?.setString(4, gamerecommendation.game)
            preparedStatement?.setString(5, gamerecommendation.genre)
            preparedStatement?.setString(6, gamerecommendation.title)
            preparedStatement?.setInt(6, gamerecommendation.gameLenght)
            preparedStatement?.setInt(7, gamerecommendation.postDate)
            preparedStatement?.setString(8, gamerecommendation.text)
            preparedStatement?.setString(10, gamerecommendation.comment)

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
            SET userID = ?, score = ?, image = ?, game = ?, genre = ?, title = ?, gameLenght = ?, gameStudio = ?, postDate = ?, text = ?, comment = ?
            WHERE publicationID = ?;
            """.trimMargin())
        val gamerecommendation = objeto as GameRecommendation
        preparedStatement?.setInt(1, gamerecommendation.userID)
        preparedStatement?.setDouble(2, gamerecommendation.score)
        preparedStatement?.setString(3, gamerecommendation.image)
        preparedStatement?.setString(4, gamerecommendation.game)
        preparedStatement?.setString(5, gamerecommendation.genre)
        preparedStatement?.setString(6, gamerecommendation.title)
        preparedStatement?.setInt(6, gamerecommendation.gameLenght)
        preparedStatement?.setInt(7, gamerecommendation.postDate)
        preparedStatement?.setString(8, gamerecommendation.text)
        preparedStatement?.setInt(9, gamerecommendation.publicationID)
        preparedStatement?.setString(10, gamerecommendation.comment)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun delete(id: Int) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            DELETE FROM GameRecommendation
            WHERE publicationID = ?;
            """.trimMargin())
        preparedStatement?.setInt(1, id)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }
}