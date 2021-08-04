package com.example.customlistviewemploymentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    TextView name,desc;
    ImageView img;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_row2);
        name=findViewById(R.id.txvProdNameDetail);
        desc=findViewById(R.id.txvDesc);
        img=findViewById(R.id.imgBig);
        back=findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductDetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        name.setText(Product_List.products.get(Product_List.index).getProdName());
        desc.setText(Product_List.products.get(MainActivity.index).getDecs());
        img.setImageResource(Product_List.products.get(MainActivity.index).getImage());
    }
}