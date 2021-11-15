
package com.glitchmochi

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


fun main() {

    // Conectamos com o server do localhost e a porta 8087
    embeddedServer(Netty, port = 8087, host = "0.0.0.0") {

        // Conectamos com o flutter
        install (CORS){method(HttpMethod.Options)
            anyHost()}

        routing{
            get("/game/{gameid}"){//Essa rota pega os valores do GameRecommendation do banco de dados e faz a acao solicitada
                val gameid : Int = call.parameters["gameid"]!!.toInt() // Atribui ao gameid o numero colocado na rota
                val gameRecommendationDAO : GameRecommendationDAO = GameRecommendationDAO()
                val gr = gameRecommendationDAO.getOne(gameid) // Atribui ao gr a acao de GetOne do GameRecoomendationDAO no número do gameid
                call.respondText(gr.toJson()) // Transforma o gr em JSON e coloca na rota
            }
            get("/manga/{mangaid}"){//Essa rota pega os valores do MangaRecommendation do banco de dados e faz a acao solicitada
                val mangaid : Int = call.parameters["mangaid"]!!.toInt() // Atribui ao mangaid o numero colocado na rota
                val mangaRecommendationDAO : MangaRecommendationDAO = MangaRecommendationDAO()
                val mr = mangaRecommendationDAO.getOne(mangaid) // Atribui ao mr a acao de GetOne do MangaRecoomendationDAO no número do mangaid
                call.respondText(mr.toJson()) // Transforma o mr em JSON e coloca na rota
            }

            get("/comment/{commentid}"){//Essa rota pega os valores do comment do banco de dados e faz a acao solicitada
                val commentid : Int = call.parameters["commentid"]!!.toInt() // Atribui ao commentid o numero colocado na rota
                val commentDAO : CommentDAO = CommentDAO()
                val comment = commentDAO.getOne(commentid) // Atribui ao comment a acao de GetOne do CommentDAO no número do commentid
                call.respondText(comment.toJson()) // Transforma o comment em JSON e coloca na rota
            }

            get("/imageurlgame/{imageid}"){//Essa rota pega os valores do imageURL do banco de dados e faz a acao solicitada
                val imageid : Int = call.parameters["imageid"]!!.toInt() // Atribui ao imageid o numero colocado na rota
                val imageURLDAO : ImageURLDAO = ImageURLDAO()
                val imageURLgame = imageURLDAO.getOneGame(imageid)// Atribui ao imageURLgame a acao de GetOneGame do ImageURLDAO no número do imageid
                call.respondText(imageURLgame.toJson())// Transforma o comment em JSON e coloca na rota
            }

            get("/imageurlmanga/{imageid}"){//Essa rota pega os valores do imageURL do banco de dados e faz a acao solicitada
                val imageid : Int = call.parameters["imageid"]!!.toInt()// Atribui ao imageid o numero colocado na rota
                val imageURLDAO : ImageURLDAO = ImageURLDAO()
                val imageURLmanga = imageURLDAO.getOneManga(imageid)// Atribui ao imageURLmanga a acao de GetOneGame do ImageURLDAO no número do imageid
                call.respondText(imageURLmanga.toJson()) // Transforma o comment em JSON e coloca na rota
            }

        }
    }.start(wait = true)

}
