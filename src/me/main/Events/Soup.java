package me.main.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Soup implements Listener {
  @EventHandler
  public void playerInteract(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    Player player1 = p;
    if (e.getMaterial() == Material.MUSHROOM_SOUP && 
      player1.getHealth() != player1.getMaxHealth()) {
      if (player1.getHealth() > player1.getMaxHealth() - 7.0D) {
        player1.setHealth(player1.getMaxHealth());
      } else {
        player1.setHealth(player1.getHealth() + 7.0D);
      } 
      p.setItemInHand(new ItemStack(Material.BOWL));
    } 
  }
}