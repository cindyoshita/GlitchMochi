package models
import ENUMs.GENRE
import java.sql.Date

// Variaveis encontrados no GameRecommendation do banco de dados e usado nesse programa
data class GameRecommendation(
    val userID               : Int,
    val score                : Double,
    val game                 : String,
    val genre                : GENRE,
    val title                : String,
    val gameLenght           : Int,
    val gameStudio           : String,
    val postDate             : Date,
    val text                 : String,
    val gameRecommendationID : Int

){// Transformar as variaveis utilizadas no flutter em um JSON
    fun toJson(): String {

        return """{ 
                "userID": $userID, 
                "score": $score,
                "game": "$game", 
                "genre": "$genre", 
                "title": "$title",
                "gameLenght": $gameLenght, 
                "gameStudio": "$gameStudio",
                "postDate": "$postDate",
                "text": "$text",
                "gameRecommendationID": $gameRecommendationID 
                }"""
    }


}
