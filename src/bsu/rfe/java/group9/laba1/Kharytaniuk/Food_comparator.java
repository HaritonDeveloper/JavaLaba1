package bsu.rfe.java.group9.laba1.Kharytaniuk;

import java.util.Comparator;

public class Food_comparator implements Comparator<Food> {
    @Override
    public int compare(Food food1, Food food2) {
        return food2.get_name().compareTo(food1.get_name());
    }
}
