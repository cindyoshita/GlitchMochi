package models
import ENUMs.GENRE
import org.joda.time.DateTime

data class GameRecommendation(
    val userID        : Int,
    val score         : Double,
    val image         : String,
    val game          : String,
    val genre         : GENRE,
    val title         : String,
    val gameLenght    : Int,
    val gameStudio    : String,
    val postDate      : DateTime,
    val text          : String,
    val publicationID : Int,
    val comment       : Comments

)
