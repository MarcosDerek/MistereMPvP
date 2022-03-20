package me.main.Kits;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsManager {
  public static HashMap<String, KitType> kitpvp = new HashMap<>();
  
  public static boolean haskit(Player p, KitType kit) {
    Iterator<Map.Entry<String, KitType>> iterator = kitpvp.entrySet().iterator();
    if (iterator.hasNext()) {
      Map.Entry<String, KitType> i = iterator.next();
      if (i.getKey() == p.getName() && i.getValue() == kit)
        return true; 
      return false;
    } 
    return false;
  }
  
  public static boolean haskit(Player p) {
    return kitpvp.containsKey(p.getName());
  }
  
  public static void getKit(Player p, KitType kit) {
    
    PlayerInventory inv = p.getInventory();
    
    switch (kit) {
      case ARCHER:
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GREEN + "Archer");
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
        bow.setItemMeta(bowMeta);
        ItemStack arrow = new ItemStack(Material.ARROW, 64);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, bow);
        inv.setItem(9, arrow);
        
        giveSoup(p);
        break;
      case CAMEL:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case ENDERMAGE:
        ItemStack portal = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta portalMeta = portal.getItemMeta();
        portalMeta.setDisplayName(ChatColor.GREEN + "Endermage");
        portal.setItemMeta(portalMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, portal);
        
        giveSoup(p);
        break;
      case FIREMAN:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case FISHERMAN:
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodMeta = fishingrod.getItemMeta();
        fishingrodMeta.setDisplayName(ChatColor.GREEN + "Fisherman");
        fishingrod.setItemMeta(fishingrodMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, fishingrod);
        
        giveSoup(p);
        break;
      case FLASH:
        ItemStack torch = new ItemStack(Material.REDSTONE_TORCH_ON);
        ItemMeta torchMeta = torch.getItemMeta();
        torchMeta.setDisplayName(ChatColor.GREEN + "Flash");
        torch.setItemMeta(torchMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, torch);
        
        giveSoup(p);
        break;
      case GLADIATOR:
        ItemStack ironbar = new ItemStack(Material.IRON_BARDING);
        ItemMeta ironbarMeta = ironbar.getItemMeta();
        ironbarMeta.setDisplayName(ChatColor.GREEN + "Gladiator");
        ironbar.setItemMeta(ironbarMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, ironbar);
        
        giveSoup(p);
        break;
      case GLIDER:
    	ItemStack featherG = new ItemStack(Material.FEATHER);
        ItemMeta featherGMeta = featherG.getItemMeta();
        featherGMeta.setDisplayName(ChatColor.GREEN + "Glider");
        featherG.setItemMeta(featherGMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, featherG);
        
        giveSoup(p);
        break;
      case GRANDPA:
      	ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.setDisplayName(ChatColor.GREEN + "Grandpa");
        stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        stick.setItemMeta(stickMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, stick);
        
        giveSoup(p);
        break;
      case GRAPPER:
      	ItemStack lead = new ItemStack(Material.LEASH);
        ItemMeta leadMeta = lead.getItemMeta();
        leadMeta.setDisplayName(ChatColor.GREEN + "Grapper");
        lead.setItemMeta(leadMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, lead);
        
        giveSoup(p);
        break;
      case HERMIT:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case HULK:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case KANGAROO:
        ItemStack rocket = new ItemStack(Material.FIREWORK);
        ItemMeta rocketMeta = rocket.getItemMeta();
        rocketMeta.setDisplayName(ChatColor.GREEN + "Kangaroo");
        rocket.setItemMeta(rocketMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, rocket);
        
        giveSoup(p);
        break;
      case MAGMA:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case NINJA:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case PHANTOM:
      	ItemStack feather = new ItemStack(Material.FEATHER);
        ItemMeta featherMeta = feather.getItemMeta();
        featherMeta.setDisplayName(ChatColor.GREEN + "feather");
        feather.setItemMeta(featherMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, feather);
        
        giveSoup(p);
        break;
      case POSEIDON:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case PYRO:
      	ItemStack fireballs = new ItemStack(Material.FIREBALL);
        ItemMeta fireballsMeta = fireballs.getItemMeta();
        fireballsMeta.setDisplayName(ChatColor.GREEN + "Pyro");
        fireballs.setItemMeta(fireballsMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, fireballs);
        
        giveSoup(p);
        break;
      case PVP:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case REAPER:
      	ItemStack hoe = new ItemStack(Material.WOOD_HOE);
        ItemMeta hoeMeta = hoe.getItemMeta();
        hoeMeta.setDisplayName(ChatColor.GREEN + "Reaper");
        hoe.setItemMeta(hoeMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, hoe);
        
        giveSoup(p);
        break;
      case SNAIL:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case SPECIALIST:
      	ItemStack table = new ItemStack(Material.ENCHANTMENT_TABLE);
        ItemMeta tableMeta = table.getItemMeta();
        tableMeta.setDisplayName(ChatColor.GREEN + "Specialist");
        table.setItemMeta(tableMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, table);
        
        giveSoup(p);
        break;
      case STOMPER:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case SWITCHER:
      	ItemStack snowballs = new ItemStack(Material.SNOW_BALL);
        ItemMeta snowballsMeta = snowballs.getItemMeta();
        snowballsMeta.setDisplayName(ChatColor.GREEN + "Switcher");
        snowballs.setItemMeta(snowballsMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, snowballs);
        
        giveSoup(p);
        break;
      case TANK:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case THOR:
      	ItemStack axe = new ItemStack(Material.WOOD_AXE);
        ItemMeta axeMeta = axe.getItemMeta();
        axeMeta.setDisplayName(ChatColor.GREEN + "Thor");
        axe.setItemMeta(axeMeta);
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(1, axe);
        
        giveSoup(p);
        break;
      case TURTLE:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
      case VIKING:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_AXE));
        
        giveSoup(p);
        break;
      case VIPER:
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
        
        giveSoup(p);
        break;
    } 
  }
  
  public static void giveSoup(Player p) {
	  
	  ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
	  
      for (int i = 0; i < 32; i++) {
          p.getInventory().addItem(soup);
      }
  }
}
