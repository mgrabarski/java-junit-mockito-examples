package com.grabarski.mateusz.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DishwasherTest {

    @Test
    public void shouldCallWashOnAllDishesInDishwasher() {
        // given
        Set<Dish> dishes = prepareDishMocks();
        Dishwasher dishwasher = new Dishwasher(dishes);
        // when
        dishwasher.wash();
        // then
        verifyWashInvocation(dishes);
    }

    private void verifyWashInvocation(Set<Dish> dishes) {
        dishes.forEach(d -> verify(d).wash());
    }

    @Test
    public void shouldCall3TimesWashWhenDishwasherRunSuperWash() {
        // given
        Set<Dish> dishes = prepareDishMocks();
        Dishwasher dishwasher = new Dishwasher(dishes);

        // when
        int numberOFWashes = dishwasher.superWash();

        // then
        assertEquals(3, numberOFWashes);
    }

    private Set<Dish> prepareDishMocks() {
        Set<Dish> dishes = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            dishes.add(mock(Dish.class));
        }
        return dishes;
    }
}