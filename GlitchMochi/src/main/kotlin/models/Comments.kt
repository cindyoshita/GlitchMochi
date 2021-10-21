package models

data class Comments(
    val owner: String,
    val text: String,
    val likes: Int,
    val commentID: Int
)
