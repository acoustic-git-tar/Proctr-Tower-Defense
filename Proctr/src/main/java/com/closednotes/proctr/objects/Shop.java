package com.closednotes.proctr.objects;

import com.closednotes.proctr.Difficulty;
import com.closednotes.proctr.objects.tower.Buzzcard;
import com.closednotes.proctr.objects.tower.LockdownBrowser;
import com.closednotes.proctr.objects.tower.TA;
import com.closednotes.proctr.objects.tower.Tower;

import java.util.ArrayList;

public class Shop {
    private ArrayList<ShopItem> items;

    public Shop(Difficulty difficulty) {
        items = new ArrayList<ShopItem>();
        items.add(new ShopItem(new Buzzcard(difficulty)));
        items.add(new ShopItem(new TA(difficulty)));
        items.add(new ShopItem(new LockdownBrowser(difficulty)));
        for (ShopItem i: items) {
            i.enable();
        }
    }
    public ArrayList<ShopItem> getItems() {
        return items;
    }

    private class ShopItem {
        private Tower tower;
        private boolean enabled;

        private ShopItem(Tower tower) {
            this.tower = tower;
            enabled = true;
        }

        public void enable() {
            enabled = true;
        }
        public void disable() {
            enabled = false;
        }
    }


}
