package models

import ENUMs.CARGO

// Variaveis encontrados no User do banco de dados e usado nesse programa
data class User(
    val userName    : String,
    val password    : String,
    val avatar      : String,
    val cargo       : CARGO,
    val userID      : Int
){// Transformar as variaveis utilizadas no flutter em um JSON
fun toJson(): String {
    return """{ 
                "userName": $userName, 
                "password": $password,
                "avatar": "$avatar", 
                "cargo": "$cargo", 
                "userID": "$userID",
                }"""
}
}
