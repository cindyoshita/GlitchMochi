package dao

class CommentDAO : GenericDAO {

    override fun pegarTodos(): List<Any> {
        val alunos = mutableListOf<Alunos>()
        var connection : Connectiondao? = null
        try {
            // Criar uma comexão com o banco
            connection = Connectiondao()
            // Executa uma querie de busca
            val resultSet = connection.executeQuery("SELECT * FROM Alunos")
            // Intera pelo resultado obtido
            while (resultSet?.next()!!) {
                alunos.add(
                    Alunos(
                        resultSet.getInt(("id")),
                        resultSet.getDouble("nota")
                    )
                )
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        finally {
            connection?.close()
        }
        return alunos

    }

    override fun inserirUm(objeto: Any) {
        val connectiondao = Connectiondao()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO Alunos  
            (Nota)
            VALUES (?);
            """.trimMargin())
        val aluno = objeto as Alunos
        preparedStatement?.setDouble(1, aluno.Nota)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun inserirVarios(lista: List<Any>) {
        val connectiondao = Connectiondao()
        val preparedStatement = connectiondao.getPreparedStatement("""
            INSERT INTO Alunos  
            (Nota)
            VALUES (?);
            """.trimMargin())
        for (objeto in lista) {
            val aluno = objeto as Alunos
            preparedStatement?.setDouble(1, aluno.Nota)
            preparedStatement?.executeUpdate()
            // Banco ja esta em auto commit
            //connectiondao.commit()
        }
        connectiondao.close()
    }

    override fun atualizar(objeto: Any) {
        val connectiondao = Connectiondao()
        val preparedStatement = connectiondao.getPreparedStatement("""
            UPDATE Alunos  
            SET Nota = ?
            WHERE id = ?;
            """.trimMargin())
        val aluno = objeto as Alunos
        preparedStatement?.setDouble(1, aluno.Nota)
        preparedStatement?.setInt(2, aluno.id)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }

    override fun deletar(id: Int) {
        val connectiondao = Connectiondao()
        val preparedStatement = connectiondao.getPreparedStatement("""
            DELETE FROM Alunos
            WHERE id = ?
            """.trimMargin())
        preparedStatement?.setInt(1, id)
        preparedStatement?.executeUpdate()
        // Banco ja esta em auto commit
        //connectiondao.commit()
        connectiondao.close()
    }
}