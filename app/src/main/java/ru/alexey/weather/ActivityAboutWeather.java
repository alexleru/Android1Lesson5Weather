package ru.alexey.weather;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.alexey.weather.fragments.FragmentAboutWeather;

public class ActivityAboutWeather extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_weather);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо эту activity закрыть
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // Если эта activity запускается первый раз (с каждым новым гербом первый раз)
            // то перенаправим параметр фрагменту
            FragmentAboutWeather details = new FragmentAboutWeather();
            details.setArguments(getIntent().getExtras());
            // Добавим фрагмент на activity
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_city_layout, details).commit();
        }
    }


}
