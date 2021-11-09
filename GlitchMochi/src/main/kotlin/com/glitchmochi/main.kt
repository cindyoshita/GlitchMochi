package com.glitchmochi

import ENUMs.CARGO
import ENUMs.GENRE
import dao.*
import models.*
import java.sql.Date
import java.sql.ResultSet
import java.sql.SQLException
import java.time.LocalDate
/**
 * Fonte: https://gist.github.com/cworks/4175942
 */
@Throws(SQLException::class)
private fun resultSetToList(rs: ResultSet): MutableList<Map<String, String>> {
    val md = rs.metaData
    val columns = md.columnCount
    val rows: MutableList<Map<String, String>> = ArrayList()
    while (rs.next()) {
        val row: MutableMap<String, String> = HashMap(columns)
        for (i in 1..columns) {
            row[md.getColumnName(i)] = rs.getString(i)
        }
        rows.add(row)
    }
    return rows
}
fun main(args: Array<String>) {
    // Criar um DAO para os produtos
    val commentsDAO = CommentDAO();
    //commentsDAO.update(Comments(1, "qwqe", 666, 10, 1, 1))
    //commentsDAO.insertOne(Comments(1,"jogo bom",10,1,1,null))
    //commentsDAO.insertAll(listOf(
    // Comments(1,"jogo ", 1,1,1,null),
    // Comments(1,"jogo ", 1,1,null,null)
    //))
    //commentsDAO.delete(18)
    //var comments = commentsDAO.getAll()
    //Intera pelo resultado obtido
    //for (comment in comments) {
    //    println(comment)
    //}
    var comments = commentsDAO.getOne(10)
    println(comments)

    // Criar um DAO para os produtos
    val gameRecommendationDAO = GameRecommendationDAO()
    //gameRecommendationDAO.update(GameRecommendation(1,9.0,"Genshin",GENRE.GACHA,"gatcha roubado",20,"Mihoyo",Date.valueOf(LocalDate.now()),"Gatcha",1))
    //gameRecommendationDAO.insertOne(GameRecommendation(1,9.0,"Honkai Impact",GENRE.GACHA,"WAIFUS",10,"Mihoyo",Date.valueOf(LocalDate.now()),"Lindas ",1))
    //gameRecommendationDAO.insertAll(listOf(
    //   GameRecommendation(1,10.0,"little nightmare",
    //        GENRE.TRAGEDY,"Melhor jogo do mundo",6,"Bandai namco", Date.valueOf(LocalDate.now()),"jogo top",1),
    //    GameRecommendation(1,10.0,"little nightmare",GENRE.TRAGEDY,"Melhor jogo do mundo",6,"Bandai namco",Date.valueOf(LocalDate.now()),"jogo top",1)
    //))
    //gameRecommendationDAO.delete(11)
    var gameRecomendation = gameRecommendationDAO.getAll()
    //var gameRecomendation = gameRecommendationDAO.getOne(1)
    //println(gameRecomendation)
    //Intera pelo resultado obtido
    for (game in gameRecomendation) {
        println(game)
    }

    // Criar um DAO para os produtos
    val mangaRecommendationDAO = MangaRecommendationDAO()
    //mangaRecommendationDAO.update(MangaRecommendation(2,8.0,"jin/shizen no teki-p",GENRE.ACTION,"kagepro",Date.valueOf(LocalDate.now()),"bom manga com final ruim", 2, "kagerou daze"))
    //mangaRecommendationDAO.insertOne(MangaRecommendation( 2,9.0,"shoujo top", GENRE.SHOUJO, "sakisaka io",Date.valueOf(LocalDate.now()),"shoujo bom",3,"ao haru ride" ))
    //mangaRecommendationDAO.insertAll(listOf(
    //MangaRecommendation( 2,9.5,"shoujo topop", GENRE.SHOUJO, "sakisaka io",Date.valueOf(LocalDate.now()),"shoujo bom",4,"omoi omoware furi furare" ),
    // MangaRecommendation( 2,8.0,"shounen top", GENRE.SHOUNEN, "atsushi okubo",Date.valueOf(LocalDate.now()),"shounen bom",5,"soul eater")
    //))
    //mangaRecommendationDAO.delete(8)
    var mangaRecomendation = mangaRecommendationDAO.getAll()
    //var mangaRecomendation = mangaRecommendationDAO.getOne(1)
    //println(mangaRecomendation)
    //Intera pelo resultado obtido
    for (manga in mangaRecomendation) {
        println(manga)
    }

    val userDAO = UserDAO()
    //userDAO.update(User("Alice","1234Alice","imagemBonita", CARGO.ADM,1))
    //userDAO.insertOne(User("Mochi","1234Mochi","MochiImage",CARGO.ADM,4))
    //userDAO.insertAll(listOf(
    //    User("Albert","1234Albert","AlbertImage",CARGO.COMMON,3),
    //    User("Io","1234Io","IoImage",CARGO.COMMON,4),
    //))
    //userDAO.delete(4)
    var users = userDAO.getAll()
    //Intera pelo resultado obtido
    for (user in users) {
        println(user)
    }

    // Criar um DAO para os produtos
    val imageURLDAO = ImageURLDAO()
    //imageURLDAO.update(ImageURL("image3",1,null, 1))
    //imageURLDAO.insertOne(ImageURL("image4",null,1,4))
    //imageURLDAO.insertAll(listOf(
    //    ImageURL("imagem5",null,1,3),
    //    ImageURL("imagem6",1,null,4),
    //))
    //imageURLDAO.delete(5)
    //var imagesURL = imageURLDAO.getAll()
    var imagesURL = imageURLDAO.getOne(1)
    println(imagesURL)
    //Intera pelo resultado obtido
    //for (image in imagesURL) {
    //    println(image)
    //}

    var manga = mangaRecommendationDAO.getImage(1)
   //mangaRecomendation = mangaRecommendationDAO.getAll()
    //var mangaRecomendation = mangaRecommendationDAO.getOne(1)
    //println(mangaRecomendation)
    //Intera pelo resultado obtido
    while (manga?.next()!!) {
        println(manga.getString("imageURL"))
    }
}
// Date.valueOf(LocalDate.now())
