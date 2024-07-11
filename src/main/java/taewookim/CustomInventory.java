package taewookim;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;

public abstract class CustomInventory {

    protected final Inventory inv;

    public CustomInventory(int line, String title) {
        inv = Bukkit.createInventory(null, line*9, title);
    }

    public final void openPlayer(Player p) {
        InventoryData.add(p, this);
        p.openInventory(inv);
    }

    protected static int getSlot(int x, int y) {
        return y*9+x;
    }

    protected abstract void onOpen(InventoryOpenEvent e);

    protected abstract void onClose(InventoryCloseEvent e);

    protected abstract void onClickBotton(InventoryClickEvent e);

    protected abstract void onClickOutside(InventoryClickEvent e);

    protected abstract void onClick(InventoryClickEvent e);

    protected abstract void onDrag(InventoryDragEvent e);

}
