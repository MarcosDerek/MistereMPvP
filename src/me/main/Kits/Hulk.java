package me.main.Kits;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Hulk implements Listener {
  @EventHandler
  public void playerInteract(PlayerInteractEntityEvent e) {
    Player p = e.getPlayer();
    Entity target = e.getRightClicked();
    int up = 1;
    if (KitsManager.haskit(p, KitType.HULK)) {
      if (target == null)
        return; 
      if (target instanceof Player) {
        p.setPassenger(target);
        target.getLocation().setY(target.getLocation().getY() + up);
      } 
    } 
  }
}