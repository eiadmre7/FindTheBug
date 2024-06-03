package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondStageActivity extends AppCompatActivity implements View.OnClickListener {

    private String data;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        data=intent.getStringExtra("success");
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show();
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,ThirdStage.class);
        startActivity(intent);
    }
}