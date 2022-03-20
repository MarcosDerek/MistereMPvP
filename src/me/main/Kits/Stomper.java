package me.main.Kits;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Stomper implements Listener {
  @EventHandler
  public void entityDamage(EntityDamageEvent e) {
    if (e.getEntity() instanceof Player) {
      Player p = (Player)e.getEntity();
      double damage = e.getDamage();
      if (KitsManager.haskit(p, KitType.STOMPER) && 
        e.getCause() == EntityDamageEvent.DamageCause.FALL) {
        for (Entity target : p.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
          if (target.getType() == EntityType.PLAYER) {
            if (!((Player)target).isSneaking())
              ((Player)target).damage(damage); 
            ((Player)target).playSound(target.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
          } 
        } 
        e.setDamage(4.0D);
      } 
    } 
  }
}