package models

// Variaveis encontrados no Comment do banco de dados e usado nesse programa
data class Comments(
    val userID: Int,
    val text: String,
    val likes: Int,
    val commentID: Int,
    val gameRecommendationID: Int?,
    val mangaRecommendationID: Int?,
){// Transformar as variaveis utilizadas no flutter em um JSON
fun toJson(): String {
    return """{ 
                "userID": $userID, 
                "text": "$text",
                "likes": $likes
                }"""
}
}
