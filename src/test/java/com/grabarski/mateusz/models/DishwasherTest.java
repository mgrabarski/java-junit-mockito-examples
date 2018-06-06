package com.grabarski.mateusz.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DishwasherTest {

    @Mock
    private Dishwasher dishwasher;

    @Captor
    private ArgumentCaptor<Dish> dishArgumentCaptor;

    @Test
    public void shouldCallWashOnAllDishesInDishwasher() {

        dishwasher.addDish(spy(new Dish()));
        dishwasher.addDish(spy(new Dish()));

        verify(dishwasher, times(2)).addDish(dishArgumentCaptor.capture());

        dishwasher.wash();
        verify(dishwasher).wash();

        // TODO: 06.06.2018 verify wash from dish object 
    }
}