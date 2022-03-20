package me.main.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class Fisherman implements Listener {
  @EventHandler
  public void playerFishing(PlayerFishEvent e) {
    Player p = e.getPlayer();
    if (KitsManager.haskit(p, KitType.FISHERMAN) && 
      p.getItemInHand().getType() == Material.FISHING_ROD && 
      e.getCaught() != null)
      e.getCaught().teleport(p.getLocation().setDirection(e.getCaught().getLocation().getDirection())); 
  }
}