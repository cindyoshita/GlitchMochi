package dao

import models.Comments

// Essa Classe faz as acoes necessarias no banco de dados sobre o Comment
class CommentDAO {

    // Pega todos os resultados obtidos dentro do banco para o id de gameRecommendationID solicitado dentro de Comment
    fun getOneGame(id: Int): Comments {
        var comment : Comments? = null
        var connection : ConnectionDAO? = null
        try {
            // Criar uma conexão com o banco
            connection = ConnectionDAO()
        // Executa uma querie de busca
        val resultSet = connection.executeQuery("SELECT * FROM Comment WHERE gameRecommendationID = ${id};")
        // Intera pelo resultado obtido
        while(resultSet?.next()!!){
            comment = Comments(
                resultSet.getInt(("userID")),
                resultSet.getString("text"),
                resultSet.getInt("likes"),
                resultSet.getInt("commentID"),
                resultSet.getInt("gameRecommendationID"),
                resultSet.getInt("mangaRecommendationID"),
            )
        }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return comment!!
    }

    //Pega todos os resultados obtidos dentro do banco para o id de mangaRecommendationID solicitado dentro de Comment
    fun getOneManga(id: Int): Comments {
        var comment : Comments? = null
        var connection : ConnectionDAO? = null
        try {
            // Criar uma conexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM Comment WHERE mangaRecommendationID = ${id};")
            // Intera pelo resultado obtido
            while(resultSet?.next()!!){
                comment = Comments(
                    resultSet.getInt(("userID")),
                    resultSet.getString("text"),
                    resultSet.getInt("likes"),
                    resultSet.getInt("commentID"),
                    resultSet.getInt("gameRecommendationID"),
                    resultSet.getInt("mangaRecommendationID"),
                )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return comment!!
    }
}