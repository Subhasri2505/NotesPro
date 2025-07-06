package com.example.myapplication;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility {

    // Show toast
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    // Convert timestamp to readable date
    public static String timestampToString(Timestamp timestamp) {
        return new SimpleDateFormat("MM/dd/yyyy").format(timestamp.toDate());
    }

    // Get collection path: notes/{userId}/my_notes/
    public static CollectionReference getCollectionReferenceForNotes() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance()
                .collection("notes")
                .document(currentUser.getUid())
                .collection("my_notes");
    }

    // Save note to Firestore
    public static void saveNoteToFirestore(Note note, OnCompleteListener<Void> listener) {
       // CollectionReference notesRef = getCollectionReferenceForNotes();
        DocumentReference newNoteRef = getCollectionReferenceForNotes().document(); // auto-generated ID
        newNoteRef.set(note).addOnCompleteListener(listener);
    }
}
