/* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 */
/* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 *//* package com.example.app;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import io.flutter.plugin.common.MethodChannel;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private final FirebaseFirestore firestore;

    public FirebaseHandler() {
        this.firestore = FirebaseFirestore.getInstance();
    }

    public void getListings(String category, String searchQuery, @NonNull MethodChannel.Result result) {
        CollectionReference collection = firestore.collection("listings");
        Query query = collection;

        if (!category.equals("Most Recent")) {
            query = query.whereEqualTo("category", category);
        }

        if (!searchQuery.isEmpty()) {
            String lowercaseQuery = searchQuery.toLowerCase();
            query = query
                .whereGreaterThanOrEqualTo("searchTitle", lowercaseQuery)
                .whereLessThanOrEqualTo("searchTitle", lowercaseQuery + "~");
        } else if (category.equals("Most Recent")) {
            query = query.orderBy("createdAt", Query.Direction.DESCENDING);
        }

        query.get()
            .addOnSuccessListener(queryDocumentSnapshots -> {
                if (queryDocumentSnapshots.isEmpty()) {
                    result.success(new HashMap<>()); // Return an empty map if no data found
                } else {
                    Map<String, Object> listingsMap = new HashMap<>();
                    for (int i = 0; i < queryDocumentSnapshots.size(); i++) {
                        listingsMap.put(String.valueOf(i), queryDocumentSnapshots.getDocuments().get(i).getData());
                    }
                    result.success(listingsMap); // Return listings data
                }
            })
            .addOnFailureListener(e -> {
                Log.e("FirebaseHandler", "Error fetching listings", e);
                result.error("FIREBASE_ERROR", "Failed to fetch listings", e.getMessage());
            });
    }
}
 */