package com.csg.recyclerviewexam2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Weather> weatherList = new ArrayList<>();
        for (int i = 0; weatherList.size() < 40; i++) {
            if (i % 2 == 0) {
                weatherList.add(new Weather(R.drawable.weather_01, "서울", "201"));
            } else {
                weatherList.add(new Weather(R.drawable.weather_02, "부산", "201"));

            }
        }

        WeatherRecyclerAdapter adapter = new WeatherRecyclerAdapter();
        adapter.addItems(weatherList);

        RecyclerView recyclerView = findViewById(R.id.weatherList);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private static class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.weatherViewHolder> {

        private List<Weather> mItems = new ArrayList<>();


        @NonNull
        @Override
        public weatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather, viewGroup, false);
            return new weatherViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull weatherViewHolder weatherViewHolder, int i) {
            Weather weather = mItems.get(i);
            weatherViewHolder.weatherImageView.setImageResource(weather.getImageResource());
            weatherViewHolder.tempTextView.setText(weather.getTeam());
            weatherViewHolder.cityNameTextView.setText(weather.getCityName());
            if (weather.getCityName().equals("부산")) {
                weatherViewHolder.weatherLinearLayout.setBackgroundColor(Color.parseColor("#F44FFF"));

            }

        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public void addItems(List<Weather> items) {
            mItems.addAll(items);
        }

        public static class weatherViewHolder extends RecyclerView.ViewHolder {
            public ImageView weatherImageView;
            public TextView cityNameTextView;
            public TextView tempTextView;
            public LinearLayout weatherLinearLayout;


            public weatherViewHolder(@NonNull View itemView) {
                super(itemView);

                weatherImageView = itemView.findViewById(R.id.weatherImageView);
                cityNameTextView = itemView.findViewById(R.id.cityNameTextView);
                tempTextView = itemView.findViewById(R.id.tempTextView);
                weatherLinearLayout = itemView.findViewById(R.id.ll_item_weather);
            }
        }
    }

}
