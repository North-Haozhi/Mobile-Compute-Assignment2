package com.example.learnigapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FruitItem> fruitList = new ArrayList<>();
    String language = "en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();// 初始化水果数据

        // 中英文切换
        SharedPreferences sharedPreferences = getSharedPreferences("language",MODE_PRIVATE);
        language = sharedPreferences.getString("language", "en");


        final FloatingActionButton floatingActionButton=this.findViewById(R.id.change_language);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (language.equals("en")){
                    language = "cn";
                } else if (language.equals("cn")){
                    language = "en";
                }
                SharedPreferences.Editor editor=getSharedPreferences("language",MODE_PRIVATE).edit();
                editor.putString("language",language);
                editor.apply();
                final AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
                if(language.equals("cn")){
                    normalDialog.setTitle("警告！");
                    normalDialog.setMessage("语言已经被设置为简体中文");
                }else{
                    normalDialog.setTitle("Warning!");
                    normalDialog.setMessage("The language has been set to English.");
                }
                normalDialog.show();
                onResume();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();

        FruitAdapter arrayAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent=new Intent(MainActivity.this,Banana.class);
                    startActivity(intent);
                } else if(i==1){
                    Intent intent=new Intent(MainActivity.this,Kiwifruit.class);
                    startActivity(intent);
                } else if(i==2){
                    Intent intent=new Intent(MainActivity.this,Apple.class);
                    startActivity(intent);
                } else if(i==3){
                    Intent intent=new Intent(MainActivity.this,Strawberry.class);
                    startActivity(intent);
                } else if(i==4){
                    Intent intent=new Intent(MainActivity.this,Watermelon.class);
                    startActivity(intent);
                }
            }
        });

    }


    private void initFruits(){
        FruitItem banana = new FruitItem(R.drawable.bananalit);
        FruitItem kiwifruit = new FruitItem(R.drawable.kiwifruitlit);
        FruitItem litchi = new FruitItem(R.drawable.applelit);
        FruitItem strawberry = new FruitItem(R.drawable.strawberrylit);
        FruitItem watermelon = new FruitItem(R.drawable.watermelonlit);

        fruitList.add(banana);
        fruitList.add(kiwifruit);
        fruitList.add(litchi);
        fruitList.add(strawberry);
        fruitList.add(watermelon);
    }
}