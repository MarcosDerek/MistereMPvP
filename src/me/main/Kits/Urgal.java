package me.main.Kits;

import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Urgal implements Listener {
  @EventHandler
  public void entityDamage(EntityDamageByEntityEvent e) {
    if (e.getEntity() instanceof Player) {
      Player p = (Player)e.getEntity();
      if (e.getDamager() instanceof Player && 
        KitsManager.haskit(p, KitType.URGAL)) {
        double r = (new Random()).nextDouble();
        if (r < 0.25D) {
          Player d = (Player)e.getDamager();
          d.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0), true);
        } 
      } 
    } 
  }
}