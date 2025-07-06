package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllNotesDetailsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NotesDetailsAdapter adapter;
    List<NoteDetails> listOfNoteDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_notes_details);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listOfNoteDetails = new ArrayList<>();
        listOfNoteDetails.add(new NoteDetails("Clean Code", "Robert C. Martin", "A Handbook of Agile Software Craftsmanship."));
        listOfNoteDetails.add(new NoteDetails("The Pragmatic Programmer", "Andy Hunt", "Your Journey to Mastery."));
        listOfNoteDetails.add(new NoteDetails("Introduction to Algorithms", "Cormen et al.", "A comprehensive algorithm book."));

        adapter = new NotesDetailsAdapter (listOfNoteDetails);
        recyclerView.setAdapter(adapter);

    }
}