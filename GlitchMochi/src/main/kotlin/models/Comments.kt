package models

data class Comments(
    val owner: String,
    val text: String,
    val like: Int,
    val commentID: Int
)
