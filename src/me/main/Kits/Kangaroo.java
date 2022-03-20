package me.main.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Kangaroo implements Listener {
  HashMap<String, Integer> dash = new HashMap<>();
  
  ArrayList<String> f = new ArrayList<>();
  
  @EventHandler
  public void playerInteract(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (KitsManager.haskit(p, KitType.KANGAROO) && 
      p.getItemInHand().getType() == Material.FIREWORK) {
      e.setCancelled(true);
      if (p.isSneaking()) {
        if (!this.f.contains(p.getName())) {
          p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
          p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
          this.dash.put(p.getName(), Integer.valueOf(1));
        } else if (((Integer)this.dash.get(p.getName())).intValue() != 2) {
          p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
          p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
          this.dash.put(p.getName(), Integer.valueOf(2));
        } 
      } else if (!this.f.contains(p.getName())) {
        p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
        this.dash.put(p.getName(), Integer.valueOf(1));
      } else if (((Integer)this.dash.get(p.getName())).intValue() != 2) {
        p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
        this.dash.put(p.getName(), Integer.valueOf(2));
      } 
    } 
  }
  
  @EventHandler
  public void playerMove(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    if (KitsManager.haskit(p, KitType.KANGAROO))
      if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
        this.f.add(p.getName());
      } else {
        if (p.getLocation().getBlock().getType() == Material.AIR) {
          this.dash.put(p.getName(), Integer.valueOf(0));
          this.f.remove(p.getName());
        } 
        if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR || p.getLocation().getBlock().getType() == Material.AIR) {
          this.dash.put(p.getName(), Integer.valueOf(0));
          this.f.remove(p.getName());
        } 
      }  
  }
  
  @EventHandler
  public void entityDamage(EntityDamageEvent e) {
    if (e.getEntity() instanceof Player) {
      Player p = (Player)e.getEntity();
      if (KitsManager.haskit(p, KitType.KANGAROO) && 
        e.getCause() == EntityDamageEvent.DamageCause.FALL)
        e.setDamage(5.0D); 
    } 
  }
}