package me.main.Kits;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Camel implements Listener {
  @EventHandler
  public void playerMove(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    if (KitsManager.haskit(p, KitType.CAMEL) && 
      p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND)
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 1)); 
  }
}