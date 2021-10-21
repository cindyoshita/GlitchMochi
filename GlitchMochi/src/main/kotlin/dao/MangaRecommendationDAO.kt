package dao

import models.Comments
import models.GameRecommendation
import models.MangaRecommendation
import shared.SharedPaths
import java.sql.DriverManager

class MangaRecommendationDAO : GenericDAO {
    override fun getOne(id: Int): Any {
        // Criar uma comexão com o banco
        val connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        // Criar um caminho para realizar queries no banco jdbc:mariadb://192.168.56.101:3306/DB?user=root&password=myPassword
        val sqlStatement = connection.createStatement()
        // Executa uma querie de busca
        val resultSet = sqlStatement.executeQuery("SELECT * FROM MangaRecommendation WHERE id == ${id};")
        // Intera pelo resultado obtido
        var mangaRecommendation : MangaRecommendation? = null
        while(resultSet.next()){
            mangaRecommendation = MangaRecommendation(
                resultSet.getInt("userID"),
                resultSet.getDouble("score"),
                resultSet.getString("image"),
                resultSet.getString("author"),
                resultSet.getObject("genre"),
                resultSet.getString("title"),
                resultSet.getInt(("postDate")),
                resultSet.getString("text"),
                resultSet.getInt("publicationID"),
                resultSet.getString("manga"),
                resultSet.getString("comment")
            )

            println("MangaRecommendation encontrados: ${mangaRecommendation}")
        }
        resultSet.close()
        sqlStatement.close()
        connection.close()
        return mangaRecommendation!!
    }

    override fun getAll(): List<Any> {
        val mangaRecommendation = mutableListOf<MangaRecommendation>()
        var connection : ConnectionDAO? = null
        try {
            // Criar uma comexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM MangaRecommendation")
            // Intera pelo resultado obtido
            while (resultSet?.next()!!) {
                mangaRecommendation.add(
                    MangaRecommendation(
                        resultSet.getInt("userID"),
                        resultSet.getDouble("score"),
                        resultSet.getString("image"),
                        resultSet.getString("author"),
                        resultSet.getObject("genre"),
                        resultSet.getString("title"),
                        resultSet.getDate("postDate"),
                        resultSet.getString("text"),
                        resultSet.getInt("publicationID"),
                        resultSet.getString("manga"),
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
        return mangaRecommendation

    }

    override fun insertOne(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO MangaRecommendation  
            (userID,score,image,comment,title,genre,author,postDate,text,manga)
            VALUES (?,?,?,?,?,?,?,?,?,?,?);
            """.trimMargin())
        val mangaRecommendation = objeto as MangaRecommendation
        preparedStatement?.setInt(1, mangaRecommendation.userID)
        preparedStatement?.setDouble(2, mangaRecommendation.score)
        preparedStatement?.setString(3, mangaRecommendation.image)
        preparedStatement?.setString(4, mangaRecommendation.author)
        preparedStatement?.setString(5, mangaRecommendation.genre)
        preparedStatement?.setString(6, mangaRecommendation.title)
        preparedStatement?.setString(7, mangaRecommendation.postDate)
        preparedStatement?.setString(8, mangaRecommendation.text)
        preparedStatement?.setString(9, mangaRecommendation.manga)
        preparedStatement?.setString(10, mangaRecommendation.comment)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun insertAll(lista: List<Any>) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO MangaRecommendation  
            (userID,score,image,comment,title,genre,author,postDate,text,manga)
            VALUES (?,?,?,?,?,?,?,?,?,?,?);
            """.trimMargin())
        for (objeto in lista) {
            val mangaRecommendation = objeto as MangaRecommendation
            preparedStatement?.setInt(1, mangaRecommendation.userID)
            preparedStatement?.setDouble(2, mangaRecommendation.score)
            preparedStatement?.setString(3, mangaRecommendation.image)
            preparedStatement?.setString(4, mangaRecommendation.author)
            preparedStatement?.setString(5, mangaRecommendation.genre)
            preparedStatement?.setString(6, mangaRecommendation.title)
            preparedStatement?.setString(7, mangaRecommendation.postDate)
            preparedStatement?.setString(8, mangaRecommendation.text)
            preparedStatement?.setString(9, mangaRecommendation.manga)
            preparedStatement?.setString(10, mangaRecommendation.comment)

            preparedStatement?.executeUpdate()
            // Banco ja esta em auto commit
            //connectiondao.commit()
        }
        connectiondao.close()
    }

    override fun update(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            UPDATE MangaRecommendation 
            SET userID = ?, score = ?, image = ?, comment = ?, title = ?, genre = ?, author = ?, postDate = ?,text = ?, manga = ?
            WHERE publicationID = ?;
            """.trimMargin())
        val mangaRecommendation = objeto as MangaRecommendation
        preparedStatement?.setInt(1, mangaRecommendation.userID)
        preparedStatement?.setDouble(2, mangaRecommendation.score)
        preparedStatement?.setString(3, mangaRecommendation.image)
        preparedStatement?.setString(4, mangaRecommendation.author)
        preparedStatement?.setString(5, mangaRecommendation.genre)
        preparedStatement?.setString(6, mangaRecommendation.title)
        preparedStatement?.setString(7, mangaRecommendation.postDate)
        preparedStatement?.setString(8, mangaRecommendation.text)
        preparedStatement?.setInt(9, mangaRecommendation.publicationID)
        preparedStatement?.setString(10, mangaRecommendation.manga)
        preparedStatement?.setString(11, mangaRecommendation.comment)
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