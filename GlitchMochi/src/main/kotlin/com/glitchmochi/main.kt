package com.glitchmochi

import dao.CommentDAO
import models.Comments


fun main(args: Array<String>) {
    // Criar um DAO para os produtos
    val commentsDAO = CommentDAO()
    commentsDAO.update(Comments("usuario","qwqe",666,1))
    var comments = commentsDAO.getAll()
    //Intera pelo resultado obtido
    for (comment in comments){
        println(comment)
    }/*
    alunosDao.inserirUm(Alunos(0,6.8))
    alunosDao.inserirVarios(
        listOf(Alunos(200,7.7),
                            Alunos(200,0.0)))
    alunos = alunosDao.pegarTodos()
    for (aluno in alunos){
        println(aluno)
    }*/
}