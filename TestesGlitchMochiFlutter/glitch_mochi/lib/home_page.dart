import 'dart:html';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/game_post_recommendation_page.dart';

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
        height: 400,
        width: 400,
        child: ListView(
          children: [
            GestureDetector(
              onTap: () {
                Navigator.of(context).pushNamed('/recommendation');
              },
              child: Image.network(
                  "https://img.youtube.com/vi/uL8pgZ4vsfY/maxresdefault.jpg"),
            ),
            Container(
              alignment: Alignment.centerRight,
              child: (Text(
                "Texto sobre Komi-san",
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
