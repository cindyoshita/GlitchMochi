package dao

import models.ImageURL
import shared.SharedPaths
import java.sql.DriverManager
import java.sql.Types

class ImageURLDAO : GenericDAO {
    override fun getOne(id: Int): Any {
        TODO("Not yet implemented")
    }

    fun getOneGame(id: Int): ImageURL {
        // Criar uma comexão com o banco
        val connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        // Criar um caminho para realizar queries no banco jdbc:mariadb://192.168.56.101:3306/DB?user=root&password=myPassword
        val sqlStatement = connection.createStatement()
        // Executa uma querie de busca
        val resultSet = sqlStatement.executeQuery("SELECT * FROM ImagesURL WHERE gameRecommendationID = ${id};")
        // Intera pelo resultado obtido
        var imageURL : ImageURL? = null
        while(resultSet.next()){
            imageURL = ImageURL(
                resultSet.getString(("imageURL")),
                resultSet.getInt("gameRecommendationID"),
                resultSet.getInt("mangaRecommendationID"),
                resultSet.getInt("imageURLID")
            )

        }
        resultSet.close()
        sqlStatement.close()
        connection.close()
        return imageURL!!
    }

    fun getOneManga(id: Int): ImageURL {
        // Criar uma comexão com o banco
        val connection = DriverManager.getConnection(SharedPaths.JDBC_COONECTION_STRING)
        // Criar um caminho para realizar queries no banco jdbc:mariadb://192.168.56.101:3306/DB?user=root&password=myPassword
        val sqlStatement = connection.createStatement()
        // Executa uma querie de busca
        val resultSet = sqlStatement.executeQuery("SELECT * FROM ImagesURL WHERE mangaRecommendationID = ${id};")
        // Intera pelo resultado obtido
        var imageURL : ImageURL? = null
        while(resultSet.next()){
            imageURL = ImageURL(
                resultSet.getString(("imageURL")),
                resultSet.getInt("gameRecommendationID"),
                resultSet.getInt("mangaRecommendationID"),
                resultSet.getInt("imageURLID")
            )

        }
        resultSet.close()
        sqlStatement.close()
        connection.close()
        return imageURL!!
    }

    override fun getAll(): List<Any> {
        val imagesURL = mutableListOf<ImageURL>()
        var connection : ConnectionDAO? = null
        try {
            // Criar uma comexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM ImagesURL")
            // Intera pelo resultado obtido
            while (resultSet?.next()!!) {
                imagesURL.add(
                    ImageURL(
                        resultSet.getString(("imageURL")),
                        resultSet.getInt("gameRecommendationID"),
                        resultSet.getInt("mangaRecommendationID"),
                        resultSet.getInt("imageURLID")
                    )
                    )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return imagesURL

    }

    override fun insertOne(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO ImagesURL  
            (imageURL,gameRecommendationID,mangaRecommendationID)
            VALUES (?,?,?);
            """.trimMargin())
        val imageURL = objeto as ImageURL
        preparedStatement?.setString(1, imageURL.imageURL)
        if (imageURL.gameRecommendationID == null) {
            preparedStatement?.setNull(2,  Types.INTEGER);
        }
        else {
            preparedStatement?.setInt(2,imageURL.gameRecommendationID);
        }
        if (imageURL.mangaRecommendationID == null) {
            preparedStatement?.setNull(3,  Types.INTEGER);
        }
        else {
            preparedStatement?.setInt(3,imageURL.mangaRecommendationID);
        }
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun insertAll(lista: List<Any>) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO ImagesURL  
            (imageURL,gameRecommendationID,mangaRecommendationID)
            VALUES (?,?,?);
            """.trimMargin())
        for (objeto in lista) {
            val imageURL = objeto as ImageURL
            preparedStatement?.setString(1, imageURL.imageURL)
            if (imageURL.gameRecommendationID == null) {
                preparedStatement?.setNull(2,  Types.INTEGER);
            }
            else {
                preparedStatement?.setInt(2, imageURL.gameRecommendationID);
            }
            if (imageURL.mangaRecommendationID == null) {
                preparedStatement?.setNull(3,  Types.INTEGER);
            }
            else {
                preparedStatement?.setInt(3,imageURL.mangaRecommendationID);
            }
            preparedStatement?.executeUpdate()
            // Banco ja esta em auto commit
            //connectiondao.commit()
        }
        connectiondao.close()
    }

    override fun update(objeto: Any) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            UPDATE ImagesURL  
            SET imageURL = ?, gameRecommendationID = ?, mangaRecommendationID = ?
            WHERE imageURLID = ?;
            """.trimMargin())
        val imageURL = objeto as ImageURL
        preparedStatement?.setString(1, imageURL.imageURL)
        if (imageURL.gameRecommendationID == null) {
            preparedStatement?.setNull(2,  Types.INTEGER);
        }
        else {
            preparedStatement?.setInt(2,imageURL.gameRecommendationID);
        }
        if (imageURL.mangaRecommendationID == null) {
            preparedStatement?.setNull(3,  Types.INTEGER);
        }
        else {
            preparedStatement?.setInt(3,imageURL.mangaRecommendationID);
        }
        preparedStatement?.setInt(4, imageURL.imageURLID)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun delete(id: Int) {
        val connectiondao = ConnectionDAO()
        val preparedStatement = connectiondao.getPreparedStatement("""
            DELETE FROM ImagesURL
            WHERE imageURLID = ?;
            """.trimMargin())
        preparedStatement?.setInt(1, id)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }


}