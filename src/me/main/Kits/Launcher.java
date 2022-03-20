package me.main.Kits;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Launcher implements Listener {
  @EventHandler
  public void playerMove(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE)
      p.setVelocity(p.getVelocity().setY(4.0D)); 
  }
}