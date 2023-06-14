package com.isuru.carapp_4662580_4662584;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_car extends AppCompatActivity {

    Button addButton;
    EditText Brand;
    EditText Model;
    EditText Price;
    DBhelper DBhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        addButton = findViewById(R.id.Add_car_2);
        Brand = findViewById(R.id.CarBrand_Text);
        Model = findViewById(R.id.CarModel_Text);
        Price = findViewById(R.id.CarPrice_text);
        DBhelper = new DBhelper(this);

        this.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brand = Brand.getText().toString();
                String model = Model.getText().toString();
                String price = Price.getText().toString();


                if (brand.isEmpty()){
                    Toast.makeText(Add_car.this,"Enter the Brand Name",Toast.LENGTH_LONG).show();
                } else if (model.isEmpty()){
                    Toast.makeText(Add_car.this,"Enter the Model Name",Toast.LENGTH_LONG).show();
                } else if (price.isEmpty()){
                    Toast.makeText(Add_car.this,"Enter the Price",Toast.LENGTH_LONG).show();
                } else {
                    Boolean insertdata = DBhelper.insertdata(brand,model,price);

                    if (insertdata == true) {
                        Toast.makeText(Add_car.this,"Car Has Been Added To The DataBase",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(Add_car.this,"No Car Has Been Added To The DataBase",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}