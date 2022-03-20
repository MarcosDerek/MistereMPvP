package me.main.PermissionsAndCommands;

import me.main.Main;
import me.main.Kits.KitsManager;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.inventivetalent.tabapi.TabAPI;

public class Commands implements CommandExecutor {
  Main plugin;
  
  public Commands(Main main) {
    this.inFake = new ArrayList<>();
    this.nick = new HashMap<>();
    this.fake = new HashMap<>();
    this.plugin = main;
  }
  
  public static ArrayList<String> adminMod = new ArrayList<>();
  
  public static boolean chatmuted = false;
  
  ArrayList<Player> inFake;
  
  HashMap<Player, Player> nick;
  
  HashMap<String, String> fake;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    final Player p = (Player)sender;
    PlayerInventory inv = p.getInventory();
    if (cmd.getName().equalsIgnoreCase("invsee"))
      if (p.hasPermission("mplugin.inv")) {
        if (args.length == 0) {
          p.sendMessage(ChatColor.YELLOW + "/inv [nick]");
          return true;
        } 
        Player target = Bukkit.getPlayerExact(args[0]);
        PlayerInventory targetInv = target.getInventory();
        p.openInventory((Inventory)targetInv);
      } else {
        return true;
      }  
    if (cmd.getName().equalsIgnoreCase("tpall"))
      if (p.hasPermission("mplugin.tpall")) {
        for (Player all : Bukkit.getServer().getOnlinePlayers())
          all.teleport((Entity)p); 
      } else {
        return true;
      }  
    if (cmd.getName().equalsIgnoreCase("chat"))
      if (p.hasPermission("mplugin.chat.manage")) {
        if (args.length == 0) {
          p.sendMessage(ChatColor.YELLOW + "/chat [clear, mute, unmute]");
          return true;
        } 
        if (args[0].equalsIgnoreCase("clear")) {
          for (int i = 0; i < 100; i++)
            Bukkit.getServer().broadcastMessage(" "); 
          Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "The chat was cleaner by " + p.getName() + ".");
        } 
        if (args[0].equalsIgnoreCase("mute"))
          if (!chatmuted) {
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "The chat was muted by a staff member: " + p.getName() + ".");
            chatmuted = true;
          } else {
            p.sendMessage(ChatColor.RED + "The chat is already muted.");
          }  
        if (args[0].equalsIgnoreCase("unmute"))
          if (chatmuted) {
            Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "The chat was unmuted by a staff member: " + p.getName() + ".");
            chatmuted = false;
          } else {
            p.sendMessage(ChatColor.RED + "The chat is already umuted.");
          }  
      } else {
        return true;
      }  
    if (cmd.getName().equalsIgnoreCase("admin"))
      if (p.hasPermission("mplugin.adminmode")) {
        if (!adminMod.contains(p.getName())) {
          adminMod.add(p.getName());
          for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.hasPermission("mplugin.adminmode")) {
              all.showPlayer(p);
              continue;
            } 
            all.hidePlayer(p);
          } 
          p.sendMessage(ChatColor.GREEN + "You are on admin mode.");
          p.setGameMode(GameMode.CREATIVE);
        } else if (adminMod.contains(p.getName())) {
          adminMod.remove(p.getName());
          for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.hasPermission("mplugin.adminmode")) {
              all.showPlayer(p);
              continue;
            } 
            all.showPlayer(p);
          } 
          p.sendMessage(ChatColor.YELLOW + "You left admin mode.");
          p.setGameMode(GameMode.SURVIVAL);
        } 
      } else {
        return true;
      }  
    if (cmd.getName().equalsIgnoreCase("tag")) {
      if (args.length == 0) {
        p.sendMessage(ChatColor.YELLOW + "/tag [owner, admin, mod+, mod, youtuber, pro, mvp, vip, normal]");
        return true;
      } 
      if (p.hasPermission("mplugin.owner") && args[0].equalsIgnoreCase("owner")) {
        if (args.length == 0) {
          p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip, mvp, pro, youtuber, mod, mod+, admin, owner]");
          return true;
        } 
        TabAPI.setHeaderFooter(p, ChatColor.DARK_RED + ChatColor.BOLD.toString() + "[OWNER] " + ChatColor.RESET + ChatColor.DARK_RED + p.getName() + ChatColor.RESET, ChatColor.DARK_RED + ChatColor.BOLD.toString() + "[OWNER] " + ChatColor.RESET + ChatColor.DARK_RED + p.getName() + ChatColor.RESET);
        p.sendMessage(ChatColor.GREEN + "Tag changed to " + ChatColor.DARK_RED + "OWNER");
        p.setPlayerListName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "[OWNER] " + ChatColor.RESET + ChatColor.DARK_RED + p.getName() + ChatColor.RESET);
        p.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "[OWNER] " + ChatColor.RESET + ChatColor.DARK_RED + p.getName() + ChatColor.RESET);
      } 
      if (p.hasPermission("mplugin.admin") && args[0].equalsIgnoreCase("admin")) {
        if (args.length == 0) {
          p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip, mvp, pro, youtuber, mod, mod+, admin]");
          return true;
        }
        
        TabAPI.setHeaderFooter(p, ChatColor.RED + ChatColor.BOLD.toString() + "[ADMIN] " + ChatColor.RESET + ChatColor.RED + p.getName() + ChatColor.RESET, ChatColor.RED + ChatColor.BOLD.toString() + "[ADMIN] " + ChatColor.RESET + ChatColor.RED + p.getName() + ChatColor.RESET);
        p.sendMessage(ChatColor.GREEN + "Tag changed to " + ChatColor.RED + "ADMIN");
        p.setPlayerListName(ChatColor.RED + ChatColor.BOLD.toString() + "[ADMIN] " + ChatColor.RESET + ChatColor.RED + p.getName() + ChatColor.RESET);
        p.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "[ADMIN] " + ChatColor.RESET + ChatColor.RED + p.getName() + ChatColor.RESET);
      } 
      if (p.hasPermission("mplugin.mod+") && args[0].equalsIgnoreCase("mod+")) {
        if (args.length == 0) {
          p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip, mvp, pro, youtuber, mod, mod+]");
          return true;
        } 
        p.sendMessage(ChatColor.GREEN + "Tag changed to " + ChatColor.DARK_PURPLE + "MOD+");
        p.setPlayerListName(ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + ChatColor.BOLD.toString() + "[MOD+] " + ChatColor.RESET + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + p.getName() + ChatColor.RESET);
        p.setDisplayName(ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + ChatColor.BOLD.toString() + "[MOD+] " + ChatColor.RESET + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + p.getName() + ChatColor.RESET);
      } 
      if (p.hasPermission("mplugin.mod") && args[0].equalsIgnoreCase("mod") && 
        args.length == 0) {
        p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip, mvp, pro, youtuber, mod]");
        return true;
      } 
      if (p.hasPermission("mplugin.youtuber") && args[0].equalsIgnoreCase("youtuber") && 
        args.length == 0) {
        p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip, mvp, pro, youtuber]");
        return true;
      } 
      if (p.hasPermission("mplugin.pro") && args[0].equalsIgnoreCase("pro") && 
        args.length == 0) {
        p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip, mvp, pro]");
        return true;
      } 
      if (p.hasPermission("mplugin.mvp") && args[0].equalsIgnoreCase("mvp") && 
        args.length == 0) {
        p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip, mvp]");
        return true;
      } 
      if (p.hasPermission("mplugin.vip") && args[0].equalsIgnoreCase("vip") && 
        args.length == 0) {
        p.sendMessage(ChatColor.YELLOW + "/tag [normal, vip]");
        return true;
      } 
      if (args[0].equalsIgnoreCase("normal") && 
        args.length == 0) {
        p.sendMessage(ChatColor.YELLOW + "/tag [normal]");
        return true;
      } 
    } 
    if (cmd.getName().equalsIgnoreCase("promote")) {
      Player target = Bukkit.getPlayerExact(args[0]);
      if (p.hasPermission("mplugin.promote")) {
        if (args.length == 0) {
          sender.sendMessage(ChatColor.AQUA + "/promote [nick]");
          return true;
        } 
        if (p.hasPermission("mplugin.promote.owner") && 
          args.length == 1) {
          p.sendMessage(ChatColor.AQUA + "/promote [nick] [vip, mvp, pro, mod, mod+, admin, dono]");
          return true;
        } 
        if (p.hasPermission("mplugin.promote.admin") && 
          args.length == 1) {
          p.sendMessage(ChatColor.AQUA + "/promote [nick] [vip, mvp, pro, mod, mod+, admin]");
          return true;
        } 
        if (p.hasPermission("mplugin.promote.dono")) {
          if (args[1].equalsIgnoreCase("owner")) {
            p.isPermissionSet("mplugin.owner");
            p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.DARK_RED + "OWNER" + ChatColor.GREEN + " to " + target.getName() + ".");
            target.setPlayerListName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "[OWNER] " + ChatColor.RESET + ChatColor.DARK_RED + target.getName() + ChatColor.RESET);
            target.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "[OWNER] " + ChatColor.RESET + ChatColor.DARK_RED + target.getName() + ChatColor.RESET);
            target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.DARK_RED + "OWNER" + 
                ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
            target.setOp(true);
          } 
          if (p.hasPermission("mplugin.promote.dono") && 
            args[1].equalsIgnoreCase("admin")) {
            p.isPermissionSet("mplugin.admin");
            p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.RED + "ADMIN" + ChatColor.GREEN + " to " + target.getName() + ".");
            target.setPlayerListName(ChatColor.RED + ChatColor.BOLD.toString() + "[ADMIN] " + ChatColor.RESET + ChatColor.RED + target.getName() + ChatColor.RESET);
            target.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "[ADMIN] " + ChatColor.RESET + ChatColor.RED + target.getName() + ChatColor.RESET);
            target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.RED + "ADMIN" + 
                ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
            target.isPermissionSet("mplugin.construction");
            target.isPermissionSet("mplugin.promote.admin");
            target.isPermissionSet("mplugin.admin");
            target.isPermissionSet("mplugin.adminmode");
            target.isPermissionSet("mplugin.events.manage");
            target.isPermissionSet("mplugin.gamemode");
            target.isPermissionSet("mplugin.kits.*");
          } 
          if (p.hasPermission("mplugin.promote.admin")) {
            if (args[1].equalsIgnoreCase("modplus")) {
              p.isPermissionSet("mplugin.modplus");
              p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + "MOD+" + ChatColor.GREEN + " to " + target.getName() + ".");
              target.setPlayerListName(ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + ChatColor.BOLD.toString() + "[MOD+] " + ChatColor.RESET + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + target.getName() + ChatColor.RESET);
              target.setDisplayName(ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + ChatColor.BOLD.toString() + "[MOD+] " + ChatColor.RESET + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + target.getName() + ChatColor.RESET);
              target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.DARK_PURPLE + ChatColor.ITALIC.toString() + "MOD+" + 
                  ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
              target.isPermissionSet("mplugin.admin");
              target.isPermissionSet("mplugin.adminmode");
              target.isPermissionSet("mplugin.events.manage");
              target.isPermissionSet("mplugin.gamemode");
              target.isPermissionSet("mplugin.kits.*");
            } 
            if (args[1].equalsIgnoreCase("mod")) {
              p.isPermissionSet("mplugin.mod");
              p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.LIGHT_PURPLE + "MOD" + ChatColor.GREEN + " to " + target.getName() + ".");
              target.setPlayerListName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "[MOD] " + ChatColor.RESET + ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.RESET);
              target.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "[MOD] " + ChatColor.RESET + ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.RESET);
              target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.LIGHT_PURPLE + "MOD" + 
                  ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
            } 
            if (args[1].equalsIgnoreCase("youtuber")) {
              p.isPermissionSet("mplugin.youtuber");
              p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.AQUA + "YOUTUBER" + ChatColor.GREEN + " to " + target.getName() + ".");
              target.setPlayerListName(ChatColor.AQUA + ChatColor.BOLD.toString() + "[YOUTUBER] " + ChatColor.RESET + ChatColor.AQUA + target.getName() + ChatColor.RESET);
              target.setDisplayName(ChatColor.AQUA + ChatColor.BOLD.toString() + "[YOUTUBER] " + ChatColor.RESET + ChatColor.AQUA + target.getName() + ChatColor.RESET);
              target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.AQUA + "YOUTUBER" + 
                  ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
              target.isPermissionSet("mplugin.kits.*");
            } 
            if (args[1].equalsIgnoreCase("pro")) {
              p.isPermissionSet("mplugin.pro");
              p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.GOLD + "PRO" + ChatColor.GREEN + " to " + target.getName() + ".");
              target.setPlayerListName(ChatColor.GOLD + ChatColor.BOLD.toString() + "[PRO] " + ChatColor.RESET + ChatColor.GOLD + target.getName() + ChatColor.RESET);
              target.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "[PRO] " + ChatColor.RESET + ChatColor.GOLD + target.getName() + ChatColor.RESET);
              target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.GOLD + "PRO" + 
                  ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
              target.isPermissionSet("mplugin.kits.*");
            } 
            if (args[1].equalsIgnoreCase("mvp")) {
              p.isPermissionSet("mplugin.mvp");
              p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.BLUE + "MVP" + ChatColor.GREEN + " to " + target.getName() + ".");
              target.setPlayerListName(ChatColor.BLUE + ChatColor.BOLD.toString() + "[MVP] " + ChatColor.RESET + ChatColor.BLUE + target.getName() + ChatColor.RESET);
              target.setDisplayName(ChatColor.BLUE + ChatColor.BOLD.toString() + "[MVP] " + ChatColor.RESET + ChatColor.BLUE + target.getName() + ChatColor.RESET);
              target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.BLUE + "MVP" + 
                  ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
            } 
            if (args[1].equalsIgnoreCase("vip")) {
              p.isPermissionSet("mplugin.vip");
              p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.GREEN + "VIP" + ChatColor.GREEN + " to " + target.getName() + ".");
              target.setPlayerListName(ChatColor.GREEN + ChatColor.BOLD.toString() + "[VIP] " + ChatColor.RESET + ChatColor.GREEN + target.getName() + ChatColor.RESET);
              target.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "[VIP] " + ChatColor.RESET + ChatColor.GREEN + target.getName() + ChatColor.RESET);
              target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations! You just recive " + ChatColor.GREEN + "VIP" + 
                  ChatColor.GOLD + ChatColor.BOLD.toString() + ", enjoy!");
            } 
            if (args[1].equalsIgnoreCase("normal")) {
              p.isPermissionSet("mplugin.normal");
              p.sendMessage(ChatColor.GREEN + "You gave " + ChatColor.WHITE + "NORMAL" + ChatColor.GREEN + " to " + target.getName() + ".");
              target.setPlayerListName(ChatColor.RESET + target.getName());
              target.setDisplayName(ChatColor.RESET + target.getName());
              p.sendMessage(ChatColor.GREEN + "Now you are promote to " + ChatColor.WHITE + "NORMAL" + ChatColor.GREEN + ".");
            } 
          } 
        } 
      } else {
        sender.sendMessage(ChatColor.RED + "You don't have permission for this command.");
        return true;
      } 
    } 
    if (cmd.getName().equalsIgnoreCase("event")) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.AQUA + "/event [reidamesa]");
        return true;
      } 
      if (args[0].equalsIgnoreCase("reidamesa")) {
        Location reidamesaLoc = new Location(Bukkit.getWorld("reidamesa"), 0.5D, 30.5D, 6.5D, -180.0F, 0.0F);
        if (p.hasPermission("mplugin.events.manage") && 
          args.length == 1) {
          p.sendMessage(ChatColor.AQUA + "/event reidamesa [join, start, stop]");
          return true;
        } 
        if (args[1].equalsIgnoreCase("join")) {
          p.teleport(reidamesaLoc);
          KitsManager.kitpvp.remove(p.getName());
          inv.setHelmet(new ItemStack(Material.IRON_HELMET));
          inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
          inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
          inv.setBoots(new ItemStack(Material.IRON_BOOTS));
          inv.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
          ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
          byte b;
          int i;
          ItemStack[] arrayOfItemStack;
          for (i = (arrayOfItemStack = p.getInventory().getContents()).length, b = 0; b < i; ) {
            ItemStack itemStack = arrayOfItemStack[b];
            if (itemStack == null) {
              ItemStack itemsoup = new ItemStack(soup);
              inv.addItem(new ItemStack[] { new ItemStack(itemsoup) });
            } 
            b++;
          } 
        } 
        if (args[1].equalsIgnoreCase("start"))
          if (p.hasPermission("mplugin.events.manage")) {
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "==============================================================");
            Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "Event rei da mesa has been started. Type </event reidamesa join> to join the event.");
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "==============================================================");
            p.teleport(reidamesaLoc);
            inv.clear();
            p.setGameMode(GameMode.CREATIVE);
            inv.addItem(new ItemStack[] { new ItemStack(Material.FISHING_ROD) });
            KitsManager.kitpvp.remove(p.getName());
          } else {
            p.sendMessage(ChatColor.GREEN + "Type </event reidamesa join> to join the event.");
            return true;
          }  
        if (args[1].equalsIgnoreCase("stop"))
          if (p.hasPermission("mplugin.events.manage")) {
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "====================================");
            Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "Event rei da mesa has been stoped.");
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "====================================");
            p.teleport(reidamesaLoc);
          } else {
            p.sendMessage(ChatColor.GREEN + "Type </event reidamesa join> to join the event.");
          }  
      } 
    } 
    if (cmd.getName().equalsIgnoreCase("gamemode"))
      if (p.hasPermission("mplugin.gamemode")) {
        if (args.length == 0) {
          sender.sendMessage(ChatColor.AQUA + "/gamemode [0, 1]");
          return true;
        } 
        if (args[0].equalsIgnoreCase("0")) {
          p.setGameMode(GameMode.SURVIVAL);
          sender.sendMessage(ChatColor.GREEN + "Your game mode has changed to survival.");
        } 
        if (args[0].equalsIgnoreCase("1")) {
          p.setGameMode(GameMode.CREATIVE);
          sender.sendMessage(ChatColor.GREEN + "Your game mode has changed to creative.");
        } 
      } else {
        p.sendMessage(ChatColor.RED + "You don't have permission for this command.");
      }  
    if (cmd.getName().equalsIgnoreCase("gm"))
      if (p.hasPermission("mplugin.gamemode")) {
        if (args.length == 0) {
          sender.sendMessage(ChatColor.AQUA + "/gamemode [0, 1]");
          return true;
        } 
        if (args[0].equalsIgnoreCase("0")) {
          p.setGameMode(GameMode.SURVIVAL);
          sender.sendMessage(ChatColor.GREEN + "Your game mode has changed to survival.");
        } 
        if (args[0].equalsIgnoreCase("1")) {
          p.setGameMode(GameMode.CREATIVE);
          sender.sendMessage(ChatColor.GREEN + "Your game mode has changed to creative.");
        } 
      } else {
        p.sendMessage(ChatColor.RED + "You don't have permission for this command.");
      }  
    if (cmd.getName().equalsIgnoreCase("spawn")) {
        p.sendMessage(ChatColor.YELLOW + "Don't move for 3 seconds to go to the spawn.");
        Bukkit.getServer().getScheduler().runTaskLater((Plugin)this.plugin, new Runnable() {
              public void run() {
                ItemStack hubs = new ItemStack(Material.COMPASS);
                ItemMeta hubsMeta = hubs.getItemMeta();
                hubsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Hubs");
                hubs.setItemMeta(hubsMeta);
                ItemStack kits = new ItemStack(Material.CHEST);
                ItemMeta kitsMeta = hubs.getItemMeta();
                kitsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Kits");
                kits.setItemMeta(kitsMeta);
                p.teleport(new Location(Bukkit.getServer().getWorld("home"), 0.5D, 48.5D, 0.5D, -180.0F, 0.0F));
                p.getInventory().clear();
                p.removePotionEffect(PotionEffectType.SPEED);
                p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                p.setHealth(20.0D);
                p.setFoodLevel(20);
                p.setGameMode(GameMode.SURVIVAL);
                p.getInventory().setItem(1, hubs);
                p.getInventory().setItem(4, kits);
                KitsManager.kitpvp.remove(p.getName());
              }
            }, 60L);
      }  
    if (cmd.getName().equalsIgnoreCase("disconnect"))
      Bukkit.getServer().getPlayer(p.getName()).kickPlayer("Disconnected"); 
    return true;
  }
}