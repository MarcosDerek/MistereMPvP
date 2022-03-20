package me.main.Kits;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.main.Main;

public class Endermage implements Listener {
  Main plugin;
  
  public Endermage(Main main) {
    this.plugin = main;
  }
  
  @EventHandler
  public void playerInteract(PlayerInteractEvent e) {
    final Player p = e.getPlayer();
    Action a = e.getAction();
    if (KitsManager.haskit(p, KitType.ENDERMAGE) && 
      a == Action.RIGHT_CLICK_BLOCK && 
      e.getItem().getType() == Material.ENDER_PORTAL_FRAME) {
      e.setCancelled(true);
      final PlayerInventory pInv = p.getInventory();
      final List<Entity> target = p.getNearbyEntities(3.0D, 256.0D, 3.0D);
      final Location bl = e.getClickedBlock().getLocation();
      final Location blUp = e.getClickedBlock().getLocation().add(0.0D, 1.0D, 0.0D);
      final Material bType = e.getClickedBlock().getType();
      bl.getBlock().setType(Material.ENDER_PORTAL_FRAME);
      pInv.setItemInHand(new ItemStack(Material.AIR));
      Bukkit.getServer().getScheduler().runTaskLater((Plugin)this.plugin, new Runnable() {
            public void run() {
              for (Entity ent : target) {
                if (ent instanceof Player) {
                  ((Player)ent).teleport(p.getLocation());
                  p.teleport(blUp);
                } 
              } 
              ItemStack endermage = new ItemStack(Material.ENDER_PORTAL_FRAME);
              ItemMeta endermageMeta = endermage.getItemMeta();
              endermageMeta.setDisplayName(ChatColor.GREEN + "Endermage");
              endermageMeta.setLore(Arrays.asList(new String[] { "Puxe seus adversarios com seu portal." } ));
              endermage.setItemMeta(endermageMeta);
              bl.getBlock().setType(bType);
              pInv.addItem(new ItemStack[] { endermage } );
            }
          },  60L);
    } 
  }
}
