import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart'; // Use image_picker package
import 'package:cloud_firestore/cloud_firestore.dart'; // Firebase Firestore
import 'package:firebase_auth/firebase_auth.dart';
import 'dart:io';
import 'package:http/http.dart' as http;
import 'dart:convert';

class AddListingPage extends StatefulWidget {
  const AddListingPage({super.key});

  @override
  _AddListingPageState createState() => _AddListingPageState();
}

class _AddListingPageState extends State<AddListingPage> {
  final _formKey = GlobalKey<FormState>();
  String? uploadedPhotoPath; // Local file path of the selected image
  String? uploadedPhotoUrl; // URL of the uploaded image on Cloudinary

  final TextEditingController titleController = TextEditingController();
  final TextEditingController descriptionController = TextEditingController();
  final TextEditingController minInvestmentController = TextEditingController();
  final TextEditingController targetInvestmentController = TextEditingController();
  final TextEditingController contactController = TextEditingController();

  final List<String> categories = [
    "Real Estate",
    "Technology",
    "Healthcare",
    "Education",
    "Energy",
    "Retail",
  ];

  String? selectedCategory;

  // Instance of ImagePicker
  final ImagePicker _picker = ImagePicker();

  Future<void> selectFile() async {
    // Use image_picker to pick an image from the gallery
    final XFile? image = await _picker.pickImage(source: ImageSource.gallery);

    if (image != null) {
      File selectedFile = File(image.path);
      String? url = await _uploadImage(selectedFile);

      setState(() {
        uploadedPhotoPath = selectedFile.path;
        uploadedPhotoUrl = url;
      });
    } else {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text("No file selected")),
      );
    }
  }

  Future<String?> _uploadImage(File imageFile) async {
    final url = Uri.parse('https://api.cloudinary.com/v1_1/dra2q8hzs/upload');
    const uploadPreset = 'preset'; // Replace with your Cloudinary upload preset

    try {
      final request = http.MultipartRequest('POST', url)
        ..fields['upload_preset'] = uploadPreset
        ..files.add(await http.MultipartFile.fromPath(
          'file',
          imageFile.path,
        ));

      final response = await request.send();

      if (response.statusCode == 200) {
        final responseBody = await response.stream.bytesToString();
        final jsonResponse = json.decode(responseBody);
        return jsonResponse['secure_url'];
      } else {
        print('Upload failed with status: ${response.statusCode}');
      }
    } catch (e) {
      print('Error uploading image: $e');
    }
    return null;
  }

  Future<void> _submitListing() async {
    if (_formKey.currentState!.validate()) {
      if (uploadedPhotoUrl == null) {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text("Please upload a photo")),
        );
        return;
      }

      // Get the current user
      final user = FirebaseAuth.instance.currentUser;
      if (user == null) {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text("No user logged in")),
        );
        return;
      }

      // Prepare data to store in Firebase
      final listingData = {
        "title": titleController.text,
        "description": descriptionController.text,
        "minInvestment": minInvestmentController.text,
        "targetInvestment": targetInvestmentController.text,
        "contact": contactController.text,
        "photoUrl": uploadedPhotoUrl,
        "category": selectedCategory,
        "createdAt": Timestamp.now(),
        "createdBy": {
          "uid": user.uid,
          "email": user.email,
        },
      };

      try {
        await FirebaseFirestore.instance.collection('listings').add(listingData);
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text("Listing Submitted!")),
        );
        Navigator.pop(context); // Navigate back to the previous screen
      } catch (e) {
        print("Error saving listing: $e");
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text("Failed to submit listing")),
        );
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Add Listing"),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: ListView(
            children: [
              const Text(
                "Add a Photo",
                style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                ),
              ),
              const SizedBox(height: 8),
              Center(
                child: ElevatedButton.icon(
                  onPressed: selectFile,
                  icon: const Icon(Icons.upload_file),
                  label: const Text("Upload Photo"),
                ),
              ),
              const SizedBox(height: 16),
              if (uploadedPhotoPath != null)
                Center(
                  child: Column(
                    children: [
                      const Text(
                        "Photo Preview:",
                        style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                      ),
                      const SizedBox(height: 8),
                      Image.file(
                        File(uploadedPhotoPath!),
                        width: 150,
                        height: 150,
                        fit: BoxFit.cover,
                      ),
                    ],
                  ),
                ),
              const SizedBox(height: 16),
              TextFormField(
                controller: titleController,
                decoration: const InputDecoration(
                  labelText: "Title",
                  border: OutlineInputBorder(),
                ),
                validator: (value) =>
                    value == null || value.isEmpty ? "Please enter a title" : null,
              ),
              const SizedBox(height: 16),
              DropdownButtonFormField<String>(
                value: selectedCategory,
                decoration: const InputDecoration(
                  labelText: "Category",
                  border: OutlineInputBorder(),
                ),
                items: categories.map((category) {
                  return DropdownMenuItem(
                    value: category,
                    child: Text(category),
                  );
                }).toList(),
                onChanged: (value) {
                  setState(() {
                    selectedCategory = value;
                  });
                },
                validator: (value) =>
                    value == null || value.isEmpty ? "Please select a category" : null,
              ),
              const SizedBox(height: 16),
              TextFormField(
                controller: descriptionController,
                decoration: const InputDecoration(
                  labelText: "Description",
                  border: OutlineInputBorder(),
                ),
                maxLines: 4,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return "Please enter a description";
                  } else if (value.length < 100) {
                    return "Description must be at least 100 characters";
                  }
                  return null;
                },
              ),
              const SizedBox(height: 16),
              TextFormField(
                controller: minInvestmentController,
                decoration: const InputDecoration(
                  labelText: "Minimum Investment",
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.number,
                validator: (value) =>
                    value == null || value.isEmpty ? "Please enter the minimum investment" : null,
              ),
              const SizedBox(height: 16),
              TextFormField(
                controller: targetInvestmentController,
                decoration: const InputDecoration(
                  labelText: "Target Investment",
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.number,
                validator: (value) =>
                    value == null || value.isEmpty ? "Please enter the target investment" : null,
              ),
              const SizedBox(height: 16),
              TextFormField(
                controller: contactController,
                decoration: const InputDecoration(
                  labelText: "Contact Number",
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.phone,
                validator: (value) =>
                    value == null || value.isEmpty ? "Please enter a contact number" : null,
              ),
              const SizedBox(height: 16),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: _submitListing,
                  child: const Text("Submit Listing"),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
