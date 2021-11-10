import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/home_page.dart';
import 'package:glitch_mochi/network_helper.dart';

Controller controller = new Controller();

// Atributos do GameRecommendation model
var userID;
var score;
var game;
var genre;
var title;
var gameLenght;
var gameStudio;
var postDate;
var text;
var gameRecommendationID;

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

class PostRecommendationBase extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        height: 300,
        width: 300,
        child: ListView(
          children: [
            GestureDetector(
              onTap: () {
                Navigator.of(context)
                    .push(MaterialPageRoute(builder: (context) => HomePage()));
              },
              child: Image.network(
                  "https://cdn.cloudflare.steamstatic.com/steam/apps/920320/capsule_616x353.jpg?t=1635397862"),
            ),
            Text(text),
          ],
        ),
      ),
    );
  }
}

void localPosts() async {
  var postGameData = await controller.getData('http://localhost/', 'game/1');

  setState() {
    if (postGameData != null) {
      userID = postGameData['userID'].toString();
      score = postGameData['score'].toString();
      game = postGameData['game'].toString();
      genre = postGameData['genre'].toString();
      title = postGameData['title'].toString();
      gameLenght = postGameData['gameLenght'].toString();
      gameStudio = postGameData['gameStudio'].toString();
      postDate = postGameData['postDate'].toString();
      text = postGameData['text'].toString();
      gameRecommendationID = postGameData['gameRecommendationID'].toString();
    } else {
      print("GameRecommendation deu erro");
    }
  }
}
