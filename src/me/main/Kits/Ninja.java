package me.main.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import me.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Ninja implements Listener {
  private HashMap<String, Player> ninja = new HashMap<>();
  
  private HashMap<String, Integer> countdown = new HashMap<>();
  
  ArrayList<Player> cooldown = new ArrayList<>();
  
  Main plugin;
  
  public Ninja(Main main) {
    this.plugin = main;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void entityDamgeByEntity(EntityDamageByEntityEvent e) {
    if (e.getDamager() instanceof Player) {
      final Player p = (Player)e.getDamager();
      if (e.getEntity() instanceof Player) {
        Player target = (Player)e.getEntity();
        this.ninja.put(p.getName(), target);
        this.countdown.put(p.getName(), Integer.valueOf(10));
        Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask((Plugin)this.plugin, new Runnable() {
              public void run() {
                if (((Integer)Ninja.this.countdown.get(p.getName())).intValue() <= 0) {
                  if (KitsManager.haskit(p, KitType.NINJA))
                    p.sendMessage(ChatColor.RED + "You don't have a target."); 
                  Ninja.this.ninja.remove(p.getName());
                } 
              }
            }, 200L);
      } 
    } 
  }
  
  @EventHandler
  public void playerToggle(PlayerToggleSneakEvent e) {
    final Player p = e.getPlayer();
    if (KitsManager.haskit(p, KitType.NINJA) && 
      !this.cooldown.contains(p) && 
      p.isSneaking()) {
      Player target = this.ninja.get(p.getName());
      if (p.getLocation().distance(target.getLocation()) <= 40.0D) {
        p.teleport((Entity)target);
        this.cooldown.add(p);
        (new BukkitRunnable() {
            public void run() {
              Ninja.this.cooldown.remove(p);
              p.sendMessage(ChatColor.GREEN + "You already can use your kit.");
            }
          }).runTaskLater((Plugin)this.plugin, 200L);
      } 
    } 
  }
}
