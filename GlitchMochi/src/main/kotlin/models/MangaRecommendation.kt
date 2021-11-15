package models

import ENUMs.GENRE
import java.sql.Date

// Variaveis encontrados no MangaRecommendation do banco de dados e usado nesse programa
data class MangaRecommendation(
    val userID        : Int,
    val score         : Double,
    val title         : String,
    val genre         : GENRE,
    val author        : String,
    val postDate      : Date,
    val text          : String,
    val mangaRecommendationID : Int,
    val manga         : String
) {// Transformar as variaveis utilizadas no flutter em um JSON
    fun toJson(): String {
        return """{ 
                "userID": $userID, 
                "score": $score,
                "title": "$title", 
                "genre": "$genre", 
                "author": "$author",
                "postDate": "$postDate",
                "text": "$text",
                "mangaRecommendationID": $mangaRecommendationID,
                "manga": "$manga"
                }"""
    }
}
