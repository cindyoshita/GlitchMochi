import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/home_page.dart';
import 'package:glitch_mochi/network_helper.dart';
import 'package:glitch_mochi/requisitions.dart';

Controller controller = new Controller();

class GamePostRecommendation extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return GamePostRecommendationState();
  }
}

class GamePostRecommendationState extends State<GamePostRecommendation> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("GamePost recommendation"),
      ),
      body: PostRecommendationBase(),
    );
  }
}

class PostRecommendationBase extends StatefulWidget {
  @override
  State<PostRecommendationBase> createState() => _PostRecommendationBaseState();
}

class _PostRecommendationBaseState extends State<PostRecommendationBase> {
  @override
  void initState() {
    super.initState();
    localPosts();
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: AspectRatio(
        aspectRatio: 70 / 100,
        child: Container(
          height: 1000,
          width: 1000,
          child: ListView(
            children: [
              // Titulo do game
              Container(
                alignment: Alignment.topCenter,
                child: Text(
                  titles_game,
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
                  postDate_game,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.white,
                  ),
                ),
              ),
              GestureDetector(
                onTap: () {
                  Navigator.of(context).push(
                      MaterialPageRoute(builder: (context) => HomePage()));
                },
                child: Image.network(imageURL_game),
              ),

              // Nome  do game
              Container(
                alignment: Alignment.topLeft,
                child: Text(
                  game,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.deepPurple,
                  ),
                ),
              ),

              // Score do Game
              Container(
                alignment: Alignment.topLeft,
                child: Text(
                  score_game,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.deepPurple,
                  ),
                ),
              ),

              // Genero do game
              Container(
                alignment: Alignment.topLeft,
                child: Text(
                  genre_game,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.deepPurple,
                  ),
                ),
              ),

              // Studio do Game
              Container(
                alignment: Alignment.topLeft,
                child: Text(
                  gameStudio,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.deepPurple,
                  ),
                ),
              ),

              // LongToBeat do game
              Container(
                alignment: Alignment.topLeft,
                child: Text(
                  gameLenght,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.deepPurple,
                  ),
                ),
              ),

              // Texto do game
              Container(
                child: Text(
                  text_game,
                  style: TextStyle(
                    fontSize: 20,
                    color: Colors.white,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
