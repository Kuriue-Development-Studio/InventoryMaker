package taewookim;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.Objects;

public class Event implements Listener {

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        InventoryData.remove(e.getPlayer());
    }

    @EventHandler
    public void close(InventoryCloseEvent e) {
        if(e.getPlayer() instanceof Player p) {
            CustomInventory inv = InventoryData.get(p);
            if(inv==null) {
                return;
            }
            inv.onClose(e);
            InventoryData.remove(p);
        }
    }

    @EventHandler
    public void click(InventoryClickEvent e) {
        if(e.getWhoClicked() instanceof Player p) {
            CustomInventory inv = InventoryData.get(p);
            if(inv==null) {
                return;
            }
            if(e.getCurrentItem()==null||e.getClickedInventory()==null) {
                inv.onClickOutside(e);
                return;
            }
            if(Objects.equals(e.getClickedInventory().getHolder(), p)) {
                inv.onClickBotton(e);
                return;
            }
            inv.onClick(e);
        }
    }

    @EventHandler
    public void open(InventoryOpenEvent e) {
        if(e.getPlayer() instanceof Player p) {
            CustomInventory inv = InventoryData.get(p);
            if(inv==null) {
                return;
            }
            inv.onOpen(e);
        }
    }

    @EventHandler
    public void drag(InventoryDragEvent e) {
        if(e.getWhoClicked() instanceof Player p) {
            CustomInventory inv = InventoryData.get(p);
            if(inv==null) {
                return;
            }
            inv.onDrag(e);
        }
    }

}
