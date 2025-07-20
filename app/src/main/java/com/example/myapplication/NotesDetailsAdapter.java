package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesDetailsAdapter extends RecyclerView.Adapter<NotesDetailsAdapter.NotesDetailsViewHolder>{
    private List<NoteDetails> listOfNoteDetails;

    public NotesDetailsAdapter(List<NoteDetails> listOfNoteDetails) {
        this.listOfNoteDetails = listOfNoteDetails;
    }

    @Override
    public NotesDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_notes_details_for_recyclerview, parent, false);
        return new NotesDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesDetailsViewHolder holder, int position) {
        NoteDetails noteDetails = listOfNoteDetails.get(position);
        holder.tittle.setText("Tittle: " + noteDetails.getTittle());
        holder.author.setText("Author: " + noteDetails.getAuthor());
        holder.description.setText("Description: " + noteDetails.getDescription());

    }

    @Override
    public int getItemCount() {
        return listOfNoteDetails.size();
    }

    public static class NotesDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView tittle, author, description;

        public NotesDetailsViewHolder(View itemView) {
            super(itemView);
            tittle = itemView.findViewById(R.id.textTitle);
            author = itemView.findViewById(R.id.textAuthor);
            description = itemView.findViewById(R.id.textDescription);
        }
    }

}
