package externo;

import domain.ItemGlobal;

import java.util.ArrayList;
import java.util.List;

public class GlobalMarketApi {

    public List<ItemGlobal> fetchAvailableItems() {
        List<ItemGlobal> items = new ArrayList<>();

        items.add(new ItemGlobal("G900", "Mouse Gamer", 40.0, 5));
        items.add(new ItemGlobal("G901", "Webcam Full HD", 35.0, 0));
        items.add(new ItemGlobal("G902", "Headset USB", 28.0, 10));

        return items;
    }
}
