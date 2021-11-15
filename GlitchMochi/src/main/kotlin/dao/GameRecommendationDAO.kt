package dao

import ENUMs.GENRE
import models.GameRecommendation

// Essa Classe faz as acoes necessarias no banco de dados sobre o GameRecommendation
class GameRecommendationDAO : GenericDAO {

    // Pega todos os resultados obtidos dentro do banco para o id solicitado dentro de GameRecommendation
    override fun getOne(id: Int): GameRecommendation {
        var gameRecommendation : GameRecommendation? = null
        var connection : ConnectionDAO? = null
        try {
            // Criar uma conexão com o banco
            connection = ConnectionDAO()
        // Executa uma querie de busca
        val resultSet = connection.executeQuery("SELECT * FROM GameRecommendation WHERE gameRecommendationID = ${id};")
        // Intera pelo resultado obtido
        while(resultSet?.next()!!){
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
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return gameRecommendation!!
}
}