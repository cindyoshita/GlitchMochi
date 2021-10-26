package models

import ENUMs.TYPE

data class Comments(
    val owner: String,
    val text: String,
    val likes: Int,
    val commentID: Int,
    val type: TYPE,
    val gameRecommendationID : Int,
    val mangaRecommendationID : Int
)
