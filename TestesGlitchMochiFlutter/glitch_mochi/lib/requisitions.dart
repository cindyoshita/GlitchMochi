import 'package:glitch_mochi/home_page.dart';

import 'game_post_recommendation_page.dart';

// Atributos do GameRecommendation model
var userID_game;
var score_game = '';
var game = '';
var genre_game = '';
var titles_game = '';
var gameLenght = '';
var gameStudio = '';
var postDate_game;
var text_game = '';
var gameRecommendationID;

// Atributos do imageURl model
var imageURL_game = 'https://i.ytimg.com/vi/Y5k8L-ZyzJM/maxresdefault.jpg';

// Atributos do comment model
var userID_comment;
var text_comment = '';
var likes_comment = '';

// Inicio localPosts
void localPosts() async {
  // requisições https
  var postGameData = await controller.getData(
      'http://localhost:8087/', 'game/$sameTypePublication');

  var imageGameData = await controller.getData(
      'http://localhost:8087/', 'imageurlgame/$sameTypePublication');

  var commentGameData = await controller.getData(
      'http://localhost:8087/', 'commentgame/$sameTypePublication');

  setState(postGameData, imageGameData);
  print(imageGameData);
}

// Inicio setState
void setState(postGameData, imageGameData) async {
  print("entrou setstate");
  if (postGameData != null && imageGameData != null) {
    // Atributos postGameData
    userID_game = await postGameData['userID'].toString();
    score_game = await postGameData['score'].toString();
    game = await postGameData['game'].toString();
    genre_game = await postGameData['genre'].toString();
    titles_game = await postGameData['title'].toString();
    gameLenght = await postGameData['gameLenght'].toString();
    gameStudio = await postGameData['gameStudio'].toString();
    postDate_game = await postGameData['postDate'].toString();
    text_game = await postGameData['text'].toString();
    gameRecommendationID =
        await postGameData['gameRecommendationID'].toString();

    // Atributos imageGameData
    imageURL_game = await imageGameData['imageURL'].toString();

    // Atributos commentGameData
    // userID_comment = await commentGameData['userID'].toString();
    // text_comment = await commentGameData['text'].toString();
    // likes_comment = await commentGameData['like'].toString();
  } else {
    print("GameRecommendation deu erro");
  }
}
