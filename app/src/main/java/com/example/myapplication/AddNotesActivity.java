package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNotesActivity extends AppCompatActivity {
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        addBtn=findViewById(R.id.add_btn);
        addBtn.setOnClickListener(v -> {
            Intent intent=new Intent(AddNotesActivity.this,NoteDetailActivity.class);
            startActivity(intent);
        });

    }
}