import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/home_page.dart';
import 'package:glitch_mochi/network_helper.dart';

Controller controller = new Controller();

class PostRecommendation extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return PostRecommendationState();
  }
}

class PostRecommendationState extends State<PostRecommendation> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Post recommendation"),
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
            Text("Texto sobre o jogo"),
          ],
        ),
      ),
    );
  }
}

void localPosts() async {
  var postData = await controller.getData('http://localhost/', 'game/1');
}
