package me.main.PermissionsAndCommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
  @EventHandler
  public void asyncPlayerChat(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();
    if (Commands.chatmuted && !p.hasPermission("mplugin.mod") && !p.hasPermission("mplugin.mod+") && !p.hasPermission("mplugin.admin") && !p.hasPermission("mplugin.owner")) {
      e.setCancelled(true);
      p.sendMessage(ChatColor.YELLOW + "The chat is muted for all by an member of the staff.");
    } 
  }
}
