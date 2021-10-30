package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * The method will add a city to the list.
     * @param city
     *  candidate city
     */
    public void addCity(City city) {
        cities.add(city);
    }

    /**
     * The method tests if a city exists in the list.
     * @param city
     *  The city to be tested
     * @return
     *  True if exists, False if not
     */
    public Boolean hasCity(City city) {
        if (cities.contains(city)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * The method returns the size of the list.
     * @return
     *  the size of the city list
     */
    public int getCount() {
        return 0;// cities.size();
    }

    /**
     * The method delete a city if exists.
     * @param city
     *  The city to be delete form the list. Or throw an exception.
     */
    public void deleteCity(City city) {
        if (!hasCity(city)) {
            throw new IllegalArgumentException( city.getCityName()+"is not in the list!");
        } else {
            cities.remove(city);
        }
    }



}
