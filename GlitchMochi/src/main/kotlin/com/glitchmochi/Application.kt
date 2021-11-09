
package com.glitchmochi

import ENUMs.TYPE
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dao.CommentDAO
import dao.GameRecommendationDAO
import dao.ImageURLDAO
import dao.MangaRecommendationDAO
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import models.Comments
import models.GameRecommendation

fun main() {

    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        routing{
            get("/jogo/{jogoid}"){
                val jogoid : Int = call.parameters["jogoid"]!!.toInt()
                val gameRecommendationDAO : GameRecommendationDAO = GameRecommendationDAO()
                val gr = gameRecommendationDAO.getOne(jogoid)
                call.respondText(gr.toString())
            }
            get("/manga/{mangaid}"){
                val mangaid : Int = call.parameters["mangaid"]!!.toInt()
                val mangaRecommendationDAO : MangaRecommendationDAO = MangaRecommendationDAO()
                val mr = mangaRecommendationDAO.getOne(mangaid)
                call.respondText(mr.toString())
            }
            get("/imagem/{imagemid}"){
                val imageid : Int = call.parameters["imagemid"]!!.toInt()
                val imageDAO : ImageURLDAO = ImageURLDAO()
                val image = imageDAO.getOne(imageid)
                call.respondText(image.toString())
            }
            get("/comentario/{comentarioid}"){
                val commentid : Int = call.parameters["comentarioid"]!!.toInt()
                val commentDAO : CommentDAO = CommentDAO()
                val comment = commentDAO.getOne(commentid)
                call.respondText(comment.toString())
            }
        }
    }.start(wait = true)

}
