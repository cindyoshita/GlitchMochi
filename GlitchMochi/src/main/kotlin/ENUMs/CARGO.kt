package ENUMs

// ENUM dos cargos possíveis dentro dos usuarios
//Observacao: A contagem dos enums dentro do banco de dados (comeca com 1) difere da contagem (comeca com 0) dos enums no kotlin, por isso, inicia com null
enum class CARGO {
    NULL,ADM, COMMON, WRITER
}