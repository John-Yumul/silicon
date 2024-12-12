import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'expanded_listing.dart';


class ListingsPage extends StatefulWidget {
  const ListingsPage({Key? key}) : super(key: key);

  @override
  State<ListingsPage> createState() => _ListingsPageState();
}

class _ListingsPageState extends State<ListingsPage> {
  final List<String> categories = [
    "Most Recent",
    "Real Estate",
    "Startups",
    "Technology",
    "Health",
    "Education",
    "Other"
  ];
  String selectedCategory = "Most Recent";
  String searchQuery = ""; // Search query state

  @override
  Widget build(BuildContext context) {
    // Fetch filtered listings from Firebase
    Stream<QuerySnapshot> getListingsStream() {
      final collection = FirebaseFirestore.instance.collection('listings');
      Query query = collection;

      if (selectedCategory != "Most Recent") {
        query = query.where('category', isEqualTo: selectedCategory);
      }

      if (searchQuery.isNotEmpty) {
        final lowercaseQuery = searchQuery.toLowerCase();
        query = query.where('searchTitle', isGreaterThanOrEqualTo: lowercaseQuery).where(
              'searchTitle',
              isLessThanOrEqualTo: "${lowercaseQuery}~", // `~` ensures partial match
            );
      } else if (selectedCategory == "Most Recent") {
        query = query.orderBy('createdAt', descending: true);
      }

      return query.snapshots();
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text("Explore"),
        centerTitle: true,
        automaticallyImplyLeading: false,
      ),
      body: Column(
        children: [
          // Search Bar
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              onChanged: (value) {
                setState(() {
                  searchQuery = value;
                });
              },
              decoration: InputDecoration(
                hintText: "Search listings...",
                prefixIcon: const Icon(Icons.search),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(8.0),
                ),
              ),
            ),
          ),
          // Horizontal filter bar
          Container(
            padding: const EdgeInsets.symmetric(vertical: 8.0, horizontal: 12.0),
            child: SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              child: Row(
                children: categories.map((category) {
                  final isSelected = category == selectedCategory;
                  return Padding(
                    padding: const EdgeInsets.only(right: 8.0),
                    child: ElevatedButton(
                      onPressed: () {
                        setState(() {
                          selectedCategory = category;
                        });
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: isSelected ? Colors.blue : Colors.grey[300],
                        foregroundColor: isSelected ? Colors.white : Colors.black,
                      ),
                      child: Text(category),
                    ),
                  );
                }).toList(),
              ),
            ),
          ),
          // Listings or No Data Message
          Expanded(
            child: StreamBuilder<QuerySnapshot>(
              stream: getListingsStream(),
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return const Center(child: CircularProgressIndicator());
                }
                if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
                  return const Center(child: Text("No listings found."));
                }

                final listings = snapshot.data!.docs;

                return ListView.builder(
                  itemCount: listings.length,
                  itemBuilder: (context, index) {
                    final listing = listings[index].data() as Map<String, dynamic>;
                    return GestureDetector(
                      onTap: () {
                        // Navigate to the full view page
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => FullViewPage(listing: listing),
                          ),
                        );
                      },
                      child: Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Card(
                          elevation: 3,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              // Image Section
                              ClipRRect(
                                borderRadius: const BorderRadius.vertical(
                                  top: Radius.circular(10),
                                ),
                                child: listing["photoUrl"] != null && listing["photoUrl"].isNotEmpty
                                    ? Image.network(
                                        listing["photoUrl"],
                                        height: 150,
                                        width: double.infinity,
                                        fit: BoxFit.cover,
                                      )
                                    : Container(
                                        height: 150,
                                        width: double.infinity,
                                        color: Colors.grey[300],
                                        child: const Center(
                                          child: Text(
                                            "No Image Available",
                                            style: TextStyle(color: Colors.black54),
                                          ),
                                        ),
                                      ),
                              ),
                              // Content Section
                              Padding(
                                padding: const EdgeInsets.all(12.0),
                                child: Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text(
                                      listing["title"] ?? "",
                                      style: const TextStyle(
                                        fontSize: 18,
                                        fontWeight: FontWeight.bold,
                                      ),
                                    ),
                                    const SizedBox(height: 8),
                                    Text(
                                      listing["description"] != null &&
                                              listing["description"].length > 80
                                          ? "${listing["description"].substring(0, 80)}..."
                                          : listing["description"] ?? "",
                                      style: const TextStyle(fontSize: 14),
                                    ),
                                    const SizedBox(height: 8),
                                    Row(
                                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                      children: [
                                        Text(
                                          "Target: ₱${listing["targetInvestment"] ?? "0"}",
                                          style: const TextStyle(
                                            fontSize: 14,
                                            fontWeight: FontWeight.w500,
                                          ),
                                        ),
                                        Text(
                                          "Min Investment: ₱${listing["minInvestment"] ?? "0"}",
                                          style: const TextStyle(
                                            fontSize: 14,
                                            fontWeight: FontWeight.w500,
                                          ),
                                        ),
                                      ],
                                    ),
                                  ],
                                ),
                              ),
                            ],
                          ),
                        ),
                      ),
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
