package me.main.Kits;

import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Viper implements Listener {
  @EventHandler
  public void entityDamage(EntityDamageByEntityEvent e) {
    if (e.getEntity() instanceof Player) {
      Player p = (Player)e.getEntity();
      if (e.getDamager() instanceof Player) {
        Player d = (Player)e.getDamager();
        if (KitsManager.haskit(d, KitType.VIPER)) {
          double r = (new Random()).nextDouble();
          if (r < 0.25D)
            p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 1), true); 
        } 
      } 
    } 
  }
}