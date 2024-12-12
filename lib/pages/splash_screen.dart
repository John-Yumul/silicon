import 'dart:async';
import 'package:flutter/material.dart';
import 'onboarding.dart'; // Make sure this import is correct

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    // Set the timer to navigate after 2 seconds
    Timer(
      const Duration(seconds: 2),
      () => Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => const OnboardingScreen()),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF0080F4), // Splash screen background color
      body: const Center(
        child: Text(
          'Silicon', // The name of your app
          style: TextStyle(
            fontFamily: 'Outfit', // Ensure the font is declared in pubspec.yaml
            fontWeight: FontWeight.w800, // ExtraBold weight
            fontSize: 40,
            color: Colors.white, // Text color
          ),
        ),
      ),
    );
  }
}
