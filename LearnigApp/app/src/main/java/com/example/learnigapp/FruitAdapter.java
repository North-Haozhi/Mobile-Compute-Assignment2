package com.example.learnigapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<FruitItem> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<FruitItem> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        FruitItem fruit = getItem(position); //获取当前项的FruitItem实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        fruitImage.setImageResource(fruit.getImageId());
        return view;
    }
}
