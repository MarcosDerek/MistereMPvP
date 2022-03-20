package me.main.Warps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Spawn implements Listener {

	@EventHandler
	  public void playerRespawn(PlayerRespawnEvent e) {
	    Player p = e.getPlayer();
	    if (p.getLocation().getWorld().getName().equalsIgnoreCase("home")) {
	      Location homeSpawn = new Location(Bukkit.getServer().getWorld("home"), 0.5D, 50.5D, 0.5D, 180.0F, 0.0F);
	      ItemStack hubs = new ItemStack(Material.COMPASS);
	      ItemMeta hubsMeta = hubs.getItemMeta();
	      hubsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Hubs");
	      hubs.setItemMeta(hubsMeta);
	      ItemStack kits = new ItemStack(Material.CHEST);
	      ItemMeta kitsMeta = hubs.getItemMeta();
	      kitsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Kits");
	      kits.setItemMeta(kitsMeta);
	      e.setRespawnLocation(homeSpawn);
	      p.getInventory().clear();
	      p.setHealth(20.0D);
	      p.setFoodLevel(20);
	      p.setGameMode(GameMode.SURVIVAL);
	      p.getInventory().setItem(1, hubs);
	      p.getInventory().setItem(4, kits);
	    } 
	  }
	
}
