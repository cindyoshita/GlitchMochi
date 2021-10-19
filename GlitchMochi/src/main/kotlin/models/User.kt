package models

import ENUMs.CARGO

data class User(
    val userName    : String,
    val password    : String,
    val avatar      : String,
    val cargo       : CARGO,
    val userID      : Int
)
