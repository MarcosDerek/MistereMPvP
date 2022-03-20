package me.main.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.main.Main;

public class Gladiator implements Listener {
  Main plugin;
  
  public boolean generateGlass;
  
  public Gladiator(Main main) {
    this.generateGlass = true;
    this.loc = new HashMap<>();
    this.block = new HashMap<>();
    this.plugin = main;
  }
  
  public static HashMap<String, String> fighting = new HashMap<>();
  
  public static HashMap<String, Location> old1 = new HashMap<>();
  
  public static HashMap<Player, Location> location = new HashMap<>();
  
  public HashMap<Player, Location> loc;
  
  public HashMap<Location, Block> block;
  
  public static int id1;
  
  public static int id2;
  
  @EventHandler
  public void blockBreak(final PlayerInteractEvent e) {
    final Player p = e.getPlayer();
    if (KitsManager.haskit(p, KitType.GLADIATOR) && 
      p.getItemInHand().getType() == Material.IRON_BARDING) {
      e.setCancelled(true);
      p.updateInventory();
      return;
    } 
    if (fighting.containsKey(p.getName()) && 
      e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.GLASS) {
      e.setCancelled(true);
      e.getClickedBlock().setType(Material.BEDROCK);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, new Runnable() {
            public void run() {
              if (Gladiator.fighting.containsKey(p.getName()))
                e.getClickedBlock().setType(Material.GLASS); 
            }
          },  60L);
    } 
  }
  
  @EventHandler
  public void playerQuit(PlayerQuitEvent e) {
    Player p = e.getPlayer();
    Player t = Bukkit.getServer().getPlayer(fighting.get(p.getName()));
    if (fighting.containsKey(p.getName())) {
      fighting.remove(t.getName());
      fighting.remove(p.getName());
      Location old = old1.get(p.getName());
      t.teleport(old);
      t.sendMessage(ChatColor.GREEN + "O player " + p.getName() + " desconectou e voce venceu!");
      Bukkit.getScheduler().cancelTask(id1);
      Bukkit.getScheduler().cancelTask(id2);
      t.removePotionEffect(PotionEffectType.WITHER);
      Location loc = location.get(p);
      List<Location> arenaID = new ArrayList<>();
      for (int bX = -10; bX <= 10; bX++) {
        for (int bZ = -10; bX <= 10; bZ++) {
          for (int bY = -1; bY <= 10; bY++) {
            if (bY == 10) {
              arenaID.add(loc.clone().add(bX, bY, bZ));
            } else if (bY == -1) {
              arenaID.add(loc.clone().add(bX, bY, bZ));
            } else if (bX == -10 || bX == 10 || bZ == -10 || bZ == 10) {
              arenaID.add(loc.clone().add(bX, bY, bZ));
            } 
          } 
        } 
      } 
      for (Location loc1 : arenaID) {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.block.get(loc1)).setType(Material.AIR);
      } 
    } 
  }
  
  @EventHandler
  public void playerDeath(PlayerDeathEvent e) {
    Player t = e.getEntity();
    Player p = Bukkit.getServer().getPlayer(fighting.get(t.getName()));
    if (fighting.containsKey(t.getName())) {
      Location old = old1.get(p.getName());
      t.teleport(old);
      t.sendMessage(ChatColor.GREEN + "O player " + p.getName() + " desconectou e voce venceu!");
      Bukkit.getScheduler().cancelTask(id1);
      Bukkit.getScheduler().cancelTask(id2);
      t.removePotionEffect(PotionEffectType.WITHER);
      Location loc = location.get(p);
      List<Location> arenaID = new ArrayList<>();
      for (int bX = -10; bX <= 10; bX++) {
        for (int bZ = -10; bX <= 10; bZ++) {
          for (int bY = -1; bY <= 10; bY++) {
            if (bY == 10) {
              arenaID.add(loc.clone().add(bX, bY, bZ));
            } else if (bY == -1) {
              arenaID.add(loc.clone().add(bX, bY, bZ));
            } else if (bX == -10 || bX == 10 || bZ == -10 || bZ == 10) {
              arenaID.add(loc.clone().add(bX, bY, bZ));
            } 
          } 
        } 
      } 
      for (Location loc1 : arenaID) {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.block.get(loc1)).setType(Material.AIR);
      } 
    } 
  }
  
  @EventHandler
  public void playerInteract(PlayerInteractEntityEvent e) {
    final Player p = e.getPlayer();
    final Player r = (Player)e.getRightClicked();
    if (e.getRightClicked() instanceof Player)
      if (KitsManager.haskit(p, KitType.GLADIATOR))
        if (p.getItemInHand().getType() == Material.IRON_BARDING) {
          Location loc1 = new Location(p.getWorld(), p.getLocation().getBlockX(), (p.getLocation().getBlockY() + 70), p.getLocation().getBlockZ());
          this.loc.put(p, loc1);
          this.loc.put(r, loc1);
          Location loc2 = new Location(p.getWorld(), (p.getLocation().getBlockX() + 8), (p.getLocation().getBlockY() + 73), (p.getLocation().getBlockZ() + 8));
          Location loc3 = new Location(p.getWorld(), (p.getLocation().getBlockX() - 8), (p.getLocation().getBlockY() + 73), (p.getLocation().getBlockZ() - 8));
          if (fighting.containsKey(p.getName()) || fighting.containsKey(r.getName())) {
            p.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Voce ja esta em combate!");
            return;
          } 
          if (this.generateGlass) {
            List<Location> arenaID = new ArrayList<>();
            arenaID.clear();
            for (int bX = -10; bX <= 10; bX++) {
              for (int bZ = -10; bZ <= 10; bZ++) {
                for (int bY = -1; bY <= 10; bY++) {
                  Block b = loc1.clone().add(bX, bY, bZ).getBlock();
                  if (!b.isEmpty()) {
                    p.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "Voce nao pode criar esta arena aqui!");
                    return;
                  } 
                  if (bY == 10) {
                    arenaID.add(loc1.clone().add(bX, bY, bZ));
                  } else if (bY == -1) {
                    arenaID.add(loc1.clone().add(bX, bY, bZ));
                  } else if (bX == 10 || bX == -10 || bZ == 10 || bZ == -10) {
                    arenaID.add(loc1.clone().add(bX, bY, bZ));
                  } 
                } 
              } 
            } 
            for (Location loc4 : arenaID) {
              loc4.getBlock().setType(Material.GLASS);
              this.block.put(loc4, loc4.getBlock());
            } 
            loc2.setYaw(135.0F);
            loc3.setYaw(-45.0F);
            p.teleport(loc2);
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
            p.sendMessage(ChatColor.YELLOW + "Voce puxou um player para 1v1 no gladiator!");
            p.sendMessage(ChatColor.YELLOW + "Voce tem 5 segundos de invencibilidade.");
            fighting.put(p.getName(), r.getName());
            r.teleport(loc3);
            r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
            r.sendMessage(ChatColor.YELLOW + "Voce foi puxado para 1v1 no gladiator!");
            r.sendMessage(ChatColor.YELLOW + "Voce tem 5 segundos de invencibilidade.");
            fighting.put(r.getName(), p.getName());
            r.teleport(loc3);
            id2 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, new Runnable() {
                  public void run() {
                    if (Gladiator.fighting.containsKey(p.getName()) && ((String)Gladiator.fighting.get(p.getName())).equalsIgnoreCase(r.getName()) && Gladiator.fighting.containsKey(r.getName()) && ((String)Gladiator.fighting.get(r.getName())).equalsIgnoreCase(p.getName())) {
                      Gladiator.fighting.remove(p.getName());
                      p.teleport(Gladiator.old1.get(p.getName()));
                      Gladiator.old1.remove(p.getName());
                      p.sendMessage(ChatColor.YELLOW + "A batalha chegou ao tempo maximo e nao houve vencedor!");
                      Gladiator.fighting.remove(r.getName());
                      r.teleport(Gladiator.old1.get(r.getName()));
                      Gladiator.old1.remove(r.getName());
                      r.sendMessage(ChatColor.YELLOW + "A batalha chegou ao tempo maximo e nao houve vencedor!");
                      Location loc = Gladiator.old1.get(p);
                      List<Location> arenaID = new ArrayList<>();
                      for (int bX = -10; bX <= 10; bX++) {
                        for (int bZ = -10; bX <= 10; bZ++) {
                          for (int bY = -1; bY <= 10; bY++) {
                            if (bY == 10) {
                              arenaID.add(loc.clone().add(bX, bY, bZ));
                            } else if (bY == -1) {
                              arenaID.add(loc.clone().add(bX, bY, bZ));
                            } else if (bX == -10 || bX == 10 || bZ == -10 || bZ == 10) {
                              arenaID.add(loc.clone().add(bX, bY, bZ));
                            } 
                          } 
                        } 
                      } 
                      for (Location loc1 : arenaID) {
                        loc1.getBlock().setType(Material.AIR);
                        ((Block)Gladiator.this.block.get(loc1)).setType(Material.AIR);
                      } 
                    } 
                  }
                }, 1200L);
          } 
        }   
  }
}