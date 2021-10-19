package models

import ENUMs.GENRE
import com.sun.org.apache.xml.internal.utils.res.StringArrayWrapper
import org.joda.time.DateTime

data class MangaRecommendation(
    val userID        : Int,
    val score         : Float,
    val image         : StringArrayWrapper,
    val author        : String,
    val genre         : GENRE,
    val title         : String,
    val postDate      : DateTime,
    val text          : String,
    val publicationID : Int,
    val comment       : Comments
)
