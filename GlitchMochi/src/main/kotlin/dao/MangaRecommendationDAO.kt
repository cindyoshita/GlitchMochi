package dao

import ENUMs.GENRE
import models.MangaRecommendation

//Essa Classe faz as acoes necessarias no banco de dados sobre o MangaRecommendation
class MangaRecommendationDAO : GenericDAO {

    // Pega todos os resultados obtidos dentro do banco para o id solicitado dentro de MangaRecommendation
    override fun getOne(id: Int): MangaRecommendation {
        var mangaRecommendation : MangaRecommendation? = null
        var connection : ConnectionDAO? = null
        try {
            // Criar uma conexão com o banco
            connection = ConnectionDAO()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM MangaRecommendation WHERE mangaRecommendationID = ${id};")
            // Intera pelo resultado obtido
            while(resultSet?.next()!!){
                mangaRecommendation = MangaRecommendation(
                    resultSet.getInt("userID"),
                    resultSet.getDouble("score"),
                    resultSet.getString("author"),
                    GENRE.valueOf(resultSet.getString("genre")),
                    resultSet.getString("title"),
                    resultSet.getDate("postDate"),
                    resultSet.getString("text"),
                    resultSet.getInt("mangaRecommendationID"),
                    resultSet.getString("manga"),
            )
        }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return mangaRecommendation!!
    }
}