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


}
