import 'dart:html';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/game_post_recommendation_page.dart';
import 'package:glitch_mochi/requisitions.dart';

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
                      await Navigator.of(context)
                          .pushNamed('/gamerecommendation');
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
                      await Navigator.of(context)
                          .pushNamed('/gamerecommendation');
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
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
