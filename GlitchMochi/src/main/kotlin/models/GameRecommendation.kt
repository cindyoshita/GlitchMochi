package models
import ENUMs.GENRE
import java.sql.Date


data class GameRecommendation(
    val userID        : Int,
    val score         : Double,
    val image         : String,
    val game          : String,
    val genre         : GENRE,
    val title         : String,
    val gameLenght    : Int,
    val gameStudio    : String,
    val postDate      : Date,
    val text          : String,
    val publicationID : Int,
    val comment       : Any

)
