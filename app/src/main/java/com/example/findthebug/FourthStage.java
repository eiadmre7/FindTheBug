package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FourthStage extends AppCompatActivity {

    private EditText etName,etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_stage);
        initViews();// שינוי הסדר
        Toast.makeText(this,"רביעי", Toast.LENGTH_SHORT).show();
        compareIntentAndSharedPref();
    }

    //compare between data in shared preferences and intent received
    // if not equal activity finished  and returns to previous
    private void compareIntentAndSharedPref()
    {
        Intent intent =getIntent();
        int age = intent.getIntExtra("age",0);
        String name=intent.getStringExtra("name");
        Toast.makeText(this,name+" "+age, Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = this.getSharedPreferences("details",MODE_PRIVATE);// שינוי שם הקובץ

        int spAge = sharedPreferences.getInt("age",0);
        String spName = sharedPreferences.getString("name","");
        Toast.makeText(this,spName+" "+spAge, Toast.LENGTH_SHORT).show();
        //if the are not equal finish
        if(age!= spAge || !spName.equals(name))// שינוי השוואת מחרוזות
        {
            finish();
        }
        // else set the fields accordingly
        else
        {
            etAge.setText(age+"");// שינוי למחרוזת
            etName.setText(name);// שינוי שם משתמש לשם
        }
    }

    private void initViews()
    {
        etName=findViewById(R.id.etFourthName);
        etAge=findViewById(R.id.etFourthAge);
    }

    public void onClick(View view)
    {
        //TODO - implement here so you can move to fifth
        Intent intent= new Intent(this, FifthActivity.class);
        startActivity(intent);
    }
}