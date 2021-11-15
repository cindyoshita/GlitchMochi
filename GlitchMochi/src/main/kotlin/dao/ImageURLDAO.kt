package dao

import models.ImageURL

//Essa Classe faz as acoes necessarias no banco de dados sobre o ImageURL
class ImageURLDAO {

    // Pega todos os resultados obtidos dentro do banco para o id de gameRecommendationID solicitado dentro de ImageURL
    fun getOneGame(id: Int): ImageURL {
        var imageURL : ImageURL? = null
        var connection : ConnectionDAO? = null
        try {
            // Criar uma conexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM ImagesURL WHERE gameRecommendationID = ${id};")
            // Intera pelo resultado obtido
            while(resultSet?.next()!!){
                imageURL = ImageURL(
                    resultSet.getString(("imageURL")),
                    resultSet.getInt("gameRecommendationID"),
                    resultSet.getInt("mangaRecommendationID"),
                    resultSet.getInt("imageURLID")
                )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return imageURL!!
    }

    // Pega todos os resultados obtidos dentro do banco para o id de mangaRecommendationID solicitado dentro de ImageURL
    fun getOneManga(id: Int): ImageURL {
        var imageURL : ImageURL? = null
        var connection : ConnectionDAO? = null
        try {
            // Criar uma conexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM ImagesURL WHERE mangaRecommendationID = ${id};")
            // Intera pelo resultado obtido
            while(resultSet?.next()!!){
                imageURL = ImageURL(
                    resultSet.getString(("imageURL")),
                    resultSet.getInt("gameRecommendationID"),
                    resultSet.getInt("mangaRecommendationID"),
                    resultSet.getInt("imageURLID")
            )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return imageURL!!
    }
}