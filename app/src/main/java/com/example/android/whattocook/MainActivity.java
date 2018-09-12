package com.example.android.whattocook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToBreakfast (View v){
        breakfastActivity.setFoodType(breakfastActivity.TYPE_BREAKFAST);
        startActivity(new Intent(getApplicationContext(), breakfastActivity.class));
    }

    public void goToDinner (View v){
        breakfastActivity.setFoodType(breakfastActivity.TYPE_DINNER);
        startActivity(new Intent(getApplicationContext(), breakfastActivity.class));
    }

    public void goToSoup (View v){
        breakfastActivity.setFoodType(breakfastActivity.TYPE_SOUP);
        startActivity(new Intent(getApplicationContext(), breakfastActivity.class));
    }
}
