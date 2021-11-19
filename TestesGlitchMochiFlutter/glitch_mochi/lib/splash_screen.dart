import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/home_page.dart';
import 'package:glitch_mochi/network_helper.dart';
import 'package:glitch_mochi/requisitions.dart';
import 'package:glitch_mochi/timer.dart';



class Splash extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _SplashState();
  }
}

class _SplashState extends State<Splash> {
  @override
  Widget build(BuildContext context) {
   return Scaffold(
      appBar: AppBar(
        title: Text("Splash Screen"),
      ),
      body:SplashScreenBase(),
    );
  }
}

class SplashScreenBase extends StatefulWidget {
  @override
  State<SplashScreenBase> createState() => _SplashScreenState();
}

class _SplashScreenState extends State <SplashScreenBase> {
  @override
  void initState() {
    SplashScreenTime(route, context);
    super.initState();
    localPosts();
  }

  @override
  Widget build(BuildContext context) {
    return Center(child: AspectRatio(
        aspectRatio: 70 / 100,
        child: Container(
          height: 1000,
          width: 1000,
          child: ListView(
            children: [
              // Titulo da pagina
              Container(
                alignment: Alignment.topCenter,
                child: Text(
                  "Loading",
                  style: TextStyle(
                    fontSize: 50,
                    color: Colors.white,
                  ),
                ),
              ),
              // Imagem do Game
              Container(
                child: Image.network("https://i.pinimg.com/originals/a5/46/45/a54645c9a2150d4278619fbf1a697a91.jpg"),
              )
              ]
          )
        )
          )
          );
  }
}