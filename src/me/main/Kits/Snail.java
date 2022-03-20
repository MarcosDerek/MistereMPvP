package me.main.Kits;

import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Snail implements Listener {
  @EventHandler
  public void entityDamage(EntityDamageByEntityEvent e) {
    if (e.getEntity() instanceof Player && 
      e.getDamager() instanceof Player) {
      Player p = (Player)e.getEntity();
      if (KitsManager.haskit(p, KitType.SNAIL)) {
        double r = (new Random()).nextDouble();
        if (r < 0.25D) {
          Player t = (Player)e.getEntity();
          t.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1), true);
        } 
      } 
    } 
  }
}