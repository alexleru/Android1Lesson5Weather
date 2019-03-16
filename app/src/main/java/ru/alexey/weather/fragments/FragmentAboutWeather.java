package ru.alexey.weather.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.alexey.weather.data.DataWeather;
import ru.alexey.weather.R;

public class FragmentAboutWeather extends Fragment {

    TextView textCityName;
    TextView textCell;
    int index = 0;

    public static FragmentAboutWeather create(Bundle bundle){
        FragmentAboutWeather fragmentAboutWeather = new FragmentAboutWeather();
        fragmentAboutWeather.setArguments(bundle);
        return fragmentAboutWeather;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_weather, container, false);
        String cityName;
        try {
            cityName = getArguments().getString(FragmentSearchAndPreferences.CITY, "empty search");
        } catch (Exception e) {
            e.printStackTrace();
            cityName = "empty search";
        }
        textCityName = view.findViewById(R.id.text_view_city_name);
        textCityName.setText(cityName);
        textCell = view.findViewById(R.id.linear_layout_cell);
        textCell.setText(DataWeather.getTemperature()[0]);
        getAddData();
        return view;
    }


    private void getAddData(){
        boolean [] showAddData;
        try {
            showAddData = getArguments().getBooleanArray(FragmentSearchAndPreferences.ADDDATA);
        } catch (Exception e) {
            e.printStackTrace();
            showAddData = null;
        }
        if (showAddData != null) {
            for (int i = 0 ; i < showAddData.length; i++){
                if (showAddData[i] && i == 0) {
                    textCell.append("\n " + DataWeather.getWind()[index] + ",  " + DataWeather.getWindDirection()[index]);
                }
                if (showAddData[i] && i == 1) {
                    textCell.append("\n " + DataWeather.getHumidity()[index]);
                }
                if (showAddData[i] && i == 2) {
                    textCell.append("\n " + DataWeather.getPressure()[index]);
                }
            }
        }
    }
}
