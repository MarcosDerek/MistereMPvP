package me.main.Events;

import me.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

public class Settings implements Listener {
	public Main plugin;

	public Settings(Main main) {
		this.plugin = main;
	}

	@EventHandler
	public void q(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
		e.setCancelled(true);
	}

	@EventHandler
	public void weatherChange(WeatherChangeEvent e) {
		if (e.toWeatherState())
			e.setCancelled(true);
	}

	@EventHandler
	public void itemSpawn(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().runTaskLater((Plugin) this.plugin, new Runnable() {
			public void run() {
				World w = e.getEntity().getLocation().getWorld();
				// w.spawnParticle(EnumParticle.SMOKE_LARGE, e.getEntity().getLocation(), 7,
				// 0.029999999329447746D, 0.019999999552965164D, 0.029999999329447746D,
				// 0.029999999329447746D);
				e.getEntity().remove();
			}
		}, 60L);
	}

	@EventHandler
	public void playerPickup(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (!p.getLocation().getWorld().getName().equalsIgnoreCase("hg"))
			e.setCancelled(true);
	}

	@EventHandler
	public void entityDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (p.getInventory().getHelmet() != null)
				p.getInventory().getHelmet().setDurability((short) 0);
			if (p.getInventory().getChestplate() != null)
				p.getInventory().getChestplate().setDurability((short) 0);
			if (p.getInventory().getLeggings() != null)
				p.getInventory().getLeggings().setDurability((short) 0);
			if (p.getInventory().getBoots() != null)
				p.getInventory().getBoots().setDurability((short) 0);
		}
	}

	@EventHandler
	public void entityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player d = (Player) e.getDamager();
			if (d.getItemInHand() != null)
				d.getItemInHand().setDurability((short) 0);
		}
	}

	@EventHandler
	public void playerDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		Material t = e.getItemDrop().getItemStack().getType();
		if (!p.getLocation().getWorld().getName().equalsIgnoreCase("hg") && (t.equals(Material.WOOD_SWORD)
				|| t.equals(Material.STONE_SWORD) || t.equals(Material.IRON_SWORD) || t.equals(Material.DIAMOND_SWORD)))
			e.setCancelled(true);
	}

	@EventHandler
	public void playerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("mplugin.plugins") && (e.getMessage().toLowerCase().startsWith("/pl")
				|| e.getMessage().toLowerCase().startsWith("/plugins")
				|| e.getMessage().toLowerCase().startsWith("/ver") || e.getMessage().toLowerCase().startsWith("/?")
				|| e.getMessage().toLowerCase().startsWith("?") || e.getMessage().toLowerCase().startsWith("/help")
				|| e.getMessage().toLowerCase().startsWith("/version")
				|| e.getMessage().toLowerCase().startsWith("/icanhasbukkit")
				|| e.getMessage().toLowerCase().startsWith("/about")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:plugins")))
			e.setCancelled(true);
	}
}