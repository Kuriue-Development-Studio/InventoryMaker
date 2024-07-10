package taewookim;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class InventoryData {

    private static Map<Player, CustomInventory> inventorys = new HashMap<>();

    public static void add(Player p, CustomInventory inventory) {
        inventorys.put(p, inventory);
    }

    public static CustomInventory get(Player p) {
        return inventorys.get(p);
    }

    public static void remove(Player p) {
        inventorys.remove(p);
    }

}
