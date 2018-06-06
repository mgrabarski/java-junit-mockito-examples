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

    /*
    Metoda buy powinna sprawdzić, czy sprzedawca ma przedmiot,
    a jeśli tak, to sprawić, aby sprzedawca go upuścił oraz otrzymał zapłatę,
    jednocześnie kupiec powinien otrzymać przedmiot
    oraz stracić odpowiednią sumę gotówki.
     */
    public void buy(Trader trader, Item item) {

        if (!trader.hasItem(item)) {
            trader.drop(item);
            trader.receiveMoney(item.getValue());

            items.add(item);
            moneyAmount -= item.getValue();
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