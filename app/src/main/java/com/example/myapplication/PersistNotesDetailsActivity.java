package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class PersistNotesDetailsActivity extends AppCompatActivity {
    EditText tittleText,authorText,descriptionText;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persist_notes_details);
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        tittleText=findViewById(R.id.notes_tittle);
        authorText=findViewById(R.id.author_text);
        descriptionText=findViewById(R.id.notes_description);
        addBtn=findViewById(R.id.add_text_btn);
        addBtn.setOnClickListener(v -> {
            String tittle=tittleText.getText().toString();
            String author=authorText.getText().toString();
            String description=descriptionText.getText().toString();
            if(tittle.isEmpty()||author.isEmpty()||description.isEmpty()){
                Toast.makeText(this,"Fill the content", Toast.LENGTH_SHORT).show();
            }
            HashMap<String,Object> n=new HashMap<>();
            n.put("tittle",tittle);
            n.put("author",author);
            n.put("description",description);
            db.collection("note")
                    .add(n)
                    .addOnSuccessListener(documentReference -> {
                        Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(PersistNotesDetailsActivity.this,NotesDetailsActivity.class);
                        startActivity(intent);
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this,"Failed to store",Toast.LENGTH_SHORT).show();
                    });
        });

    }
}