package com.example.grefri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class AccountFragment extends Fragment {

    FirebaseAuth firebaseAuth;
    FloatingActionButton addNoteBtn;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        firebaseAuth = FirebaseAuth.getInstance();
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        addNoteBtn = (FloatingActionButton) view.findViewById(R.id.add_note_btn);

        // Переход в на страницу с добавлением записи в блог
        addNoteBtn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent intent = new Intent(getContext(), NoteDetailsActivity.class);
                                              startActivity(intent);
                                          }
                                      });

                button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(v -> logout());
        return view;
    }
    void logout() {
        firebaseAuth.signOut();
    }

}