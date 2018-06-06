package com.grabarski.mateusz.models.traders;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by Mateusz Grabarski on 06.06.2018.
 */
public class TraderTest {

    @Test
    public void shouldSuccessDropItemFromTraderItems() {
        // given
        List<Item> items = getBaseItems();
        Trader trader = new Trader(items, 100);
        Item itemToRemove = items.get(0);

        // when
        boolean removeResult = trader.drop(itemToRemove);

        // then
        assertTrue(removeResult);
    }

    @Test
    public void shouldReturnFalseWhenTryingRemoveItemThatTraderDontHave() {
        // given
        Trader trader = new Trader(Collections.emptyList(), 100);
        Item itemToRemove = getBaseItems().get(0);

        // when
        boolean removeResult = trader.drop(itemToRemove);

        // then
        assertFalse(removeResult);
    }

    @Test
    public void shouldAddTraderAmount() {
        // given
        int amount = 100;
        Trader trader = new Trader(Collections.emptyList(), amount);

        // when
        trader.receiveMoney(amount);

        // then
        assertEquals(amount * 2, trader.getMoneyAmount());
    }

    @Test
    public void shouldSuccessCheckHasTraderHaveItem() {
        // given
        List<Item> items = getBaseItems();
        Trader trader = new Trader(items, 100);
        Item checkingItem = items.get(0);

        // when
        boolean hasItem = trader.hasItem(checkingItem);

        // then
        assertTrue(hasItem);
    }

    @Test
    public void shouldReturnFalseWhen_CheckHasTraderHaveItem() {
        // given
        Trader trader = new Trader(Collections.emptyList(), 100);
        Item checkingItem = getBaseItems().get(0);

        // when
        boolean hasItem = trader.hasItem(checkingItem);

        // then
        assertFalse(hasItem);
    }

    @Test
    public void shouldCheckIsTraderHasItem() {
        // given
        int startSellerMoney = 100;
        int startBuyerMoney = 200;
        Trader seller = spy(new Trader(getBaseItems(), startSellerMoney));
        Trader buyer = new Trader(getBaseItems(), startBuyerMoney);
        Item checkingItemFromSeller = getBaseItems().get(0);

        // when
        buyer.buy(seller, checkingItemFromSeller);

        // then
        checkIsSellerDropItemAndReceiveMoney(seller, startSellerMoney, checkingItemFromSeller);
        checkIsBuyerHasNewItemAndAmountIsLess(startBuyerMoney, buyer, checkingItemFromSeller);
    }

    private void checkIsSellerDropItemAndReceiveMoney(Trader seller, int startSellerMoney, Item item) {
        verify(seller).drop(item);
        verify(seller).receiveMoney(item.getValue());

        assertFalse(seller.hasItem(item));
        assertEquals(startSellerMoney + item.getValue(),
                seller.getMoneyAmount());
    }

    private void checkIsBuyerHasNewItemAndAmountIsLess(int startBuyerMoney, Trader buyer, Item item) {
        assertTrue(buyer.hasItem(item));
        assertEquals(startBuyerMoney - item.getValue(),
                buyer.getMoneyAmount());
    }

    private List<Item> getBaseItems() {
        return new ArrayList<>(Arrays.asList(
                new Item("Item1", 10),
                new Item("Item2", 20),
                new Item("Item3", 30)
        ));
    }
}