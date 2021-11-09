
package com.glitchmochi

import ENUMs.TYPE
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dao.CommentDAO
import dao.GameRecommendationDAO
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import models.Comments
import models.GameRecommendation

fun main() {

    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        routing{
            get("/ola"){
                println("Entrou na rota ola")
                call.respondText("ola")
            }
            get("/owner/{owner}"){
                call.respondText("Bem vindo ${call.parameters["owner"]}")
            }
            get("/jogo/{jogoid}"){
                val jogoid : Int = call.parameters["jogoid"]!!.toInt()
                val gameRecommendationDAO : GameRecommendationDAO = GameRecommendationDAO()
                val gr = gameRecommendationDAO.getOne(jogoid)
                call.respondText(gr.toString())
            }
        }
    }.start(wait = true)

}
