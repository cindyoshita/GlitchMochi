package dao

interface GenericDAO{
    fun getOne (id:Int): Any;
    fun getAll(): List<Any>;
    fun insertOne(objeto:Any) : Unit;
    fun insertAll (lista : List<Any>) : Unit;
    fun update (objeto : Any) : Unit;
    fun delete (id : Int) : Unit;
}