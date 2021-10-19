package models

import ENUMs.GENRE
import com.sun.jdi.connect.Connector
import com.sun.org.apache.xml.internal.utils.res.StringArrayWrapper
import org.joda.time.DateTime

data class GameRecommendation(
    val userID        : Int,
    val score         : Float,
    val image         : StringArrayWrapper,
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
