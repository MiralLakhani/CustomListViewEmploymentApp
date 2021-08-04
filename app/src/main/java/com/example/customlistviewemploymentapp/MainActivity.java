package com.example.customlistviewemploymentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     EditText name,pwd;
     Button logIn;
     public static ArrayList<Client> cList=new ArrayList<>();
     public static int index;
     public  static Client logInClient =new Client("","","","");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        name=findViewById(R.id.extName);
        pwd=findViewById(R.id.extPwd);
        logIn=findViewById(R.id.btnbLogIn);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String password=pwd.getText().toString();
                Boolean flag = true;
                if (userName.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Please enter the name", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else if (password.isEmpty()) {
                    Toast.makeText(getBaseContext(), "Please enter the password", Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if (flag) {
                    if(checkUser(userName,password)){
                        Toast.makeText(getBaseContext(), "Log in Successfully..!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Product_List.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getBaseContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
    public  boolean checkUser(String userName ,String password){
        for(Client ct:cList)
            if(ct.getUserName().equals(userName) && ct.getPassword().equals(password)) {
                logInClient=ct;
                return true;
            }
        return false;
    }
    public void fillData(){
        cList.add(new Client("Miral","Gujarat","miral","123"));
        cList.add(new Client("Gopal","Kerla","gopal","345"));
        cList.add(new Client("Mira","Sikkim","mira","456"));
        cList.add(new Client("Mital","Panjab","mital","678"));
    }
}