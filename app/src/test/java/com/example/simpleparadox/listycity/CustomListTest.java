package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        Assertions.assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest() {
        City edmonton = new City("Edmonton", "AB");
        Assertions.assertFalse(list.hasCity(edmonton));
        list.addCity(edmonton);
        Assertions.assertTrue(list.hasCity(edmonton));
    }

    @Test
    public void deleteCityTest(){
        City edmonton = new City("Edmonton", "AB");
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            list.deleteCity(edmonton);
        });
        list.addCity(edmonton);
        Assertions.assertTrue(list.hasCity(edmonton));
        list.deleteCity(edmonton);
        Assertions.assertFalse(list.hasCity(edmonton));
    }

    @Test
    public void countCityTest() {
        City edmonton = new City("Edmonton", "AB");
        City calgary = new City("Calgary", "AB");
        Assertions.assertEquals(list.getCount(), 0);
        list.addCity(edmonton);
        Assertions.assertEquals(list.getCount(), 1);
        list.addCity(calgary);
        Assertions.assertEquals(list.getCount(), 2);
    }


}
