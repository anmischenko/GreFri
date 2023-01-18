package com.example.grefri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddNoteActivity extends AppCompatActivity {

    EditText editNote;
    ImageButton doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editNote = findViewById(R.id.edit_note);
        doneBtn = findViewById(R.id.done_btn);

        doneBtn.setOnClickListener(v -> saveNote());
    }

    void saveNote() {
        String note = editNote.getText().toString();

    }
}