import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'pages/home.dart';
import 'pages/login.dart'; 
import 'pages/signup.dart'; 
import 'pages/onboarding.dart'; 
import 'pages/splash_screen.dart'; 



void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(); // Initialize Firebase
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Auth App',
      debugShowCheckedModeBanner: false,
      home: const SplashScreen(), // Set the SplashScreen as the first screen
      routes: {
        '/home': (context) => const Home(),
        '/login': (context) => const LoginPage(),
        '/signup': (context) => const SignupPage(),
        '/onboarding': (context) => const OnboardingScreen(), 
      },
    );
  }
}