package com.example.customlistviewemploymentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Product_List extends AppCompatActivity {
    TextView name;
    ListView prodList;
    public static ArrayList<Product> products=new ArrayList<>();
    public static int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        fillData();
        prodList=findViewById(R.id.listProd);
        name=findViewById(R.id.txvName);
        name.setText(MainActivity.logInClient.getName());
        prodList.setAdapter(new ProductAdapter(this,products));
        prodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index=position;
                Intent intent=new Intent(Product_List.this,ProductDetailActivity.class);
                startActivity(intent);
            }
        });

    }
    public void fillData()
    {
        products.add(new Product("Television",5000,R.drawable.tv,"Wi-fi Connection"));
        products.add(new Product("Washing Machine",35000,R.drawable.wm,"Front Lode"));
        products.add(new Product("Phone",50000,R.drawable.a51,"With dual cvamera"));


    }
}