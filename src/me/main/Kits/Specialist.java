package me.main.Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Specialist implements Listener {
  @EventHandler
  public void playerDeath(PlayerDeathEvent e) {
    Player p = e.getEntity().getKiller();
    Player target = e.getEntity().getPlayer();
    if (KitsManager.haskit(p, KitType.SPECIALIST) && 
      p instanceof Player && target instanceof Player)
      p.setExp(p.getExp() + 0.25F); 
  }
}