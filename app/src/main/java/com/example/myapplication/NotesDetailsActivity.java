package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NotesDetailsActivity extends AppCompatActivity {
    Button addBtn,viewAllNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_details);
        addBtn=findViewById(R.id.saveNotesButton);
        viewAllNotes=findViewById(R.id.notesDetails);
        addBtn.setOnClickListener(v -> {
             Intent intent=new Intent(NotesDetailsActivity.this,PersistNotesDetailsActivity.class);
            startActivity(intent);
        });
        viewAllNotes.setOnClickListener(v -> {
            Intent intent=new Intent(NotesDetailsActivity.this,ViewAllNotesDetailsActivity.class);
            startActivity(intent);
        });
    }
}