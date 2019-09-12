package com.example.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText=(EditText) findViewById(R.id.editText);
        Intent intent=getIntent();
        noteId=intent.getIntExtra("noteId",-1);

        if (noteId!=-1)
        {
            editText.setText(Main2Activity.notes.get(noteId));
        }
        else{

            Main2Activity.notes.add("");
            noteId=Main2Activity.notes.size()-1;
            Main2Activity.arrayAdapter.notifyDataSetChanged();

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)
            {
                Main2Activity.notes.set(noteId, String.valueOf(charSequence));
                Main2Activity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                HashSet<String> set=new HashSet<>(Main2Activity.notes);
                sharedPreferences.edit().putString("notes", String.valueOf(set)).apply();

            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });


    }
}
