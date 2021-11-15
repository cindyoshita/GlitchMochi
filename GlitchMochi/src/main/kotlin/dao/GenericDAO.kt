package dao

// Interface de um DAO generico
interface GenericDAO{
    fun getOne (id:Int): Any;
}