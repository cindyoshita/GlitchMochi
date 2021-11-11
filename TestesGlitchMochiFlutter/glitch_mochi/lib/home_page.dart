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
      body: Posts(),
    );
  }
}

class Posts extends StatefulWidget {
  @override
  State<Posts> createState() => _PostsState();
}

class _PostsState extends State<Posts> {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        height: 500,
        width: 500,
        child: ListView(
          // Primeira publicação
          children: [
            GestureDetector(
              onTap: () {
                sameTypePublication = 1;
                Navigator.of(context).pushNamed('/gamerecommendation');
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
                ),
              )),
            ),

            // Segunda postagem
            GestureDetector(
              onTap: () {
                sameTypePublication = 2;
                Navigator.of(context).pushNamed('/gamerecommendation');
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
                ),
              )),
            ),
          ],
        ),
      ),
    );
  }
}
