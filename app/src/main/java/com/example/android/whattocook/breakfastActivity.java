package com.example.android.whattocook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.content.Intent;


public class breakfastActivity extends AppCompatActivity {
    public static String TYPE_BREAKFAST = "breakfast";
    public static String TYPE_DINNER = "dinner";
    public static String TYPE_SOUP = "soup";

    // Элементы, которые мы хотим отобразить в списке
    private String[] breakfast = {"Овсянная каша", "Рисовая каша", "Омлет", "Американские оладушки", "Кексы красный бархат", "Яйца", "Курица",
            "Лимонные кексы с маком", "овсянная каша с овощами", "Манная каша", "Рисовая каша", "Гречневая каша"};

    private String[] dinner = {"Мясо по-азиатски с кунжутом", "Свинина в сладко-кислом соусе", "Омлет", "Вареники", "Рис с курицой и яйцом",
            "Красная рыба в духовке", "Тефтели в томатном соусе", "Котлеты"};

    private String[] soup = {"борщ", "солянка", "сырный"};

    private String[] foodToDisplay;

    private static String foodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        // Создание адаптера и скармливание его в ListView
        Adapter adapter = new Adapter();
        if(foodType.equals(TYPE_BREAKFAST))
        {
            foodToDisplay = breakfast;
        }
        else if(foodType.equals(TYPE_SOUP))
        {
            foodToDisplay = soup;
        }
        ListView listView = (ListView) findViewById(R.id.lvMessageList);
        listView.setAdapter(adapter);

    }
    public void goToRicipe (View v){

        startActivity(new Intent(getApplicationContext(), RecipeActivity.class));
    }

    public static void setFoodType(String food) {
        foodType = food;
    }

    public class Adapter extends BaseAdapter {

        @Override
        // Возвращает общее кол-во "плашек", которое будет в списке
        public int getCount() {
            return foodToDisplay.length;
        }

        @Override
        // Этот метод подсовывает списку элемент для отображения
        public View getView(int position, View view, ViewGroup viewGroup) {
            ElementView newView;
            if (view == null) {
                newView = new ElementView(getApplication());
            } else {
                newView = (ElementView) view;
            }

            // Отображаем текст соответственно позиции элемента в списке
            newView.setContent(foodToDisplay[position]);
            return newView;
        }

        @Override
        // Это нам пока не интересно
        public Object getItem(int i) {
            return null;
        }

        @Override
        // Это нам пока не интересно
        public long getItemId(int i) {
            return 0;
        }
    }


}
