package com.isuru.carapp_4662580_4662584;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Check_car extends AppCompatActivity {

    Button checkButton;
    EditText Brand,Model;
    TextView Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_car);

        checkButton = findViewById(R.id.Check_price);
        Brand = findViewById(R.id.CarBrand_2);
        Model = findViewById(R.id.CarModel_2);
        Price = findViewById(R.id.CarPrice_2);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String carBrand = Brand.getText().toString();
                String carModel = Model.getText().toString();

                if (carBrand.isEmpty()){
                    Brand.setError("Enter The Brand Name");
                }
                else if (carModel.isEmpty()){
                    Model.setError("Enter The Model Name");
                }
                else {
                    SQLiteDatabase Database = getApplicationContext().openOrCreateDatabase("Garage.db", Context.MODE_PRIVATE,null);

                    Cursor c = Database.rawQuery("select * from car where brand = '"+carBrand+"' and model = '"+carModel+"'",null);
                    if (c.getCount() ==0) {
                        Toast.makeText(getApplicationContext(),"No Data Has Found",Toast.LENGTH_LONG).show();
                        return;
                    }
                    StringBuffer GetData = new StringBuffer();
                    while (c.moveToNext()){
                        GetData.append("$"+ c.getString(2));
                    }
                    Price.setText(GetData.toString());
                }
            }
        });
    }
}