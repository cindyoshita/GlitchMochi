package com.glitchmochi

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.glitchmochi.plugins.*
import dao.CommentDAO

fun main() {
    val commentDAO = CommentDAO()
    CommentDAO.atualizar(Alunos(8,7.8))
    var alunos = alunosDao.pegarTodos()
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        routing{
            get("/banco"){
                for (aluno in alunos){
                    println(aluno)
                    call.respondText("${call.parameters["aluno"]}")
                }
            }
            get("/ola"){
                call.respondText("ola")
            }
            get("/nome/{nome}"){
                call.respondText("Bem vindo ${call.parameters["nome"]}")
            }
        }
    }.start(wait = true)

}
