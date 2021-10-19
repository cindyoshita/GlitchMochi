package dao

interface GenericDAO
    fun pegarUm (id:Int): Any;
    fun pegarTodos(): List<Any>;
    fun inserirUm(objeto:Any) : Unit;
    fun inserirVarios (lista : List<Any>) : Unit;
    fun atualizar (objeto : Any) : Unit;
    fun deletar (id : Int) : Unit;
}