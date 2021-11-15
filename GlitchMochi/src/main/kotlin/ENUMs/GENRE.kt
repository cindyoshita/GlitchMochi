package ENUMs

// ENUM dos possiveis generos dos post de manga e game recommendation
//Observacao: A contagem dos enums dentro do banco de dados (comeca com 1) difere da contagem (comeca com 0) dos enums no kotlin, por isso, inicia com null
enum class GENRE {
    NULL,MYSTERY, ACTION, TRAGEDY, RPG, JRPG,
    ROMANCE, FANTASY, GACHA, SHOUNEN, SHOUJO,
    JOSEI, SEINEN, HAREM
}