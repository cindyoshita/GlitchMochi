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

    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        routing{
            get("/Comments"){
                val commentDAO = CommentDAO()
                commentDAO.update(Comments("Hyundai", "123", 2, 3, 1, 0))
                var comments = commentDAO.getAll();
                var commentsList : MutableList<Comments> = mutableListOf()
                for (comment in comments){
                    println(comment)
                    commentsList.add(comment as Comments)
                }
                call.respondText(commentsList.toString())
            }
            get("/ola"){
                call.respondText("ola")
            }
            get("/owner/{owner}"){
                call.respondText("Bem vindo ${call.parameters["owner"]}")
            }
        }
    }.start(wait = true)

}
