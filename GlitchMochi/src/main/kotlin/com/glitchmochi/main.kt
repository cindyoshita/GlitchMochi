package com.glitchmochi

import ENUMs.GENRE
import ENUMs.TYPE
import dao.CommentDAO
import dao.GameRecommendationDAO
import models.Comments
import models.GameRecommendation


fun main(args: Array<String>) {
    // Criar um DAO para os produtos
    val commentsDAO = CommentDAO()
    commentsDAO.update(Comments("usuario", "qwqe", 666, 1, 1, 0))
    var comments = commentsDAO.getAll()
    //Intera pelo resultado obtido
    for (comment in comments){
        println(comment)
    }

        // Criar um DAO para os produtos
        val gameRecommendationDAO = GameRecommendationDAO()
        gameRecommendationDAO.update(GameRecommendation(1, 7.5,"sass", "Pokemon", GENRE.ACTION, "Que legal", 2, "HiRez", 2, "Ola", 1))
        var gameRecomendation = gameRecommendationDAO.getAll()
        //Intera pelo resultado obtido
        for (game in gameRecomendation){
            println(gameRecomendation)
    }



/*
    alunosDao.inserirUm(Alunos(0,6.8))
    alunosDao.inserirVarios(
        listOf(Alunos(200,7.7),
                            Alunos(200,0.0)))
    alunos = alunosDao.pegarTodos()
    for (aluno in alunos){
        println(aluno)
    }*/
}