package me.main.Kits;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Thor implements Listener {
  @EventHandler
  public void playerInteract(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    Action a = e.getAction();
    if (KitsManager.haskit(p, KitType.THOR) && 
      p.getItemInHand().getType() == Material.WOOD_AXE && 
      a == Action.RIGHT_CLICK_BLOCK) {
      Location bl = e.getClickedBlock().getLocation();
      p.getLocation().getWorld().strikeLightning(bl);
    } 
  }
  
  @EventHandler
  public void entityDamage(EntityDamageByEntityEvent e) {
    if (e.getEntity() instanceof Player) {
      Player p = (Player)e.getEntity();
      if (KitsManager.haskit(p, KitType.THOR))
        if (e.getCause().equals(EntityDamageEvent.DamageCause.LIGHTNING))
          e.setCancelled(true);  
    } 
  }
}