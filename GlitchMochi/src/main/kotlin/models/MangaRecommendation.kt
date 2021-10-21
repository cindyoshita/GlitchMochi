package models

import ENUMs.GENRE
import org.joda.time.DateTime

data class MangaRecommendation(
    val userID        : Int,
    val score         : Double,
    val image         : String,
    val author        : String,
    val genre         : GENRE,
    val title         : String,
    val postDate      : DateTime,
    val text          : String,
    val publicationID : Int,
    val manga         : String,
    val comment       : Comments
)
