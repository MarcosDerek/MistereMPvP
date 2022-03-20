package me.main.Events;

import me.main.Main;
import net.minecraft.server.v1_8_R3.EnumParticle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

public class DropClean implements Listener {
  Main plugin;
  
  public DropClean(Main main) {
    this.plugin = main;
  }
  
  public void spawnParticle(EnumParticle part, Location loc, int count) {}
  
  @EventHandler
  public void playerDropItem(final EntityDeathEvent e) {
    Bukkit.getScheduler().runTaskLater((Plugin)this.plugin, new Runnable() {
          public void run() {
            if (e.getEntityType() == EntityType.PLAYER) {
              Player p = (Player)e.getEntity();
              e.getDrops().clear();
              p.teleport(new Location(Bukkit.getWorld("home"), 0.5D, 50.5D, 0.5D));
            } else {
              return;
            } 
          }
        }, 20L);
  }
}