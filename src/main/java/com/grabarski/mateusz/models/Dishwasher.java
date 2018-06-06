package com.grabarski.mateusz.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dishwasher {

    private Collection<Dish> dishes;

    public Dishwasher(Collection<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void wash() {
        dishes.forEach(dish -> dish.wash());
    }

    public int superWash() {
        int i = 0;
        for (; i < 3; i++) {
            wash();
        }
        return i;
    }
}
