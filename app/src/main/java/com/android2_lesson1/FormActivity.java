package com.android2_lesson1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android2_lesson1.ui.home.HomeFragment;

public class FormActivity extends AppCompatActivity {

    static final String MY_KEY = "my_key";
    private EditText editTitle;
    private EditText editDesc;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
        save = findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString().trim();
                String desc = editDesc.getText().toString().trim();
                Task task = new Task(title, desc);

                if(title.isEmpty() || desc.isEmpty()) {
                    Toast toast = Toast.makeText(FormActivity.this, "Пожалуйста, заполните поле Title и поле Description!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(MY_KEY, task);
                    setResult(RESULT_OK, intent);
                    finish();
                    Log.d("ololo", "send task");
                }
            }
        });
    }
}