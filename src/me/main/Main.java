package me.main;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.main.BlocksRegen.ExplosionManager;
import me.main.Events.Death;
import me.main.Events.DropClean;
import me.main.Events.Join;
import me.main.Events.Settings;
import me.main.Events.Soup;

import me.main.Inventories.GUIKits;
import me.main.Inventories.Signs;

import me.main.Kits.Anchor;
import me.main.Kits.Camel;
import me.main.Kits.Endermage;
import me.main.Kits.Fisherman;
import me.main.Kits.Hulk;
import me.main.Kits.Kangaroo;
import me.main.Kits.Launcher;
import me.main.Kits.Ninja;
import me.main.Kits.Snail;
import me.main.Kits.Stomper;
import me.main.Kits.Thor;
import me.main.Kits.Urgal;
import me.main.Kits.Viper;
import me.main.PermissionsAndCommands.Chat;
import me.main.PermissionsAndCommands.Commands;
import me.main.PermissionsAndCommands.PermissionsEvents;
import me.main.Warps.Spawn;

public class Main extends JavaPlugin implements Listener {
	
	public static Main instance;
	
	@Override
	public void onLoad() {
		getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[MistereMPvP] The plugin is loading...");
		
		instance = this;
	}
	
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MistereMPvP] The plugin is enable.");
		
		//Register Events
		getServer().getPluginManager().registerEvents(this, this);
		

	    getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "MPlugin is enabled!");
	    
	    getServer().getPluginManager().registerEvents((Listener)new DropClean(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Death(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Join(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Settings(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Signs(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Soup(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new ExplosionManager(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new GUIKits(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Anchor(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Camel(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Endermage(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Fisherman(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Hulk(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Kangaroo(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Launcher(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Ninja(this), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Snail(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Stomper(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Thor(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Urgal(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Viper(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Spawn(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new Chat(), (Plugin)this);
	    getServer().getPluginManager().registerEvents((Listener)new PermissionsEvents(), (Plugin)this);

	    getCommand("invsee").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("tpall").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("chat").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("admin").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("tag").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("promote").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("gm").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("gamemode").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("spawn").setExecutor((CommandExecutor)new Commands(this));
	    getCommand("disconnect").setExecutor((CommandExecutor)new Commands(this));
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MistereMPvP] The plugin is disable.");
	}

}
