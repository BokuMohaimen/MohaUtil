package mohautil.mohautil;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MohaUtil extends JavaPlugin implements Listener {

    String Perm = "mu.op";
    String inv = "§asetFlags§r";
    String prefix = "§f§l[=§dMU§r§l=]";
    String atmpre = "§e§l[§b§lMZN§e§lATM] ";
    int n = 0;
    VaultManager vault;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        vault = new VaultManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("atm")) {

            player.openInventory(createATMmenu());

            return true;
        }

        if (command.getName().equalsIgnoreCase("mz")) {

            if (!hasPerm((Player) sender)) return false;

            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta itemMeta = item.getItemMeta();
            if (args.length == 0) {
                sender.sendMessage("§7==========="+prefix+"§7===========");
                sender.sendMessage("§f§l/mz §e§lcolor §r§7➡ 装飾コードを表示します");
                sender.sendMessage("§f§l/mz §e§lcmd");
                sender.sendMessage(" §r§7➡ 手に持っているアイテムのカスタムモデルデータを");
                sender.sendMessage(" §r§7➡ GUIで表示します(そのGUIのアイテムをクリックすれば入手できます)");
                sender.sendMessage("§f§l/mz §e§lsetdata [数字]");
                sender.sendMessage(" §r§7➡ 手に持っているアイテムをカスタムモデルデータ[数字]に設定します");
                sender.sendMessage("§f§l/mz §e§lsetench [エンチャント名] [レベル]");
                sender.sendMessage(" §r§7➡ 手に持っているアイテムにエンチャントを付与します");
                sender.sendMessage("§f§l/mz §e§ldelench [エンチャント名] §r§7➡ 手に持っているアイテムエンチャントを外します");
                sender.sendMessage("§f§l/mz §e§lsetflag §r§7➡ アイテムのフラグを設定するGUIを開きます");
                sender.sendMessage("§f§l/mz §e§lsetname §r§7➡ 手に持っているアイテムの名前を変更します");
                sender.sendMessage(" §r§7➡ (*を使うと空白になります)");
                sender.sendMessage("§7============================");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equals("color")) {

                    sender.sendMessage(prefix + " §11 §22 §33 §44 §55 §66 §77 §88 §99 §00 §aa §bb §cc §dd §ee §ff §kk§r §ll§r §mm§r §nn§r §oo§r");
                    return true;

                }
                if (args[0].equalsIgnoreCase("setflag")) {

                    if (item.getType() == Material.AIR) {
                        player.sendMessage(prefix + " §c手に何かアイテムを持ってださい！");
                        return false;
                    }

                    Inventory inventory = Bukkit.createInventory(null, 18, inv + " " + itemMeta.getDisplayName());

                    ItemStack i1 = new ItemStack(Material.PAPER);
                    ItemMeta i1Meta = i1.getItemMeta();
                    i1Meta.setDisplayName("§lエンチャントを隠す");
                    i1.setItemMeta(i1Meta);

                    ItemStack i2 = new ItemStack(Material.PAPER);
                    ItemMeta i2Meta = i2.getItemMeta();
                    i2Meta.setDisplayName("§l不可壊を隠す");
                    i2.setItemMeta(i2Meta);

                    ItemStack i3 = new ItemStack(Material.PAPER);
                    ItemMeta i3Meta = i3.getItemMeta();
                    i3Meta.setDisplayName("§l身に着けたときの効果の詳細を隠す");
                    i3.setItemMeta(i3Meta);

                    ItemStack i4 = new ItemStack(Material.PAPER);
                    ItemMeta i4Meta = i4.getItemMeta();
                    i4Meta.setDisplayName("§lポーション効果の詳細を隠す");
                    i4.setItemMeta(i4Meta);

                    ItemStack i5 = new ItemStack(Material.PAPER);
                    ItemMeta i5Meta = i5.getItemMeta();
                    i5Meta.setDisplayName("§l何を破壊できるかを隠す");
                    i5.setItemMeta(i5Meta);

                    ItemStack i6 = new ItemStack(Material.PAPER);
                    ItemMeta i6Meta = i6.getItemMeta();
                    i6Meta.setDisplayName("§l染料の詳細を隠す");
                    i6.setItemMeta(i6Meta);

                    ItemStack i7 = new ItemStack(Material.PAPER);
                    ItemMeta i7Meta = i7.getItemMeta();
                    i7Meta.setDisplayName("§l何に設置できるかを隠す");
                    i7.setItemMeta(i7Meta);

                    ItemStack i8 = new ItemStack(Material.PAPER);
                    ItemMeta i8Meta = i8.getItemMeta();
                    i8Meta.setDisplayName("§l不可壊");
                    i8.setItemMeta(i8Meta);

                    inventory.setItem(9,i1);
                    inventory.setItem(10,i2);
                    inventory.setItem(11,i3);
                    inventory.setItem(12,i4);
                    inventory.setItem(13,i5);
                    inventory.setItem(14,i6);
                    inventory.setItem(15,i7);
                    inventory.setItem(17,i8);

                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lHIDE_ENCHANT TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(0, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lHIDE_ENCHANT FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(0, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lHIDE_UNBREAKABLE TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(1, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lHIDE_UNBREAKABLE FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(1, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lHIDE_ATTRIBUTES TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(2, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lHIDE_ATTRIBUTES FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(2, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lHIDE_POTION_EFFECTS TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(3, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lHIDE_POTION_EFFECTS FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(3, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_DESTROYS)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lHIDE_DESTROYS TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(4, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lHIDE_DESTROYS FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(4, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_DYE)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lHIDE_DYE TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(5, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lHIDE_DYE FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(5, enchant);
                    }
                    if (itemMeta.hasItemFlag(ItemFlag.HIDE_PLACED_ON)) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lHIDE_PLACED_ON TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(6, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lHIDE_PLACED_ON FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(6, enchant);
                    }
                    if (itemMeta.isUnbreakable()) {
                        ItemStack enchant = new ItemStack(Material.EMERALD_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§a§lUNBREAKABLE TRUE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(8, enchant);
                    } else {
                        ItemStack enchant = new ItemStack(Material.REDSTONE_BLOCK);
                        ItemMeta enchantMeta = enchant.getItemMeta();
                        enchantMeta.setDisplayName("§4§lUNBREAKABLE FALSE");
                        enchant.setItemMeta(enchantMeta);
                        inventory.setItem(8, enchant);
                    }
                    player.openInventory(inventory);
                    return true;
                }

                if (args[0].equalsIgnoreCase("cmd")) {

                    if (item.getType() == Material.AIR) {
                        player.sendMessage(prefix + " §c手に何かアイテムを持ってださい！");
                        return false;
                    }

                    Inventory inventory = Bukkit.createInventory(null, 54, prefix + " " + itemMeta.getDisplayName());

                    Material material = item.getType();
                    ItemStack cmditem = new ItemStack(material);
                    ItemMeta cmdmeta = cmditem.getItemMeta();

                    for (int i = 0 ; i <= 44 ; i++) {
                        cmdmeta.setCustomModelData(i);
                        cmdmeta.setDisplayName("§a§l" + i);
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

                    player.openInventory(inventory);
                    return true;
                }

            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("setdata")) {

                    if (item.getType() == Material.AIR) {
                        player.sendMessage(prefix + " §c手に何かアイテムを持ってださい！");
                        return false;
                    }

                    itemMeta.setCustomModelData(Integer.valueOf(args[1]));
                    item.setItemMeta(itemMeta);
                    player.sendMessage(prefix + " §lカスタムモデルデータ §r: §e§l" + args[1] + "§r§lに変更しました。");
                    return true;
                }

                if (args[0].equalsIgnoreCase("delench")) {

                    if (item.getType() == Material.AIR) {
                        player.sendMessage(prefix + " §c手に何かアイテムを持ってださい！");
                        return false;
                    }
                    if (!itemMeta.hasEnchants()) {
                        player.sendMessage(prefix + " §c外せるエンチャントは存在しません！");
                        return false;
                    }
                    if (!itemMeta.hasEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[1])))) {
                        player.sendMessage(prefix + " §cそのエンチャントは付与されていません！");
                        return false;
                    }
                    itemMeta.removeEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[1])));
                    item.setItemMeta(itemMeta);
                    player.sendMessage(prefix + " §e§l" + args[1] + " §r§lのエンチャントを外しました");
                    return true;
                }

                if (args[0].equalsIgnoreCase("setname")) {

                    if (item.getType() == Material.AIR) {
                        player.sendMessage(prefix + " §c手に何かアイテムを持ってださい！");
                        return false;
                    }
                    itemMeta.setDisplayName(args[1].replace("&","§").replace("*", " "));
                    item.setItemMeta(itemMeta);
                    player.sendMessage(prefix + " §f§l名前を §r" + args[1].replace("&","§") + " §r§lに変更しました");
                    return true;
                }

            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("setench")) {
                    if (item.getType() == Material.AIR) {
                        player.sendMessage(prefix + " §c手に何かアイテムを持ってださい！");
                        return false;
                    }
                    itemMeta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[1])), Integer.parseInt(args[2]), true);
                    item.setItemMeta(itemMeta);
                    player.sendMessage(prefix + " §e§l" + args[1] + " §rの レベル§e§l " + args[2] + " §r§lを付与しました");
                    return true;
                }
            } else {
                sender.sendMessage(prefix + " §c使い方が間違っています！");
                return false;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length==1) {
            return strings(args[0], Arrays.asList("color","cmd","setdata","setench","delench","setflag","setname"));
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
            if (args[0].equalsIgnoreCase("delench")) {
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

    public boolean hasPerm(Player player) {
        if (!player.hasPermission(Perm)) {
            player.sendMessage(prefix + "§cあなたには権限がありません！");
            return false;
        }
        return true;
    }

    public Inventory createATMmenu() {

        Inventory inventory = Bukkit.createInventory(null, 27, atmpre);
        ItemStack glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS);
        ItemStack depoitem = new ItemStack(Material.CHEST);
        ItemStack withitem = new ItemStack(Material.DROPPER);
        ItemMeta glassmeta = glass.getItemMeta();
        ItemMeta depometa = depoitem.getItemMeta();
        ItemMeta withmeta = withitem.getItemMeta();
        glassmeta.setDisplayName(" ");
        glass.setItemMeta(glassmeta);
        depometa.setDisplayName("§e§l預け入れ");
        depoitem.setItemMeta(depometa);
        withmeta.setDisplayName("§6§l引き出し");
        withitem.setItemMeta(withmeta);

        int[] glassi = {0,4,8,9,13,17,18,22,26};
        int[] depo = {1,2,3,10,11,12,19,20,21};
        int[] with = {5,6,7,14,15,16,23,24,25};

        for (int i : glassi) {
            inventory.setItem(i, glass);
        }
        for (int i = 0 ; i < depo.length ; i++) {
            inventory.setItem(depo[i], depoitem);
            inventory.setItem(with[i], withitem);
        }
        return inventory;

    }

}
