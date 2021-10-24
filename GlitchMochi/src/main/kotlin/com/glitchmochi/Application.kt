package com.glitchmochi

import ENUMs.TYPE
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dao.CommentDAO
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import models.Comments

fun main() {
    val commentDAO = CommentDAO()
    commentDAO.update(Comments("Hyundai", "123", 2, 3, TYPE.MANGA))
    var comments = commentDAO.getAll();
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        routing{
            get("/banco"){
                for (aluno in comments){
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
