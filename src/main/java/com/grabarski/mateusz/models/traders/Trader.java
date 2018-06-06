package com.grabarski.mateusz.models.traders;

import java.util.List;

/**
 * Created by Mateusz Grabarski on 06.06.2018.
 */
public class Trader {

    private List<Item> items;
    private int moneyAmount;

    public Trader(List<Item> items, int moneyAmount) {
        this.items = items;
        this.moneyAmount = moneyAmount;
    }

    public void buy(Trader trader, Item item) {

        checkCanBuyNewItem(trader, item);

        if (!trader.hasItem(item)) {
            trader.drop(item);
            trader.receiveMoney(item.getValue());

            items.add(item);
            moneyAmount -= item.getValue();
        }
    }

    private void checkCanBuyNewItem(Trader trader, Item item) {
        if (moneyAmount < item.getValue()) {
            throw new IllegalArgumentException("Not enough money for buy item.");
        }

        if (items.contains(item)) {
            throw new IllegalArgumentException("Can not buy item that already is buy");
        }
    }

    public boolean drop(Item item) {
        return items.remove(item);
    }

    public void receiveMoney(int amount) {
        this.moneyAmount += amount;
    }

    public boolean hasItem(Item item) {
        return items.contains(item);
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }
}