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
var userName_comment = '';

// Atributos do MangaRecommendation model
var userID_manga;
var score_manga = '';
var manga = '';
var genre_manga = '';
var titles_manga = '';
var postDate_manga;
var text_manga = '';
var mangaRecommendationID;
var author_manga = '';

// Atributos do imageURl manga model
var imageURL_manga = 'https://sucodemanga.com.br/wp-content/uploads/2021/09/shadows-house-thumb-2.png';

// Atributos do commentmanga model
var userID_commentmanga;
var text_commentmanga = '';
var likes_commentmanga = '';
var userName_commentmanga = '';

// Inicio localPosts
void localPosts() async {
  // requisições https
  var postGameData = await controller.getData(
      'http://localhost:8087/', 'game/$sameTypePublication');

  var imageGameData = await controller.getData(
      'http://localhost:8087/', 'imageurlgame/$sameTypePublication');

  var commentGameData = await controller.getData(
      'http://localhost:8087/', 'commentgame/$sameTypePublication');

  var postMangaData = await controller.getData(
      'http://localhost:8087/', 'manga/$sameTypePublication');

  var imageMangaData = await controller.getData(
      'http://localhost:8087/', 'imageurlmanga/$sameTypePublication');  

  var commentMangaData = await controller.getData(
      'http://localhost:8087/', 'commentmanga/$sameTypePublication');          

  setState(postGameData, imageGameData, commentGameData, postMangaData, imageMangaData, commentMangaData);
  print(imageGameData);
}


// Inicio setState
void setState(postGameData, imageGameData, commentGameData, postMangaData, imageMangaData, commentMangaData) async {
  print("entrou setstate");
  if (postGameData != null && imageGameData != null && imageMangaData != null && postMangaData != null) {
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
    userID_comment = await commentGameData['userID'].toString();
    text_comment = await commentGameData['text'].toString();
    likes_comment = await commentGameData['like'].toString();
    userName_comment = await commentGameData['userName'].toString();

    // Atributos PostMangaData
    userID_manga = await postMangaData['userID'].toString();
    score_manga = await postMangaData['score'].toString();
    titles_manga = await postMangaData['title'].toString();
    genre_manga = await postMangaData['genre'].toString();
    author_manga = await postMangaData['author'].toString();
    postDate_manga = await postMangaData['postDate'].toString();
    text_manga = await postMangaData['text'].toString();
    manga = await postMangaData['manga'].toString();
    mangaRecommendationID = await postMangaData['mangaRecommendationID'].toString();

     // Atributos imageMangaData
    imageURL_manga = await imageMangaData['imageURL'].toString();

    // Atributos commentMangaData
    userID_commentmanga = await commentMangaData['userID'].toString();
    text_commentmanga = await commentMangaData['text'].toString();
    likes_commentmanga = await commentMangaData['like'].toString();
    userName_commentmanga = await commentMangaData['userName'].toString();

  } else {
    print("GameRecommendation deu erro");
  }
}
