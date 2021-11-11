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
              child: Image.network(imageURL_game),
            ),
            Text(titles_game),
          ],
        ),
      ),
    );
  }
}
