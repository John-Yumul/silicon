import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'addlisting.dart';

class UserListings extends StatelessWidget {
  const UserListings({super.key});

  // Method to delete a listing
  Future<void> _deleteListing(BuildContext context, String listingId) async {
    try {
      // Show confirmation dialog before deleting
      bool? confirmDelete = await showDialog<bool>(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: const Text('Delete Listing'),
            content: const Text('Are you sure you want to delete this listing?'),
            actions: <Widget>[
              TextButton(
                child: const Text('Cancel'),
                onPressed: () {
                  Navigator.of(context).pop(false);  // Don't delete
                },
              ),
              TextButton(
                child: const Text('Delete'),
                onPressed: () {
                  Navigator.of(context).pop(true);  // Proceed to delete
                },
              ),
            ],
          );
        },
      );

      // If the user confirmed deletion
      if (confirmDelete == true) {
        await FirebaseFirestore.instance.collection('listings').doc(listingId).delete();
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Listing deleted successfully')));
      }
    } catch (e) {
      debugPrint("Error deleting listing: $e");
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Error deleting listing')));
    }
  }

  // Method to get the current user's UID
  String? _getCurrentUserId() {
    final user = FirebaseAuth.instance.currentUser;
    return user?.uid;
  }

  @override
  Widget build(BuildContext context) {
    final userId = _getCurrentUserId();

    if (userId == null) {
      return Scaffold(
        appBar: AppBar(
          title: const Text('My Listings'),
          centerTitle: true,
        ),
        body: const Center(
          child: Text(
            "You need to log in to view your listings.",
            style: TextStyle(fontSize: 16, color: Colors.grey),
          ),
        ),
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text('My Listings'),
        centerTitle: true,
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: FirebaseFirestore.instance
            .collection('listings')
            .where('createdBy.uid', isEqualTo: userId)
            .snapshots(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return const Center(
              child: Text(
                "You have no listings yet.",
                style: TextStyle(fontSize: 16, color: Colors.grey),
              ),
            );
          }

          final listings = snapshot.data!.docs;

          return ListView.builder(
            itemCount: listings.length,
            itemBuilder: (context, index) {
              final listing = listings[index];
              final data = listing.data() as Map<String, dynamic>;
              return Card(
                margin: const EdgeInsets.all(8.0),
                child: ListTile(
                  leading: SizedBox(
                    width: 50,
                    height: 50,
                    child: data['photoUrl'] != null
                        ? Image.network(
                            data['photoUrl'],
                            fit: BoxFit.cover,
                          )
                        : const Icon(Icons.image, size: 50),
                  ),
                  title: Text(
                    data['title'] ?? 'No Title',
                    style: const TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
                  ),
                  subtitle: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text("Category: ${data['category'] ?? 'Unknown'}"),
                    ],
                  ),
                  trailing: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      IconButton(
                        icon: const Icon(Icons.edit, color: Colors.blue),
                        onPressed: () {
                          // Navigate to edit listing page (you need to implement this)
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => AddListingPage(),
                            ),
                          );
                        },
                      ),
                      IconButton(
                        icon: const Icon(Icons.delete, color: Colors.red),
                        onPressed: () {
                          _deleteListing(context, listing.id);
                        },
                      ),
                    ],
                  ),
                ),
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => const AddListingPage(),
            ),
          );
        },
        child: const Icon(Icons.add),
        tooltip: 'Add Listing',
      ),
    );
  }
}
