import 'package:glitch_mochi/home_page.dart';

import 'game_post_recommendation_page.dart';

// Atributos do GameRecommendation model
var userID_game;
var score_game;
var game;
var genre_game;
var titles_game = '';
var gameLenght;
var gameStudio;
var postDate_game;
var text_game;
var gameRecommendationID;

// Atributos do imageURl model
var imageURL_game = 'https://i.ytimg.com/vi/Y5k8L-ZyzJM/maxresdefault.jpg';

// Inicio localPosts
void localPosts() async {
  // requisições https
  var postGameData = await controller.getData(
      'http://localhost:8087/', 'game/$sameTypePublication');

  var imageGameData = await controller.getData(
      'http://localhost:8087/', 'imageurlgame/$sameTypePublication');

  setState(postGameData, imageGameData);
  print(imageGameData);
}

// Inicio setState
void setState(postGameData, imageGameData) {
  print("entrou setstate");
  if (postGameData != null && imageGameData != null) {
    // Atributos postGameData
    userID_game = postGameData['userID'].toString();
    score_game = postGameData['score'].toString();
    game = postGameData['game'].toString();
    genre_game = postGameData['genre'].toString();
    titles_game = postGameData['title'].toString();
    gameLenght = postGameData['gameLenght'].toString();
    gameStudio = postGameData['gameStudio'].toString();
    postDate_game = postGameData['postDate'].toString();
    text_game = postGameData['text'].toString();
    gameRecommendationID = postGameData['gameRecommendationID'].toString();

    // Atributos imageGameData
    imageURL_game = imageGameData['imageURL'].toString();
    print(imageURL_game);
  } else {
    print("GameRecommendation deu erro");
  }
}
