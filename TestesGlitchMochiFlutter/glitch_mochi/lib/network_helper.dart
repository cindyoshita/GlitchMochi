import 'dart:convert';
import 'package:glitch_mochi/game_post_recommendation_page.dart';
import 'package:http/http.dart' as http;

GamePostRecommendation pr = new GamePostRecommendation();

class NetworkHelper {
  final String url;
  NetworkHelper({required this.url});

  Future getData(String endPoint) async {
    http.Response response = await http.get(Uri.parse(url + endPoint));

    if (response.statusCode == 200) {
      print('entrou no if');
      // Resultado da requisição
      return jsonDecode(response.body);
    } else {
      print('entrou no else');
      print(response.statusCode);
      return null;
    }
  }
}

class Controller {
  Future<dynamic> getData(url, endPoint) async {
    NetworkHelper networkHelper = NetworkHelper(url: url);
    var data = await networkHelper.getData(endPoint);
    return data;
  }
}

Future postDate(String endPoint, var json) async {}
