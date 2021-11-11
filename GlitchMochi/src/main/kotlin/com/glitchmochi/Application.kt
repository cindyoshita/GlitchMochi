
package com.glitchmochi

import ENUMs.TYPE
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dao.CommentDAO
import dao.GameRecommendationDAO
import dao.ImageURLDAO
import dao.MangaRecommendationDAO
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import models.Comments
import models.GameRecommendation

fun main() {

    embeddedServer(Netty, port = 8087, host = "0.0.0.0") {

        install (CORS){method(HttpMethod.Options)
            anyHost()}

        routing{
            get("/game/{gameid}"){
                val gameid : Int = call.parameters["gameid"]!!.toInt()
                val gameRecommendationDAO : GameRecommendationDAO = GameRecommendationDAO()
                val imageURLDAO : ImageURLDAO = ImageURLDAO()
                val gr = gameRecommendationDAO.getOne(gameid)
                val image = imageURLDAO.getOne(gameid)
                val image2 = gameRecommendationDAO.getImage(gameid)
                call.respondText(gr.toJson())
            }
            get("/manga/{mangaid}"){
                val mangaid : Int = call.parameters["mangaid"]!!.toInt()
                val mangaRecommendationDAO : MangaRecommendationDAO = MangaRecommendationDAO()
                val mr = mangaRecommendationDAO.getOne(mangaid)
                call.respondText(mr.toJson())
            }

            get("/comentario/{comentarioid}"){
                val commentid : Int = call.parameters["comentarioid"]!!.toInt()
                val commentDAO : CommentDAO = CommentDAO()
                val comment = commentDAO.getOne(commentid)
                call.respondText(comment.toString())
            }

            get("/imageurlgame/{imageid}"){
                val imageid : Int = call.parameters["imageid"]!!.toInt()
                val imageURLDAO : ImageURLDAO = ImageURLDAO()
                val imageURLgame = imageURLDAO.getOneGame(imageid)
                call.respondText(imageURLgame.toJson())
            }

            get("/imageurlmanga/{imageid}"){
                val imageid : Int = call.parameters["imageid"]!!.toInt()
                val imageURLDAO : ImageURLDAO = ImageURLDAO()
                val imageURLmanga = imageURLDAO.getOneManga(imageid)
                call.respondText(imageURLmanga.toJson())
            }

        }
    }.start(wait = true)

}
