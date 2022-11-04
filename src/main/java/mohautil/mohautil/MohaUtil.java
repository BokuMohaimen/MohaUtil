package mohautil.mohautil;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MohaUtil extends JavaPlugin {

    String inv = "§asetFlags§r";

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {

        event.getWhoClicked().sendMessage(inv.replace("§", "a"));

        if (event.getView().getTitle().equals(inv)) {

            ItemStack pitem = event.getWhoClicked().getInventory().getItemInMainHand();
            ItemMeta pitemMeta = pitem.getItemMeta();
            ItemStack falseitem = new ItemStack(Material.REDSTONE_BLOCK);
            ItemStack trueitem = new ItemStack(Material.EMERALD_BLOCK);

            event.getWhoClicked().sendMessage("a");

            if (event.getSlot() == 0) {
                if (event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {
                    pitemMeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
                    event.getInventory().setItem(0, falseitem);
                    event.setCancelled(true);
                    return;
                } else {
                    pitemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    event.getInventory().setItem(0, trueitem);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 1) {
                if (event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {
                    pitemMeta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    event.getInventory().setItem(1, falseitem);
                    event.setCancelled(true);
                    return;
                } else {
                    pitemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                    event.getInventory().setItem(1, trueitem);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 2) {
                if (event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {
                    pitemMeta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    event.getInventory().setItem(2, falseitem);
                    event.setCancelled(true);
                    return;
                } else {
                    pitemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    event.getInventory().setItem(2, trueitem);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 3) {
                if (event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {
                    pitemMeta.removeItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    event.getInventory().setItem(3, falseitem);
                    event.setCancelled(true);
                    return;
                } else {
                    pitemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    event.getInventory().setItem(3, trueitem);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 4) {
                if (event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {
                    pitemMeta.removeItemFlags(ItemFlag.HIDE_DESTROYS);
                    event.getInventory().setItem(4, falseitem);
                    event.setCancelled(true);
                    return;
                } else {
                    pitemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
                    event.getInventory().setItem(4, trueitem);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 5) {
                if (event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {
                    pitemMeta.removeItemFlags(ItemFlag.HIDE_DYE);
                    event.getInventory().setItem(5, falseitem);
                    event.setCancelled(true);
                    return;
                } else {
                    pitemMeta.addItemFlags(ItemFlag.HIDE_DYE);
                    event.getInventory().setItem(5, trueitem);
                    event.setCancelled(true);
                    return;
                }
            }

            if (event.getSlot() == 6) {
                if (event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {
                    pitemMeta.removeItemFlags(ItemFlag.HIDE_PLACED_ON);
                    event.getInventory().setItem(6, falseitem);
                    event.setCancelled(true);
                    return;
                } else {
                    pitemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
                    event.getInventory().setItem(6, trueitem);
                    event.setCancelled(true);
                    return;
                }
            }
        }

    }

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("moha")) {
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta itemMeta = item.getItemMeta();
            if (args.length == 0) {
                sender.sendMessage("=====MOHA=====");
                sender.sendMessage("/moha color ➡ 装飾コードを表示します");
                sender.sendMessage("/moha setdata [数字] ➡ 手に持っているアイテムをカスタムモデルデータ[数字]に設定します");
                sender.sendMessage("/moha setench [エンチャント名] [レベル]");
                sender.sendMessage(" ➡ 手に持っているアイテムにエンチャントを付与します");
                sender.sendMessage("/moha unbre ➡ 手に持っているアイテムを不可壊します");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equals("color")) {

                    sender.sendMessage("§11 §22 §33 §44 §55 §66 §77 §88 §99 §00 §aa §bb §cc §dd §ee §ff §gg §kk§r §ll§r §mm§r §nn§r §oo§r");
                    return true;

                }
                if (args[0].equalsIgnoreCase("setflag")) {

                    if (item.getType() == Material.AIR) {
                        player.sendMessage("手に何かアイテムを持ってださい！");
                        return false;
                    }

                    Inventory inventory = Bukkit.createInventory(null, 18, inv);

                    ItemStack i1 = new ItemStack(Material.PAPER);
                    ItemMeta i1Meta = i1.getItemMeta();
                    i1Meta.setDisplayName("エンチャントを隠す");
                    i1.setItemMeta(i1Meta);

                    ItemStack i2 = new ItemStack(Material.PAPER);
                    ItemMeta i2Meta = i2.getItemMeta();
                    i2Meta.setDisplayName("不可壊を隠す");
                    i2.setItemMeta(i2Meta);

                    ItemStack i3 = new ItemStack(Material.PAPER);
                    ItemMeta i3Meta = i3.getItemMeta();
                    i3Meta.setDisplayName("身に着けたときの効果の詳細を隠す");
                    i3.setItemMeta(i3Meta);

                    ItemStack i4 = new ItemStack(Material.PAPER);
                    ItemMeta i4Meta = i4.getItemMeta();
                    i4Meta.setDisplayName("ポーション効果の詳細を隠す");
                    i4.setItemMeta(i4Meta);

                    ItemStack i5 = new ItemStack(Material.PAPER);
                    ItemMeta i5Meta = i5.getItemMeta();
                    i5Meta.setDisplayName("何を破壊できるかを隠す");
                    i5.setItemMeta(i5Meta);

                    ItemStack i6 = new ItemStack(Material.PAPER);
                    ItemMeta i6Meta = i6.getItemMeta();
                    i6Meta.setDisplayName("染料の詳細を隠す");
                    i6.setItemMeta(i6Meta);

                    ItemStack i7 = new ItemStack(Material.PAPER);
                    ItemMeta i7Meta = i7.getItemMeta();
                    i7Meta.setDisplayName("何に設置できるかを隠す");
                    i7.setItemMeta(i7Meta);

                    inventory.setItem(9,i1);
                    inventory.setItem(10,i2);
                    inventory.setItem(11,i3);
                    inventory.setItem(12,i4);
                    inventory.setItem(13,i5);
                    inventory.setItem(14,i6);
                    inventory.setItem(15,i7);

                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_ENCHANT TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(0, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_ENCHANT FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(0, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_UNBREAKABLE TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(1, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_UNBREAKABLE FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(1, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_ATTRIBUTES TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(2, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_ATTRIBUTES FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(2, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_POTION_EFFECTS TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(3, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_POTION_EFFECTS FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(3, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_DESTROYS)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_DESTROYS TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(4, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_DESTROYS FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(4, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_DYE)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_DYE TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(5, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_DYE FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(5, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_PLACED_ON)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_PLACED_ON TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(6, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("HIDE_PLACED_ON FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(6, enchant);
                    }
                    player.openInventory(inventory);
                    return true;
                }
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("setdata")) {

                    if (item.getType() == Material.AIR) {
                        player.sendMessage("手に何かアイテムを持ってださい！");
                        return false;
                    }

                    itemMeta.setCustomModelData(Integer.valueOf(args[1]));
                    item.setItemMeta(itemMeta);
                    player.sendMessage("カスタムモデルデータ : " + args[1] + "に変更しました。");
                    return true;

                }
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("setench")) {
                    if (item.getType() == Material.AIR) {
                        player.sendMessage("手に何かアイテムを持ってださい！");
                        return false;
                    }
                    itemMeta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[1])), Integer.parseInt(args[2]), true);
                    item.setItemMeta(itemMeta);
                    return true;
                }
            } else {
                sender.sendMessage("使い方が間違っています！");
                return false;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length==1) {
            return strings(args[0], Arrays.asList("color","setdata","setench","setflag"));
        }
        if(args.length==2) {
            if (args[0].equalsIgnoreCase("setench")) {
                List<String> list = new ArrayList<>();
                list.add("protection");
                list.add("fire_protection");
                list.add("feather_falling");
                list.add("blast_protection");
                list.add("projectile_protection");
                list.add("respiration");
                list.add("aqua_affinity");
                list.add("thorns");
                list.add("depth_strider");
                list.add("frost_walker");
                list.add("sharpness");
                list.add("smite");
                list.add("bane_of_arthropods");
                list.add("knockback");
                list.add("fire_aspect");
                list.add("looting");
                list.add("efficiency");
                list.add("silk_touch");
                list.add("unbreaking");
                list.add("fortune");
                list.add("power");
                list.add("punch");
                list.add("flame");
                list.add("infinity");
                list.add("luck_of_the_sea");
                list.add("lure");
                list.add("mending");
                return strings(args[1], list);
            }
        }
        return null;
    }

    private List<String> strings(String s,List<String> args){
        List<String> list = new ArrayList<>();
        for(String s1:args){
            if(s1.startsWith(s))
                list.add(s1);
        }
        return list;
    }
}
