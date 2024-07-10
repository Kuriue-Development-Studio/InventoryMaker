package taewookim;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;

public abstract class CustomInventory {

    private final Inventory inv;

    public CustomInventory(int line, String title) {
        inv = Bukkit.createInventory(null, line*9, title);
    }

    public final void openPlayer(Player p) {
        InventoryData.add(p, this);
        p.openInventory(inv);
    }

    private static int getSlot(int x, int y) {
        return y*9+x;
    }

    abstract void onOpen(InventoryOpenEvent e);

    abstract void onClose(InventoryCloseEvent e);

    abstract void onClickBotton(InventoryClickEvent e);

    abstract void onClickOutside(InventoryClickEvent e);

    abstract void onClick(InventoryClickEvent e);

    abstract void onDrag(InventoryDragEvent e);

}
