import 'dart:async';
import 'dart:html';

import 'dart:js';

import 'package:flutter/material.dart';

void SplashScreenTime(routeName, context){
  Timer(Duration(seconds: 3), (){
Navigator.of(context).popAndPushNamed(routeName);
  }
  );
}