package me.main.PermissionsAndCommands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PermissionsEvents implements Listener {
  @EventHandler
  public void breakBlock(BlockBreakEvent e) {
    Player p = e.getPlayer();
    if (p.hasPermission("mplugin.construction")) {
      e.setCancelled(false);
    } else {
      e.setCancelled(true);
    } 
  }
  
  @EventHandler
  public void placeBlock(BlockPlaceEvent e) {
    Player p = e.getPlayer();
    if (p.hasPermission("mplugin.construction")) {
      e.setCancelled(false);
    } else {
      e.setCancelled(true);
    } 
  }
}