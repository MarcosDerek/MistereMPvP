package me.main.Kits;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class Anchor implements Listener {
  @EventHandler
  public void entityDamageByEntity(EntityDamageByEntityEvent e) {
    if (e.getDamager() instanceof Player && 
      e.getEntity() instanceof Player) {
      Player p = (Player)e.getDamager();
      Player target = (Player)e.getEntity();
      if (KitsManager.haskit(p, KitType.ANCHOR)) {
        p.setVelocity(new Vector());
        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 4.0F, 4.0F);
        target.setVelocity(new Vector());
      } 
    } 
  }
}
