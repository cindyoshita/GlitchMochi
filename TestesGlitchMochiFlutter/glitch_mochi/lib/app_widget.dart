import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:glitch_mochi/home_page.dart';
import 'package:glitch_mochi/game_post_recommendation_page.dart';
import 'package:glitch_mochi/manga_post_recommendation_page.dart';
import 'package:glitch_mochi/splash_screen.dart';

class AppWidget extends StatefulWidget {
  @override
  State<AppWidget> createState() => _AppWidgetState();
}

class _AppWidgetState extends State<AppWidget> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      title: 'Glitch Mochi',
      theme: ThemeData(
        scaffoldBackgroundColor: Colors.black87,
        primarySwatch: Colors.deepPurple,
      ),
      home: HomePage(),
      initialRoute: '/home',
      routes: {
        '/home': (context) => HomePage(),
        '/gamerecommendation': (context) => GamePostRecommendation(),
        '/mangarecommendation': (context) => MangaPostRecommendation(),
        '/splashscreen': (context) => Splash(),
      },
    );
  }
}
