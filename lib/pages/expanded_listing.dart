import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:url_launcher/url_launcher.dart';

class FullViewPage extends StatelessWidget {
  final Map<String, dynamic> listing;

  const FullViewPage({Key? key, required this.listing}) : super(key: key);

  String _formatDate(dynamic dateInput) {
    if (dateInput == null) return "Unknown date";

    try {
      DateTime dateTime;

      if (dateInput is Timestamp) {
        dateTime = dateInput.toDate();
      } else if (dateInput is String) {
        dateTime = DateTime.parse(dateInput);
      } else {
        return "Invalid date type";
      }

      return DateFormat("MMMM d, yyyy 'at' h:mm a").format(dateTime);
    } catch (e) {
      return "Invalid date format";
    }
  }

  // Fetch the owner's name from Firestore
  Future<String> _getOwnerName(String email) async {
    try {
      // Query Firestore for the user with the matching email
      QuerySnapshot snapshot = await FirebaseFirestore.instance
          .collection('users')
          .where('email', isEqualTo: email)
          .get();

      if (snapshot.docs.isNotEmpty) {
        // Assuming the first document matches the email
        return snapshot.docs.first['name'] ?? 'Unknown User';
      } else {
        return 'Unknown User';
      }
    } catch (e) {
      print('Error fetching owner name: $e');
      return 'Unknown User';
    }
  }

  @override
  Widget build(BuildContext context) {
    final String formattedDate = _formatDate(listing["createdAt"]);
    final String email = listing["createdBy"]?["email"] ?? ''; // Access the email inside the createdBy map

    return Scaffold(
      appBar: AppBar(
        title: Text(listing["title"] ?? "Details"),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Display Image
            if (listing["photoUrl"] != null)
              ClipRRect(
                borderRadius: BorderRadius.circular(12),
                child: Image.network(
                  listing["photoUrl"],
                  height: 200,
                  width: double.infinity,
                  fit: BoxFit.cover,
                ),
              ),
            const SizedBox(height: 16),
            // Title
            Text(
              listing["title"] ?? "",
              style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            // Date Listed
            Text(
              "Listed on $formattedDate",
              style: const TextStyle(fontSize: 14, fontStyle: FontStyle.italic, color: Colors.grey),
            ),
            const SizedBox(height: 16),
            // Description
            Text(
              listing["description"] ?? "",
              style: const TextStyle(fontSize: 16),
            ),
            const SizedBox(height: 16),
            // Target and Minimum Investment
            Container(
              decoration: BoxDecoration(
                color: Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
              ),
              padding: const EdgeInsets.all(16),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const Text(
                        "Target Investment",
                        style: TextStyle(fontSize: 14, color: Colors.grey),
                      ),
                      Text(
                        "₱${listing["targetInvestment"] ?? "0"}",
                        style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                      ),
                    ],
                  ),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const Text(
                        "Minimum Investment",
                        style: TextStyle(fontSize: 14, color: Colors.grey),
                      ),
                      Text(
                        "₱${listing["minInvestment"] ?? "0"}",
                        style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                      ),
                    ],
                  ),
                ],
              ),
            ),
            const SizedBox(height: 16),
            // Contact Number
            if (listing["contact"] != null)
              GestureDetector(
                onTap: () {
                  final Uri phoneUri = Uri(
                    scheme: 'tel',
                    path: listing["contact"],
                  );
                  launchUrl(phoneUri);
                },
                child: Container(
                  decoration: BoxDecoration(
                    color: Colors.blue[50],
                    borderRadius: BorderRadius.circular(8),
                  ),
                  padding: const EdgeInsets.all(12),
                  child: Row(
                    children: [
                      const Icon(Icons.phone, color: Colors.blue),
                      const SizedBox(width: 8),
                      Text(
                        listing["contact"],
                        style: const TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                          color: Colors.blue,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            const SizedBox(height: 16),
            // Divider
            const Divider(height: 24, thickness: 1),
            // Profile Section
            FutureBuilder<String>(
              future: _getOwnerName(email), // Call the function to get the owner's name
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return const Center(child: CircularProgressIndicator());
                } else if (snapshot.hasError) {
                  return Text('Error: ${snapshot.error}');
                } else if (!snapshot.hasData || snapshot.data == 'Unknown User') {
                  return const Text('Owner information not available');
                }

                String ownerName = snapshot.data ?? 'Unknown User';

                return Row(
                  children: [
                    const SizedBox(width: 16),
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          "Listed by",
                          style: const TextStyle(fontSize: 14, color: Colors.grey),
                        ),
                        Text(
                          ownerName,
                          style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                        ),
                        const SizedBox(height: 4),
                      ],
                    ),
                  ],
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}
