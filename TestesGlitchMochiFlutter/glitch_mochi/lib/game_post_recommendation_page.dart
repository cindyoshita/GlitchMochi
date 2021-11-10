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
var titles;
var gameLenght;
var gameStudio;
var postDate;

String text = '';
var gameRecommendationID;

void localPosts() async {
  var postGameData = await controller.getData(
      'http://localhost:8087/', 'game/$sameTypePublication');
  setState(postGameData);
  print(postGameData);
}

void setState(postGameData) {
  print("entrou setstate");
  if (postGameData != null) {
    userID = postGameData['userID'].toString();
    score = postGameData['score'].toString();
    game = postGameData['game'].toString();
    genre = postGameData['genre'].toString();
    titles = postGameData['title'].toString();
    gameLenght = postGameData['gameLenght'].toString();
    gameStudio = postGameData['gameStudio'].toString();
    postDate = postGameData['postDate'].toString();
    text = postGameData['text'].toString();
    print(text);
    gameRecommendationID = postGameData['gameRecommendationID'].toString();
  } else {
    print("GameRecommendation deu erro");
  }
}

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
