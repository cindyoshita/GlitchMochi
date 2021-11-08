package models

data class Comments(
    val userID: Int,
    val text: String,
    val likes: Int,
    val commentID: Int,
    val gameRecommendationID: Int?,
    val mangaRecommendationID: Int?,
)
