import 'dart:html';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/game_post_recommendation_page.dart';
import 'package:glitch_mochi/requisitions.dart';
import 'package:glitch_mochi/splash_screen.dart';

var route = '/home';
var sameTypePublication = 2;

class HomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return HomePageState();
  }
}

class HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Glitch Mochi"),
        ),
        body: Center(
          child: Posts(),
        ));
  }
}

class Posts extends StatefulWidget {
  @override
  State<Posts> createState() => _PostsState();
}

class _PostsState extends State<Posts> {
  @override
  Widget build(BuildContext context) {
    return Align(
      alignment: Alignment.bottomCenter,
      child: Center(
        child: AspectRatio(
          aspectRatio: 70 / 100,
          child: Container(
            height: MediaQuery.of(context).size.height,
            width: MediaQuery.of(context).size.width,
            child: Padding(
              padding: const EdgeInsets.fromLTRB(8, 80, 8, 0),
              child: ListView(
                // Primeira publicação
                children: [
                  GestureDetector(
                    onTap: () async {
                      sameTypePublication = 1;
                      route = '/gamerecommendation';
                      await Navigator.of(context)
                          .pushNamed('/splashscreen');
                        
                    },
                    child: Image.network(
                        "https://img.youtube.com/vi/uL8pgZ4vsfY/maxresdefault.jpg"),
                  ),
                  Container(
                    alignment: Alignment.centerRight,
                    child: (Text(
                      "texto sobre Komi-san",
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.white,
                      ),
                    )),
                  ),

                  // Segunda postagem
                  GestureDetector(
                    onTap: () async {
                      sameTypePublication = 2;
                      route = '/gamerecommendation';
                      await Navigator.of(context)
                          .pushNamed('/splashscreen');
                    },
                    child: Image.network(
                        "https://www.animeunited.com.br/oomtumtu/2021/06/86_-EIGHTY-SIX-.png"),
                  ),
                  Container(
                    alignment: Alignment.centerRight,
                    child: (Text(
                      "Texto sobre eighty six",
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.white,
                      ),
                    )),
                  ),

                  // terceira postagem manga
                   GestureDetector(
                    onTap: () async {
                      sameTypePublication = 1;
                      route = '/mangarecommendation';
                      await Navigator.of(context)
                          .pushNamed('/splashscreen');
                    },
                    child: Image.network(
                        "https://ptanime.com/wp-content/uploads/2018/02/Merc-Storia-RPG-fantasy-smartphone-game-anime-anuncio-v1.jpg"),
                  ),
                  Container(
                    alignment: Alignment.centerRight,
                    child: (Text(
                      "Texto sobre merc storia",
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.white,
                      ),
                    )),
                  ),

                  // quarta postagem manga
                   GestureDetector(
                    onTap: () async {
                      sameTypePublication = 2;
                      route = '/mangarecommendation';
                      await Navigator.of(context)
                          .pushNamed('/splashscreen');
                    },
                    child: Image.network(
                        "https://sucodemanga.com.br/wp-content/uploads/2021/09/shadows-house-thumb-2.png"),
                  ),
                  Container(
                    alignment: Alignment.centerRight,
                    child: (Text(
                      "Texto sobre shadow house",
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.white,
                      ),
                    )),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
