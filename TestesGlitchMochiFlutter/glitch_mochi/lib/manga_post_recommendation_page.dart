import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/home_page.dart';
import 'package:glitch_mochi/network_helper.dart';
import 'package:glitch_mochi/requisitions.dart';

Controller controller = new Controller();

class MangaPostRecommendation extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return _MangaPostRecommendationState();
  }
}

class _MangaPostRecommendationState extends State<MangaPostRecommendation> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('MangaPost Recommendation'),
      ),
      body: PostRecommendationBase(),
    );
  }
}

class PostRecommendationBase extends StatefulWidget{
  @override
  State<PostRecommendationBase> createState() => _PostRecommendationBaseState();
}

class _PostRecommendationBaseState extends State<PostRecommendationBase> {
  @override
  void initState(){
    super.initState();
    localPosts();
  }
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Center(
      child: AspectRatio(
        aspectRatio: 70/100,
        child: Container(
          height: 1000,
          width: 1000,
          child: ListView(
            children: [
              // Titulo da postagem do manga
              Container(
                alignment: Alignment.topCenter,
                child: Text(
                  titles_manga,
                  style: TextStyle(
                    fontSize: 50,
                    color: Colors.white,
                  ),
                ),
              ),
               // Data do Game
              Container(
                alignment: Alignment.topLeft,
                child: Text(
                  postDate_manga,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.white,
                  ),
                ),
              ),
              // Imagem do Manga
              Container(
                child: Image.network(imageURL_manga),
              ),

              // Nome  do manga
              Row(
                children: [
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      'Nome do manga: ',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.deepPurple,
                      ),
                    ),
                  ),
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      '$manga',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.pink,
                      ),
                    ),
                  ),
                ],
              ),

              // Score do Manga
              Row(
                children: [
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      'Nota: ',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.deepPurple,
                      ),
                    ),
                  ),
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      '$score_manga',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.pink,
                      ),
                    ),
                  ),
                ],
              ),

          // Genero do manga
              Row(
                children: [
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      'Genero do manga: ',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.deepPurple,
                      ),
                    ),
                  ),
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      '$genre_manga',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.pink,
                      ),
                    ),
                  ),
                ],
              ),

              // Autor do manga
              Row(
                children: [
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      'Autor do manga: ',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.deepPurple,
                      ),
                    ),
                  ),
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      '$author_manga',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.pink,
                      ),
                    ),
                  ),
                ],
              ),

              // Texto do manga
              Container(
                child: Text(
                  text_manga,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.white,
                  ),
                ),
              ),

               //commentarios do manga
              Row(
                children: [
                  Container(
                    alignment: Alignment.topLeft,
                    child: Text(
                      '\n \n '
                      '$userName_commentmanga'
                      '        \n \n \n \n ',
                      style: TextStyle(
                        fontSize: 25,
                        color: Colors.yellow,
                      ),
                    ),
                  ),
                  Container(
                      alignment: Alignment.centerRight,
                      child: Text(
                        '$text_commentmanga',
                        style: TextStyle(
                          fontSize: 20,
                          color: Colors.yellow,
                        ),
                      ))
                ],
              )
            ],
          )
          )
      ),
      );
  }
}