package models

// Variaveis encontrados no ImageURL do banco de dados e usado nesse programa
data class ImageURL (
    val imageURL               : String,
    val gameRecommendationID     : Int?,
    val mangaRecommendationID    : Int?,
    val imageURLID             : Int
) {// Transformar as variaveis utilizadas no flutter em um JSON
    fun toJson(): String {

        return """{ 
                "imageURL": "$imageURL"
                }"""
    }


}