package models

import ENUMs.GENRE
import java.sql.Date

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
)
