package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThirdStage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_stage);
    }

    public void onClick(View view)
    {
        // get data from edit text fields
        EditText editTextName = findViewById(R.id.etThirdName);
        EditText editTextAge = findViewById(R.id.etThirdAge);

        int age = Integer.parseInt(editTextAge.getText().toString());
        String name = editTextName.getText().toString();

        // save in SharedPref
        SharedPreferences sharedPreferences = this.getSharedPreferences("details",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putInt("age",age);
        editor.commit();
        // create intent and compare in next activity
        // notice if data is not the same -> we return here...
        Intent intent4 = new Intent(this,FourthStage.class);
        intent4.putExtra("name",name);
        intent4.putExtra("age",age);
        startActivity(intent4);
    }
}