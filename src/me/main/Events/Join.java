package me.main.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.main.PermissionsAndCommands.Commands;

public class Join implements Listener {
  @EventHandler
  public void mushrooms(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
      if (p.getItemInHand().getType() == Material.RED_MUSHROOM)
        e.getClickedBlock().getRelative(BlockFace.UP).setType(Material.RED_MUSHROOM); 
      if (p.getItemInHand().getType() == Material.BROWN_MUSHROOM)
        e.getClickedBlock().getRelative(BlockFace.UP).setType(Material.BROWN_MUSHROOM); 
    } 
  }
  
  @EventHandler
  public void playerJoined(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    World home = Bukkit.getWorld("home");
    ItemStack hubs = new ItemStack(Material.COMPASS);
    ItemMeta hubsMeta = hubs.getItemMeta();
    hubsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Hubs");
    hubs.setItemMeta(hubsMeta);
    ItemStack kits = new ItemStack(Material.CHEST);
    ItemMeta kitsMeta = hubs.getItemMeta();
    kitsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Kits");
    kits.setItemMeta(kitsMeta);
    e.setJoinMessage(null);
    p.getInventory().clear();
    p.setHealth(20.0D);
    p.setFoodLevel(20);
    p.setGameMode(GameMode.SURVIVAL);
    p.getInventory().setItem(1, hubs);
    p.getInventory().setItem(4, kits);
    if (p.hasPermission("mplugin.adminmode")) {
      p.setOp(true);
      Commands.adminMod.add(p.getName());
      for (Player all : Bukkit.getOnlinePlayers()) {
        if (all.hasPermission("mplugin.adminmode")) {
          all.showPlayer(p);
          continue;
        } 
        all.hidePlayer(p);
      } 
      p.sendMessage(ChatColor.GREEN + "You are on admin mode.");
      p.setGameMode(GameMode.CREATIVE);
    } 
    if (p.hasPermission("mplugin.admin")) {
      p.isPermissionSet("mplugin.admin");
      p.isPermissionSet("mplugin.promote.admin");
      p.isPermissionSet("mplugin.adminmode");
      p.isPermissionSet("mplugin.inv");
      p.isPermissionSet("mplugin.chat.manage");
      p.isPermissionSet("mplugin.events.manage");
      p.isPermissionSet("mplugin.gamemode");
      p.isPermissionSet("mplugin.construction");
      p.isPermissionSet("mplugin.kits.*");
    } 
    if (p.hasPermission("mplugin.mod+")) {
      p.isPermissionSet("mplugin.mod+");
      p.isPermissionSet("mplugin.adminmode");
      p.isPermissionSet("mplugin.inv");
      p.isPermissionSet("mplugin.events.manage");
      p.isPermissionSet("mplugin.gamemode");
      p.isPermissionSet("mplugin.kits.*");
    } 
    if (p.hasPermission("mplugin.mod")) {
      p.isPermissionSet("mplugin.mod");
      p.isPermissionSet("mplugin.adminmode");
      p.isPermissionSet("mplugin.inv");
      p.isPermissionSet("mplugin.gamemode");
      p.isPermissionSet("mplugin.kits.*");
    } 
    if (p.hasPermission("mplugin.youtuber")) {
      p.isPermissionSet("mplugin.youtuber");
      p.isPermissionSet("mplugin.kits.*");
    } 
    if (p.hasPermission("mplugin.pro")) {
      p.isPermissionSet("mplugin.pro");
      p.isPermissionSet("mplugin.kits.*");
    } 
    if (p.hasPermission("mplugin.mvp")) {
      p.isPermissionSet("mplugin.mvp");
      p.isPermissionSet("mplugin.kits.*");
    } 
    if (p.hasPermission("mplugin.vip")) {
      p.isPermissionSet("mplugin.vip");
      p.isPermissionSet("mplugin.kits.*");
    } 
    if (p.hasPermission("mplugin.normal"))
      p.isPermissionSet("mplugin.normal"); 
  }
}
