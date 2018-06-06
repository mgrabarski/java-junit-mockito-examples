package com.grabarski.mateusz.models;

import java.util.ArrayList;
import java.util.List;

public class Dishwasher {

    private List<Dish> dishes;

    public Dishwasher() {
        dishes = new ArrayList<>();
    }

    public Dishwasher(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public List<Dish> wash() {
        dishes.forEach(dish -> dish.wash());

        return dishes;
    }
}
