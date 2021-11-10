package models
import ENUMs.GENRE
import java.sql.Date


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

){
    fun toJson(): String {
        return "{" +
                "'userID': $userID," +
                "'score': $score" +
                "'game': $game" +
                "'genre': $genre" +
                "'title': $title" +
                "'gameLenght': $gameLenght" +
                "'gameStudio': $gameStudio" +
                "'postDate': $postDate" +
                "'text': $text" +
                "gameRecommendationID: $gameRecommendationID" +
                "}"
    }


}
