package mohautil.mohautil;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryEvent implements Listener {

    String inv = "§asetFlags§r";
    String prefix = "§f§l[=§dMU§r§l=]";
    String atmpre = "§e§l[§b§lMZN§e§lATM] ";
    int n = 0;
    VaultManager vault;

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {

        if (event.getView().getTitle().equals(atmpre)) {

            if (event.getCurrentItem().equals(Material.CHEST)) {
                event.setCancelled(true);
                event.getWhoClicked().openInventory(depoInv());
            }
            if (event.getCurrentItem().equals(Material.DROPPER)) {
                event.setCancelled(true);
                event.getWhoClicked().openInventory(withInv());
            }

            event.setCancelled(true);

        }

        if (event.getView().getTitle().equals(atmpre + "§e§l預け入れ")) {



        }

        if (event.getView().getTitle().equals(atmpre + "§6§l引き出し")) {



        }

        if (event.getView().getTitle().contains(inv)) {

            ItemStack hasitem = event.getWhoClicked().getInventory().getItemInMainHand();
            ItemMeta hasitemMeta = hasitem.getItemMeta();
            ItemStack falseitem = new ItemStack(Material.REDSTONE_BLOCK);
            ItemStack trueitem = new ItemStack(Material.EMERALD_BLOCK);

            if (event.getSlot() == 0) {
                if (event.getCurrentItem().getType() == (Material.EMERALD_BLOCK)) {
                    hasitemMeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
                    event.getInventory().setItem(0, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    event.getInventory().setItem(0, trueitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 1) {
                if (event.getCurrentItem().getType() == (Material.EMERALD_BLOCK)) {
                    hasitemMeta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    event.getInventory().setItem(1, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    event.getInventory().setItem(1, trueitem);
                    event.setCancelled(true);
                    hasitem.setItemMeta(hasitemMeta);
                    return;
                }
            }

            if (event.getSlot() == 2) {
                if (event.getCurrentItem().getType() == (Material.EMERALD_BLOCK)) {
                    hasitemMeta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    event.getInventory().setItem(2, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    event.getInventory().setItem(2, trueitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 3) {
                if (event.getCurrentItem().getType() == (Material.EMERALD_BLOCK)) {
                    hasitemMeta.removeItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    event.getInventory().setItem(3, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    event.getInventory().setItem(3, trueitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 4) {
                if (event.getCurrentItem().getType() == (Material.EMERALD_BLOCK)) {
                    hasitemMeta.removeItemFlags(ItemFlag.HIDE_DESTROYS);
                    event.getInventory().setItem(4, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    event.getInventory().setItem(4, trueitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 5) {
                if (event.getCurrentItem().getType() == (Material.EMERALD_BLOCK)) {
                    hasitemMeta.removeItemFlags(ItemFlag.HIDE_DYE);
                    event.getInventory().setItem(5, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.addItemFlags(ItemFlag.HIDE_DYE);
                    event.getInventory().setItem(5, trueitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 6) {
                if (event.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                    hasitemMeta.removeItemFlags(ItemFlag.HIDE_PLACED_ON);
                    event.getInventory().setItem(6, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    event.getInventory().setItem(6, trueitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 8) {
                if (event.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                    hasitemMeta.setUnbreakable(false);
                    event.getInventory().setItem(8, falseitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                } else {
                    hasitemMeta.setUnbreakable(true);
                    event.getInventory().setItem(8, trueitem);
                    hasitem.setItemMeta(hasitemMeta);
                    event.setCancelled(true);
                    return;
                }
            }

            event.setCancelled(true);
        }

        if (event.getView().getTitle().contains(prefix)) {

            if (event.getWhoClicked().getInventory().getItemInMainHand().getType() == event.getCurrentItem().getType()) {
                event.getWhoClicked().getInventory().addItem(event.getInventory().getItem(event.getSlot()));
                event.setCancelled(true);
            }

            if (event.getSlot() == 51) {
                Inventory inventory = Bukkit.createInventory(null, 54, prefix);

                Material material = event.getWhoClicked().getInventory().getItemInMainHand().getType();
                ItemStack cmditem = new ItemStack(material);
                ItemMeta cmdmeta = cmditem.getItemMeta();
                n = n + 45;

                for (int i = 0 ; i <= 44 ; i++) {
                    int cmd = i + n;
                    cmdmeta.setCustomModelData(cmd);
                    cmdmeta.setDisplayName("§a§l" + cmd);
                    cmditem.setItemMeta(cmdmeta);
                    inventory.setItem(i,cmditem);
                }

                ItemStack itemStack = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
                inventory.setItem(45, itemStack);
                inventory.setItem(46, itemStack);
                inventory.setItem(48, itemStack);
                inventory.setItem(49, itemStack);
                inventory.setItem(50, itemStack);
                inventory.setItem(52, itemStack);
                inventory.setItem(53, itemStack);
                ItemStack back = new ItemStack(Material.ARROW);
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName("§a前へ");
                back.setItemMeta(backMeta);
                ItemStack next = new ItemStack(Material.ARROW);
                ItemMeta nextMeta = next.getItemMeta();
                nextMeta.setDisplayName("§a次へ");
                next.setItemMeta(nextMeta);
                inventory.setItem(47, back);
                inventory.setItem(51, next);

                event.getWhoClicked().openInventory(inventory);
                event.setCancelled(true);
            }

            if (event.getSlot() == 47) {
                if (n == 0) {
                    event.setCancelled(true);
                    return;
                }

                Inventory inventory = Bukkit.createInventory(null, 54, prefix);

                Material material = event.getWhoClicked().getInventory().getItemInMainHand().getType();
                ItemStack cmditem = new ItemStack(material);
                ItemMeta cmdmeta = cmditem.getItemMeta();
                n = n - 45;

                for (int i = 0 ; i <= 44 ; i++) {
                    int cmd = i + n;
                    cmdmeta.setCustomModelData(cmd);
                    cmdmeta.setDisplayName("§a§l" + cmd);
                    cmditem.setItemMeta(cmdmeta);
                    inventory.setItem(i,cmditem);
                }

                ItemStack itemStack = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
                inventory.setItem(45, itemStack);
                inventory.setItem(46, itemStack);
                inventory.setItem(48, itemStack);
                inventory.setItem(49, itemStack);
                inventory.setItem(50, itemStack);
                inventory.setItem(52, itemStack);
                inventory.setItem(53, itemStack);
                ItemStack back = new ItemStack(Material.ARROW);
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName("§a前へ");
                back.setItemMeta(backMeta);
                ItemStack next = new ItemStack(Material.ARROW);
                ItemMeta nextMeta = next.getItemMeta();
                nextMeta.setDisplayName("§a次へ");
                next.setItemMeta(nextMeta);
                inventory.setItem(47, back);
                inventory.setItem(51, next);
                event.getWhoClicked().openInventory(inventory);
                event.setCancelled(true);
            }

            event.setCancelled(true);
        }

    }

    public Inventory depoInv() {
        Inventory inventory = Bukkit.createInventory(null, 54, atmpre + "§e§l預け入れ");

        return inventory;
    }

    public Inventory withInv() {
        Inventory inventory = Bukkit.createInventory(null, 27, atmpre + "§6§l引き出し");

        return inventory;
    }

}
