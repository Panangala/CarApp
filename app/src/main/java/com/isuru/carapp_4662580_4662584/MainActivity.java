package com.isuru.carapp_4662580_4662584;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button AddCar_1,CheckCar_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddCar_1=findViewById(R.id.AddCar_1);
        CheckCar_1=findViewById(R.id.CheckCar_1);
        AddCar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Add_car.class);
                startActivity(intent);
            }
        });

        CheckCar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Check_car.class);
                startActivity(intent);
            }
        });
    }
}