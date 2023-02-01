package com.example.grefri;

import static java.sql.Timestamp.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import org.w3c.dom.Document;

import java.sql.Timestamp;

public class NoteDetailsActivity extends AppCompatActivity {

    EditText editNote;
    ImageButton doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        editNote = findViewById(R.id.edit_note);
        doneBtn = findViewById(R.id.done_btn);

        doneBtn.setOnClickListener(v -> saveNote());
    }

    void saveNote() {
        String noteContent = editNote.getText().toString();
        if (noteContent == null) {
            editNote.setError("Добавьте запись!");
        }

        Note note = new Note();
        note.setContent(noteContent);
        //note.setTimestamp(Timestamp);
        saveNoteToFirebase(note);

    }

    void saveNoteToFirebase(Note note) {
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForNotes().document();

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // note is added
                    Utility.showToast(NoteDetailsActivity.this, "Запись добавлена!");
                    finish();
                } else {
                    Utility.showToast(NoteDetailsActivity.this, "Запись не добавлена!");

                }
            }
        });
    }
}